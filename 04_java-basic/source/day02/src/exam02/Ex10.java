package exam02;

public class Ex10 {
    public static void main(String[] args) {
        int[][] nums = {
                {10, 20, 30},   // 0행
                {40, 50, 60}    // 1행
        };

        System.out.printf("nums.length: %d\n", nums.length);        // nums의 행 개수
        System.out.printf("nums[0].length: %d\n", nums[0].length);  // nums의 0번째 행의 열 개수

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.println(nums[i][j]);
            }
        }

        for (int[] rows : nums) {
            for (int col : rows) {
                System.out.println(col);
            }
        }
    }
}
