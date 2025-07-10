package exam03;

import java.io.File;
import java.io.IOException;

public class Ex02 {
    public static void main(String[] args) throws Exception {
        File tempDir = new File("C:/0.Daeun/tmp");
        if (!tempDir.exists() || !tempDir.isDirectory()) {
            tempDir.mkdir();
        }

        File tempFile = File.createTempFile("tmp_", ".log", tempDir); // 임시 파일
        //tempFile.delete(); // 바로 삭제됨

        Thread.sleep(1000 * 5); // 5초 후

        tempFile.deleteOnExit(); // 애플리케이션 종료 시 삭제
    }
}
