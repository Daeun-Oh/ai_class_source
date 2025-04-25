package exam02;

public class Box<T extends Fruit & Eatable> {
    private T item; // T는 Fruit 또는 Fruit의 하위 클래스임을 알 수 있다!
    //private static T item2;  // -> 처음부터 만들어지기 때문에 명확하지 않은 T 타입으로 정적 변수 생성 불가!
    //private T[] nums = new T[] {};  // -> 처음부터 공간이 할당되어야 하는데, T 타입의 크기를 아직 모름

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void print() {   // T - Object
        item.printInfo();   // item이 Apple인지 Grape인지는 아직 알 수 없지만, Fruit의 하위 클래스임은 분명하다
    }
}
