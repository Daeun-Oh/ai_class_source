package exam03;

import java.util.TreeSet;

public class Ex03 {
    public static void main(String[] args) {
        TreeSet<String> items = new TreeSet<>();
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
