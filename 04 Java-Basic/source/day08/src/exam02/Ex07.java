package exam02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Ex07 {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("가");
        items.add("나");
        items.add("다");
        items.add("라");
        items.add("마");

        ListIterator<String> lit = items.listIterator();
        System.out.println("----순방향 조회----");
        while (lit.hasNext()) {
            System.out.println(lit.next());
        }
        System.out.println("----역방향 조회----");
        while (lit.hasPrevious()) {
            System.out.println(lit.previous());
        }
    }
}
