package exam03;

import java.util.List;

public class Juicer {
    /**
     * <?> -> <? extends Object>
     * @param items
     */
    public static void make(FruitBox<? extends Fruit> items) {
        List<Fruit> fruits = (List<Fruit>)items.getItems();
        for (Fruit fruit : fruits) {
            fruit.printInfo();
        }
    }

    public static void make2(FruitBox<? super Apple> items) {   // Apple, Fruit, Object
        List<Fruit> fruits = (List<Fruit>)items.getItems();
        for (Fruit fruit : fruits) {
            fruit.printInfo();
        }
    }

    public static <T extends Fruit> void make3(FruitBox<T> items) {
        List<Fruit> fruits = (List<Fruit>)items.getItems();
        for (Fruit fruit : fruits) {
            fruit.printInfo();
        }
    }
    /*public static void make(FruitBox<Apple> items) {
        List<Apple> fruits = items.getItems();
        for (Apple fruit : fruits) {
            fruit.printInfo();
        }
    }*/
    /*public static void make(FruitBox<Graph> items) {

    }*/
    /**
     * 메서드 오버로드 해야지!!라고 당차게 make()를 또 만들었지만...
     *
     * <Grape>, <Apple>는 문법적 오류!이기 때문에
     * 컴파일 시에는 이 부분이 제거되므로, "FruitBox items"만 남는다
     * -> 메서드의 중복 정의로 오류가 발생
     *
     * 지네릭 메서드의 타입은 합수가 호출되었을 때 결정된다.
     * 즉, 매개변수의 자료형 또는 반환값 종류에 의해 결정된다.
     */
}
