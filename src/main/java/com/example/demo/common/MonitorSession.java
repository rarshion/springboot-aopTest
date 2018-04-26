package com.example.demo.common;

/**
 * Author : Martin
 * Date : 2018/4/6
 * Description :
 */
public class MonitorSession {
    private static final ThreadLocal<MethodMonitor> monitorThreadLocal = new ThreadLocal<>();
    
    public static void begin(String methodName) {
        MethodMonitor logger = new MethodMonitor(methodName);
        monitorThreadLocal.set(logger);
    }
    
    public static void end() {
        MethodMonitor logger = monitorThreadLocal.get();
        logger.log();
    }
}
