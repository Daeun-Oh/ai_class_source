package classesEx;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ex_Scanner2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("data.txt"));
        int sum = 0;
        int cnt = 0;

        while(sc.hasNextInt()) {
            sum += sc.nextInt();
            cnt++;
        }
        System.out.println("sum=" + sum);
        System.out.println("avg=" + (sum / (double)cnt));
    }
}
