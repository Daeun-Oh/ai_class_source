package exam02;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex04 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("score.txt");
             DataInputStream dis = new DataInputStream(fis)) {
            int count = 0, total = 0;
            try {
                while(true) {
                    int score = dis.readInt();
                    total += score;
                    count++;
                }
            } catch (EOFException e) { // 점수를 다 읽어왔을 때
                double avg = total / (double)count;
                System.out.printf("총점: %d, 평균: %.1f%n", total, avg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
