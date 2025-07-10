package exam01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex04 {
    public static void main(String[] args) {
        int[] scores = {90, 88, 100, 60, 55, 78};
        //IntStream stm = Arrays.stream(scores);
        int[] scores2 = Arrays.stream(scores).sorted().toArray();
        System.out.println(Arrays.toString(scores2));

        int[] scores3 = Arrays.stream(scores)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)   // Stream<Integer> -> IntStream
                .toArray();
        System.out.println(Arrays.toString(scores3));
    }
}
