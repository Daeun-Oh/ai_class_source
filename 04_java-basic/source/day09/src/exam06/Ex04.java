package exam06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Ex04 {
    public static void main(String[] args) {
        // List<String> - 컬렉션
        List<String> fruits3 = List.of("사과", "사과", "사과", "오렌지", "바나나", "멜론");
        String[] fruits4 = fruits3.stream().sorted(Comparator.reverseOrder()).distinct().map(s -> "★" + s + "★").toArray(String[]::new);
        System.out.println(Arrays.toString(fruits4));
        System.out.printf("원본: %s%n", fruits3);

        Stream<String> stm = fruits3.stream(); // 일회용이다! (fruits5에서 한 번 사용하니까, fruits6에서 예외 발생)
        String[] fruits5 = stm.sorted(Comparator.reverseOrder()).distinct().map(s -> "★" + s + "★").toArray(String[]::new);
        String[] fruits6 = stm.sorted(Comparator.reverseOrder()).distinct().map(s -> "★" + s + "★").toArray(String[]::new);
                // java.lang.IllegalStateException: stream has already been operated upon or closed
    }
}
