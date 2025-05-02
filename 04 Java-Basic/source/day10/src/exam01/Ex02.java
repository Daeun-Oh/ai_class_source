package exam01;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Ex02 {
    public static void main(String[] args) {
        int[] scores = {90, 88, 100, 60, 55, 78};
        IntStream stm = Arrays.stream(scores);
        IntSummaryStatistics stat = stm.summaryStatistics();
        long count = stat.getCount();   // 총 개수
        long sum = stat.getSum();       // 합계
        int max = stat.getMax();        // 최댓값
        int min = stat.getMin();        // 최솟값
        double avg = stat.getAverage(); // 평균

        System.out.printf("총 개수: %d%n합계: %d%n최댓값: %d%n최솟값: %d%n평균: %.1f%n",
                            count, sum, max, min, avg);
    }
}
