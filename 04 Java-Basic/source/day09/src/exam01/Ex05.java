package exam01;

import java.util.Arrays;

public class Ex05 {
    public static void main(String[] args) {
        int[][] nums1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] nums2 = {{1, 2, 3}, {4, 5, 6}};
        boolean isSame = Arrays.deepEquals(nums1, nums2);   // 다차원 배열 비교
        System.out.println(isSame);
    }
}
