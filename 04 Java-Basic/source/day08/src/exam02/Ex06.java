package exam02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex06 {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("가");
        items.add("나");
        items.add("다");
        items.add("라");
        items.add("마");

        Iterator<String> it = items.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
