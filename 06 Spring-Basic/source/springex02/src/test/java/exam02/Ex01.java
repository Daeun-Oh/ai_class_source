package exam02;

import org.junit.jupiter.api.Test;
import org.koreait.proxy.Calculator;
import org.koreait.proxy.ImplCalculator;
import org.koreait.proxy.PerformanceCalculator;
import org.koreait.proxy.RecCalculator;

public class Ex01 {
    @Test
    void test1() {
        long startTime = System.nanoTime(); // 성능 확인용 시작 시간 -> 공통 기능
        ImplCalculator cal1 = new ImplCalculator();
        long result1 = cal1.factorial(20L); // -> 핵심 기능
        long endTime = System.nanoTime(); // 성능 확인용 종료 시간 -> 공통 기능
        System.out.printf("걸린 시간: %d, 값: %d%n", endTime - startTime, result1);

        startTime = System.nanoTime(); // 성능 확인용 시작 시간 -> 공통 기능
        RecCalculator cal2 = new RecCalculator();
        long result2 = cal2.factorial(20L); // -> 핵심 기능
        endTime = System.nanoTime(); // 성능 확인용 종료 시간 -> 공통 기능
        System.out.printf("걸린 시간: %d, 값: %d%n", endTime - startTime, result2);
    }

    @Test
    void test2() {
        Calculator cal1 = new PerformanceCalculator(new ImplCalculator());
        long result1 = cal1.factorial(10L);

        Calculator cal2 = new PerformanceCalculator(new RecCalculator());
        long result2 = cal2.factorial(10L);

        System.out.printf("cal1:%d, cal2:%d%n", result1, result2);
    }
}
