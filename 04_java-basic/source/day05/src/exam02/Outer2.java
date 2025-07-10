package exam02;

public class Outer2 {
    private int num1 = 100;
    private static int num2 = 200;

    public void instanceMethod() {
        System.out.println("외부 클래스 인스턴스 메서드!");
    }
    public static void staticMethod() {
        System.out.println("외부 클래스 정적 메서드!");
    }
    /**
     * 정적 내부 클래스
     */
    static class Inner {
        public void method() {
            System.out.println("정적 내부 클래스!");

            // 외부 클래스의 인스턴스 자원(메서드, 변수) 접근 불가
            // System.out.println(num1);
            // instanceMethod();

            // 정적 자원은 접근 가능
            System.out.println(num2);
            staticMethod();
        }
    }
}
