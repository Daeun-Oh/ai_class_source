package org.koreait.proxy;

/**
 * 계산기의 기능을 대신 수행
 */
public class PerformanceCalculator implements Calculator {
    private Calculator calculator = new RecCalculator();

    public PerformanceCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public long factorial(long num) {

        long startTime = System.nanoTime(); // 성능 확인용 시작 시간 -> 공통 기능
        try {
            long result = calculator.factorial(num); // 다른 계산기의 핵심 기능을 대신 수행
            return result;
        } finally { // 공통 기능
            long endTime = System.nanoTime(); // 성능 확인용 종료 시간 -> 공통 기능
            System.out.printf("걸린 시간: %d%n", endTime - startTime);
        }
    }
}
