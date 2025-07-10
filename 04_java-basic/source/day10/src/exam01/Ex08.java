package exam01;

import java.util.List;

public class Ex08 {
    public static void main(String[] args) {
        List<String> items = List.of("사과", "오렌지", "포도", "망고");
        System.out.println(items);

        List<String> items2 = items.stream().skip(2).toList();
        System.out.println(items2);
    }
}
