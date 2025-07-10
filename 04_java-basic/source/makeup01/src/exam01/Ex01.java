package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Box appleBox = new Box();
        Apple apple = new Apple();
        appleBox.setItem(apple);
        Apple item = (Apple)appleBox.getItem(); // 사용할 때마다 원래 자료형으로 형변환을 해야 한다.
        item.printInfo();

        Box grapeBox = new Box();
        Graph graph = new Graph();
        grapeBox.setItem(graph);


        // 안에 있는 게 Grape인 줄 모르고, Apple로 형변환 -> 코드 실행 시 JVM이 잡아내지만, 컴파일러에선 오류가 뜨지 않는다
        //Apple apple2 = (Apple)grapeBox.getItem();   // Error: class exam01.Graph cannot be cast to class exam01.Apple
                                                    // 타입 안정성이 떨어진다!
    }
}
