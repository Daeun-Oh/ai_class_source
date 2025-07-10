package exam02;

import java.util.LinkedList;
import java.util.Queue;

public class Ex05 {
    public static void main(String[] args) {
        Queue<String> items = new LinkedList<>();

        items.add("가");
        items.add("나");
        items.add("다");

        while (items.size() > 0) {
            String item = items.poll();
            System.out.println(item);
        }
    }
}
