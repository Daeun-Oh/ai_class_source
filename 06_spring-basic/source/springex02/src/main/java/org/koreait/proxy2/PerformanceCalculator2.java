package org.koreait.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceCalculator2 implements InvocationHandler {

    private final Object instance;

    public PerformanceCalculator2(Object instance) {
        this.instance = instance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.nanoTime();     // 시작 시간, 공통 기능
        try {
            Object result = method.invoke(instance, args);  // 핵심 기능을 대신 수행
            return result;
        } finally {     // 공통 기능
            long endTime = System.nanoTime();   // 종료 시간, 공통 기능
            System.out.printf("걸린 시간: %d%n", endTime - startTime);
        }
    }
}
