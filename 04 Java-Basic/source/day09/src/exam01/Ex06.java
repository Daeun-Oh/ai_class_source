package exam01;

import java.util.Arrays;

public class Ex06 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4 ,5, 6};
        System.out.println(nums);
        System.out.println(Arrays.toString(nums));

        int[][] nums2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.toString(nums2)); // 이렇게 하면 정확한 값이 아니라, 안에 있는 배열의 주소가 출력됨
        System.out.println(Arrays.deepToString(nums2)); // 다차원 배열의 모든 값 출력

    }
}
