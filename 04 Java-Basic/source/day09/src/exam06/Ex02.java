package exam06;

import java.util.*;

public class Ex02 {
    public static void main(String[] args) {
        /**
         * Ex01의 fruits를 ArrayList로 (처리는 똑같이)
         * -> 처리는 똑같은데, 형(배열, 컬렉션)이 다르다고 코드를 달리 써야 한다니... 너무 불편하다
         */
        List<String> fruits = new ArrayList<>(List.of("사과", "오렌지", "바나나", "멜론"));
        Collections.sort(fruits, Comparator.reverseOrder());  // 내림차순 정렬
        System.out.println(fruits);
    }
}
