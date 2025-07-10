package org.koreait.proxy3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class PerformanceCalculator3 {
//    @Pointcut("execution(* org.koreait.proxy.*.*(long))")
//    public void publicTarget() {}
//
//    @Around("publicTarget()")
    //@Around("org.koreait.proxy3.CommonPointcut.publicTarget()")
    @Around("CommonPointcut.publicTarget()")    // 동일 패키지에 있는 경우 패키지 경로(org.koreait.proxy3)는 생략 가능
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

    @Before("CommonPointcut.publicTarget()")
    public void befor(JoinPoint joinPoint) {
        System.out.println("before()");

    }

    @After("CommonPointcut.publicTarget()")
    public void after(JoinPoint joinPoint) {
        System.out.println("after()");
    }

    @AfterReturning("CommonPointcut.publicTarget()")
    public void afterReturning(JoinPoint joinPoint, Object returnValue) {
        System.out.println("afterReturning()");
        System.out.println("rv: " + returnValue);
    }
}
