package exam02;

public class Outer1 {
    int num1 = 500;
    int num2 = 200;

    /**
     * 인스턴스 내부 클래스
     */
    class Inner {
        //private static int num1 = 100;  // JDK 16부터 가능
        private int num1 = 100;

        public void method() {
            System.out.println("인스턴스 내부 클래스!");
            System.out.printf("someone's num1: %d%n", num1);
            System.out.printf("Outer1의 num2: %d%n", num2);
            System.out.printf("Outer1의 num1: %d%n", Outer1.this.num1);
        }
    }
}
