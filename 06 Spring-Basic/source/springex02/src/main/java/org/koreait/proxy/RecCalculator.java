package org.koreait.proxy;

/**
 * 재귀함수 방식으로 factorial 구현
 * -> 함수를 매번 호출하기 때문에 메모리가 많이 사용되어서 성능은 좋지 않다.
 */
public class RecCalculator implements Calculator {
    @Override
    public long factorial(long num) {
        if (num < 1L) {
            return 1L;
        }

        return num * factorial(num - 1);
    }
}
