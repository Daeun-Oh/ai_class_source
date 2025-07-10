package exam02;

import java.util.Arrays;

public class Ex07 {
    public static void main(String[] args) {
        System.out.println(sum(10, 20, 30, 40));
        System.out.println(sum(50, 60));
    }

    static int sum(int... nums) {
        //System.out.println(Arrays.toString(nums));
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        return total;
    }
}
