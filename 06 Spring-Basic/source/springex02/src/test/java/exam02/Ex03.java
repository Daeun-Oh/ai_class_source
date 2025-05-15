package exam02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.koreait.configs.AppCtx2;
import org.koreait.proxy.Calculator;
import org.koreait.proxy.RecCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(AppCtx2.class)
public class Ex03 {

    @Autowired
    private Calculator calculator;  // 접근 제어자 안 써도 큰 문제는 없음

    @BeforeEach
    void init() {
        System.out.println(calculator instanceof RecCalculator);
    }

    @Test
    void test1() {
        /**
         * 이렇게 같은 결과를 여러 개 만들려고 할 때,
         * 굳이 여러 번 연산할 필요가 없다.
         * 한 번 연산한 결과를 캐시에 저장해 꺼내 쓰자! -> CacheCalculator
         */
        long result = calculator.factorial(10L);
        System.out.printf("result: %d%n", result);

        result = calculator.factorial(10L);
        System.out.printf("result: %d%n", result);

        result = calculator.factorial(10L);
        System.out.printf("result: %d%n", result);

        result = calculator.factorial(10L);
        System.out.printf("result: %d%n", result);
    }
}
