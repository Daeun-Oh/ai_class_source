package exam04;

import java.util.function.IntPredicate;

public class Ex06 {
    public static void main(String[] args) {
        IntPredicate cond1 = x -> x >= 130;
        IntPredicate cond2 = x -> x <= 195;
        IntPredicate cond3 = cond1.and(cond2);  // x >= 130 && x <= 195

        boolean result1 = cond3.test(120);  // false
        boolean result2 = cond3.test(200);  // false
        boolean result3 = cond3.test(175);  // true

        System.out.println("조건: x >= 130 && x <= 195");
        System.out.printf("120\t%b%n", result1);
        System.out.printf("200\t%b%n", result2);
        System.out.printf("175\t%b%n", result3);

        IntPredicate cond4 = cond3.negate();      // x < 130 || x > 195
        boolean result4 = cond4.test(175);  // false
        System.out.println(result4);
    }
}
