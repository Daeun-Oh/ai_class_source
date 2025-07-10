package exam02;

import org.junit.jupiter.api.Test;
import org.koreait.proxy.Calculator;
import org.koreait.proxy.RecCalculator;
import org.koreait.proxy2.PerformanceCalculator2;

import java.lang.reflect.Proxy;

public class Ex02 {
    @Test
    void test1() {
        Calculator cal = (Calculator) Proxy.newProxyInstance(
                Calculator.class.getClassLoader(),
                new Class[] { Calculator.class },
                new PerformanceCalculator2(new RecCalculator())
        );

        long result = cal.factorial(10L);
        System.out.printf("결과: %d%n", result);
    }

    @Test
    void test2() {
        Calculator cal = (Calculator) Proxy.newProxyInstance(
                Calculator.class.getClassLoader(),
                new Class[] { Calculator.class },
                new PerformanceCalculator2(new RecCalculator())
        );

        long result = cal.factorial(10L);
        System.out.printf("결과: %d%n", result);
    }
}
