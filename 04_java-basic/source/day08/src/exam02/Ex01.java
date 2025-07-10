package exam02;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex01 {
    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<>();
        items.add("가");
        items.add("나");
        items.add("다");
        items.add("라");
        items.add("마");

        for (String item : items) {
            System.out.print(item);   // item.toString()
        }

        System.out.println();

//        for (int i = 0; i < items.size(); i++) {
//            String name = items.get(i);
//            System.out.print(name);
//            items.remove(i); // 물리적 배열을 구현 -> 제거가 깔끔하게 안 된다
//        }
        for (int i = items.size() - 1; i > -1; i--) {
            items.remove(i);
        }
        System.out.println();

        System.out.println(items);      // items.toString()

        Iterator<String> i = items.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
