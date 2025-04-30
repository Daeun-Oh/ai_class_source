package exam01;

import java.util.Arrays;
import java.util.List;

public class Ex03 {
    public static void main(String[] args) {
        /* 수정 불가 리스트 - 추가, 제거, 변경 불가 */
        List<String> items = List.of("Apple", "Orange", "Melon");
        System.out.println(items);  // [Apple, Orange, Melon]
        //items.add("Mango");  // java.lang.UnsupportedOperationException 발생 (ImmutableCollections)

        // 참고: 이렇게도 가능
        //List<String> items2 = Arrays.asList("Apple", "Orange", "Melon");
        //items2.add("Mango");  // java.lang.UnsupportedOperationException 발생 (AbstractList)
    }
}
