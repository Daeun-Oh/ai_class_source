package exam06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ex03 {
    public static void main(String[] args) {
        /**
         * 처리를 좀 더 늘려보자!
         * 1. 정렬 (내림차순)
         * 2. 중복 제거
         * 3. 각 요소 꾸미기 ("★")
         */

        // String[] - 배열
        String[] fruits = {"사과", "사과", "사과", "오렌지", "바나나", "멜론"};
        String[] fruits2 = Arrays.stream(fruits).sorted(Comparator.reverseOrder()).distinct().map(s -> "★" + s + "★").toArray(String[]::new);
        System.out.println(Arrays.toString(fruits2));

        // List<String> - 컬렉션
        List<String> fruits3 = List.of("사과", "사과", "사과", "오렌지", "바나나", "멜론");
        String[] fruits4 = fruits3.stream().sorted(Comparator.reverseOrder()).distinct().map(s -> "★" + s + "★").toArray(String[]::new);
        System.out.println(Arrays.toString(fruits4));
    }
}
