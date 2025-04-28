package classesEx;

import java.util.Scanner;

public class Ex_Scanner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] argArr = null;

        while(true) {
            String prompt = ">>";
            System.out.print(prompt);

            // 화면으로부터 라인 단위로 입력 받기
            String input = s.nextLine();

            input = input.trim(); // 공백 제거
            argArr = input.split(" +"); // 입력 받은 내용을 (1개 이상의) 공백 구분자로 자른다

            String command = argArr[0].trim();

            if ("".equals(command))
                continue;

            // 명령어를 소문자로 변환
            command = command.toLowerCase();

            // q or Q 입력 시 실행 종료
            if (command.equals("q")) {
                System.exit(0);
            } else {
                for (int i = 0; i < argArr.length; i++) {
                    System.out.println(argArr[i]);
                }
            }
        }
    }
}
