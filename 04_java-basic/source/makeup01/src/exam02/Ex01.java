package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>(); // Apple 이외엔 넣을 수 없음 (타입 안정성 확보)
        appleBox.setItem(new Apple());
        Apple apple = appleBox.getItem();       // 형변환의 번거로움 X
        appleBox.print();

        //appleBox.setItem(new Graph());    // Error: incompatible types: exam02.Graph cannot be converted to exam02.Apple

        //Box<Toy> toyBox = new Box<Toy>();
    }
}
