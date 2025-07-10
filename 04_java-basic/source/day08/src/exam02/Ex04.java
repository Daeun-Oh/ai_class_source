package exam02;

import java.util.LinkedList;
import java.util.List;

public class Ex04 {
    public static void main(String[] args) {
        /**
         * Linked List 예제
         * SOLID의 D: 구체화보다 추상화에 의존하라 (의존 역전의 법칙)
         * -> List 인터페이스를 사용하여, 향후 구체적인 구현체를 변경할 수 있도록 유연성을 확보
         */
        List<String> items = new LinkedList<>();

        items.add("가");
        items.add("나");
        items.add("다");
        items.add("라");
        items.add("마");

        System.out.println(items);
    }

    public static void process(List<String> items) {

    }
}
