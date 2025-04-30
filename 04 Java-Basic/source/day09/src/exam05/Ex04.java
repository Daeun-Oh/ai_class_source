package exam05;

import java.util.List;

public class Ex04 {
    public static void main(String[] args) {
        List<String> items = List.of("Name1", "Name2", "Name3");
        //items.forEach(s -> System.out.println(s));
        items.forEach(System.out::println); // 메서드 참조
    }
}
