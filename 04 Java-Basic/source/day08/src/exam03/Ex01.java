package exam03;

import java.util.HashSet;

public class Ex01 {
    public static void main(String[] args) {
        HashSet<String> items = new HashSet<>();
        items.add("Name1");
        items.add("Name3");
        items.add("Name3");
        items.add("Name4");
        items.add("Name2");
        items.add("Name4");
        items.add("Name5");
        items.add("Name3");
        items.add("Name2");

        System.out.println(items);
    }
}
