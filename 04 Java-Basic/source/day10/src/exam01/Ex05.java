package exam01;

import java.util.stream.IntStream;

public class Ex05 {
    public static void main(String[] args) {
        // 0~9 반복하며 출력
        IntStream.range(0, 10).forEach(i -> System.out.println((i + 1) + "번 반복"));

        // 1~100을 포함하는 IntStream을 생성하고 합계 계산
        long total = IntStream.rangeClosed(1, 100).sum();
        System.out.println(total);
    }
}
