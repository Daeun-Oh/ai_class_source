package exam02;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("test5.txt");
             DataOutputStream dos = new DataOutputStream(fos)) {
            dos.writeInt(100);
            dos.writeBoolean(true);
            dos.writeUTF("안녕하세요");  // 기본형은 아니지만, 많이 쓰기 때문에 존재
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
