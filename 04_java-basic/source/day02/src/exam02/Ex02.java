package exam02;

public class Ex02 {
    public static void main(String[] args) {
        /**
         * nums[0], nums[1], nums[2], nums[3] -> 총 변수 4개
         * nums: 참조변수, 배열에서 첫 번째 변수의 주솟값
         */
        int[] nums = new int[4];    // int형 변수 4개
        System.out.println(nums);   // 첫 번째 변수의 주솟값

        nums[0] = 10;
        System.out.println(nums[0]);
    }
}
