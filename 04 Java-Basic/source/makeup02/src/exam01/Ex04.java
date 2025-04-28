package exam01;

import java.io.FileOutputStream;
import java.io.IOException;

public class Ex04 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("test2.txt")) {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                // 참고) 버퍼에 담아서 한꺼번에 쓰는 게 더 효율적이긴 함
                fos.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
