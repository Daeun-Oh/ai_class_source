package exam01;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex03 {
    public static void main(String[] args) {
        List<Integer> scores = List.of(90, 88, 100, 60, 55, 78);
        Stream<Integer> stmt = scores.stream(); // 일반 스트림, 일반 스트림에서 제공하는 기능 밖에 못 씀

        // 과정 1
        IntStream stmt2 = stmt.mapToInt(s -> s); // 내부적으로 unboxing 발생
        double avg = stmt2.average().getAsDouble();
        System.out.println(avg);

        // 과정 2: 과정 1을 한 줄로!
        double avg2 = scores.stream().mapToInt(s -> s).average().getAsDouble();
        System.out.println(avg2);
    }
}
