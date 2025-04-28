package exam02;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex02 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("test5.txt");
             DataInputStream dis = new DataInputStream(fis)) {
            int num = dis.readInt();
            //byte num = dis.readByte();
            boolean bool = dis.readBoolean();
            String str = dis.readUTF();
            System.out.printf("%d, %b, %s%n", num, bool, str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
