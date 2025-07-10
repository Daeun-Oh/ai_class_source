package exam03;

import java.io.File;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/0.Daeun/ai_test"); // 디렉토리 생성하기

        // file이 존재하지 않거나, 존재해도 폴더가 아니라면
        if (!file.exists() || !file.isDirectory()) {
            file.mkdir();
        }

        File file2 = new File("C:/0.Daeun/ai_test/sub1/sub2");
        if (!file2.exists() || !file2.isDirectory()) {
            file2.mkdirs(); // 하위 디렉토리까지 재귀적으로 생성
        }

        File file3 = new File(file, "test1.txt");
        file3.createNewFile();  // 비어있는 새로운 파일 생성
    }
}
