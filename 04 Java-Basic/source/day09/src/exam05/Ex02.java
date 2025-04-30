package exam05;

import java.util.Arrays;
import java.util.List;

public class Ex02 {
    public static void main(String[] args) {
        List<String> items = List.of("Name1", "Name2", "Name3");

        //String[] items2 = items.stream().toArray(i -> new String[i]);
        String[] items2 = items.stream().toArray(String[]::new); // 메서드 참조

        System.out.println(Arrays.toString(items2));
    }
}
