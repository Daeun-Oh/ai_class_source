package exam03;

public class Ex02 {
    public static void main(String[] args) {
        Integer num1 = new Integer(10);
        Integer num2 = new Integer(10);
        System.out.printf("num1의 주소: %d%n", System.identityHashCode(num1));
        System.out.printf("num2의 주소: %d%n", System.identityHashCode(num2));
        System.out.println(num1.doubleValue());
        System.out.println(num2.doubleValue());

        /**
         * 재료가 되는 값 10을 다루는 모든 메서드의 결과는 num1이든, num2이든 다 똑같다!
         */

        Integer num3 = Integer.valueOf(10);
        Integer num4 = Integer.valueOf(10);
        System.out.printf("num3의 주소: %d%n", System.identityHashCode(num3));
        System.out.printf("num4의 주소: %d%n", System.identityHashCode(num4));

        Integer num5 = 10;
        Integer num6 = 10;
        System.out.printf("num5의 주소: %d%n", System.identityHashCode(num5));
        System.out.printf("num6의 주소: %d%n", System.identityHashCode(num6));
    }
}
