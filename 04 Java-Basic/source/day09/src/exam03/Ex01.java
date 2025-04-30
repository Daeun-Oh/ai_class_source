package exam03;

import java.util.function.BiFunction;

public class Ex01 {
    public static void main(String[] args) {
        /*Calculator cal = new Calculator() {
            @Override
            public int add(int num1, int num2) {
                return num1 + num2;
            }
        };

        System.out.println(cal.add(10, 20));*/

        /*Calculator cal = (int num1, int num2) -> {
            return num1 + num2;
        };*/

        /*Calculator cal = (num1, num2) -> num1 + num2;*/
        Calculator cal = (a, b) -> a + b;
    }
}
