package org.koreait.proxy3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PerformanceCalculator3 {
    @Pointcut("execution(* org.koreait.proxy.*.*(long))")
    public void publicTarget() {}

    @Around("publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.nanoTime();   // 시작 시간
        try {
            Object result = joinPoint.proceed();    // 핵심 기능을 대신 수행 ex) long factorial(long ...)

            return result;
        } finally {
            long endTime = System.nanoTime();   // 종료 시간
            System.out.printf("걸린 시간: %d%n", endTime - startTime);
        }
    }
}
