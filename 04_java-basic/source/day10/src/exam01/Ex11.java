package exam01;

import java.util.Arrays;

public class Ex11 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};

        boolean isOdd = Arrays.stream(nums).allMatch(i -> i % 2 == 1);  // 모든 값이 홀수인가?
        System.out.println(isOdd);  // true

        boolean isEvenIncluded = Arrays.stream(nums).anyMatch(i -> i % 2 == 0); // 짝수가 하나라도 있는가?
        System.out.println(isEvenIncluded);  // false

        Arrays.stream(nums).peek(i -> System.out.printf("%d -> ", i))   // 변환 전에 출력
                .map(i -> i * i)                                        // 제곱 변환
                .forEach(i -> System.out.printf("%d%n", i));            // 최종연산, 반복 출력
    }
}
