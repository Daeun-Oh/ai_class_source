package exam06;

public interface Seller {
    void sell();

    default void order() {
        System.out.println("Seller - 주문하기");
        privateMethod();
    }

    private void privateMethod() {  // Java 9부터 가능
        System.out.println("privateMethod()");
    }

    static void staticMethod() {    // public 생략됨
        System.out.println("정적 메서드");
    }
}
