package exam03;

import java.util.Comparator;
import java.util.TreeSet;

public class Ex05 {
    public static void main(String[] args) {
//        Comparator<String> comp = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        };

        //TreeSet<String> items = new TreeSet<>(comp);
        TreeSet<String> items = new TreeSet<>(Comparator.reverseOrder());
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
