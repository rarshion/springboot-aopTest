package com.example.aop_inject_demo;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CGLibContainer {
	
	
	//定义连接通知类型，前/后/异常
	public enum InterceptPoint {
		BEFORE, AFTER, EXCEPTION
	}
	
	//定义切面类数组
	static Class<?>[] aspects = new Class<?>[] { ServiceLogAspect.class, ExceptionAspect.class };
	
	//定义需要插入方法的类与连接点方法的map
	static Map<Class<?>, Map<InterceptPoint, List<Method>>> interceptMethodsMap = new HashMap<>();
	
	//生成执行方法链
	private static void init() {
		//遍历定义的切面类列表
		for (Class<?> cls : aspects) {
			Aspect aspect = cls.getAnnotation(Aspect.class);
			if (aspect != null) {
				//扫描切面类中的方法
				//获取切面类中before方法元数据对象
				Method before = getMethod(cls, "before", new Class<?>[] {Object.class, Method.class, Object[].class });
				//获取切面类中after方法元数据对象
				Method after = getMethod(cls, "after", new Class<?>[] { Object.class, Method.class, Object[].class, Object.class });
				//获取切面类中exception方法元数据对象
				Method exception = getMethod(cls, "exception", new Class<?>[] { Object.class, Method.class, Object[].class, Throwable.class });
				Class<?>[] intercepttedArr = aspect.value(); //获取需要被代理的类
				//将方法对象添加到对应的拦截方法链中
				for (Class<?> interceptted : intercepttedArr) {
					addInterceptMethod(interceptted, InterceptPoint.BEFORE, before);
					addInterceptMethod(interceptted, InterceptPoint.AFTER, after);
					addInterceptMethod(interceptted, InterceptPoint.EXCEPTION, exception);
				}
			}
		}
	}

	private static Method getMethod(Class<?> cls, String name, Class<?>[] paramTypes) {
		try {
			return cls.getMethod(name, paramTypes);
		} catch (NoSuchMethodException e) {
			return null;
		}
	}

	private static void addInterceptMethod(Class<?> cls, InterceptPoint point, Method method) {
		if (method == null) {
			return;
		}
		Map<InterceptPoint, List<Method>> map = interceptMethodsMap.get(cls);
		if (map == null) {
			map = new HashMap<>();
			interceptMethodsMap.put(cls, map);
		}
		List<Method> methods = map.get(point);
		if (methods == null) {
			methods = new ArrayList<>();
			map.put(point, methods);
		}
		methods.add(method);
	}
	
	//定义拦截方法类
	static class AspectInterceptor implements MethodInterceptor {
		@Override
		public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
			//获取被代理类的before方法链
			List<Method> beforeMethods = getInterceptMethods(object.getClass().getSuperclass(), InterceptPoint.BEFORE);
			//逐个调用链中的方法
			for (Method m : beforeMethods) {
				m.invoke(null, new Object[] { object, method, args });
			}
			
			try {
				//调用被代理类的原始方法
				Object result = proxy.invokeSuper(object, args);
				//获取被代理类的after方法链
				List<Method> afterMethods = getInterceptMethods(object.getClass().getSuperclass(), InterceptPoint.AFTER);
				//逐个调用链中的方法
				for (Method m : afterMethods) {
					m.invoke(null, new Object[] { object, method, args, result });
				}
				return result;
			} catch (Throwable e) {
				//获取被代理类的exception方法链
				List<Method> exceptionMethods = getInterceptMethods(object.getClass().getSuperclass(), InterceptPoint.EXCEPTION);
				//逐个调用链中的方法
				for (Method m : exceptionMethods) {
					m.invoke(null, new Object[] { object, method, args, e });
				}
				throw e;
			}
		}
	}
	
	/**
	 * 根据连接点获取拦截方法链
	 */
	static List<Method> getInterceptMethods(Class<?> cls, InterceptPoint point) {
		Map<InterceptPoint, List<Method>> map = interceptMethodsMap.get(cls);
		if (map == null) {
			return Collections.emptyList();
		}
		List<Method> methods = map.get(point);
		if (methods == null) {
			return Collections.emptyList();
		}
		return methods;
	}
	
	//生成代理对象
	private static <T> T createInstance(Class<T> cls) throws InstantiationException, IllegalAccessException {
		if (!interceptMethodsMap.containsKey(cls)) {
			return cls.newInstance();
		}
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(cls); //设置被代理类
		enhancer.setCallback(new AspectInterceptor()); //设置拦截方法类
		return (T) enhancer.create(); //返回代理类对象
	}
	
	//获取对象
	public static <T> T getInstance(Class<T> cls) {
		try {
			T obj = createInstance(cls);
			Field[] fields = cls.getDeclaredFields();
			for (Field f : fields) {
				if (f.isAnnotationPresent(SimpleInject.class)) {
					if (!f.isAccessible()) {
						f.setAccessible(true);
					}
					Class<?> fieldCls = f.getType();
					f.set(obj, getInstance(fieldCls));
				}
			}
			return obj;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	static {
		init();
	}
}
