package exam02;

public class Bird extends Animal {
    @Override
    public void move() {
        System.out.println("두 날개로 난다");
    }

    public void sing() {
        System.out.println("노래를 부른다");
    }
}
