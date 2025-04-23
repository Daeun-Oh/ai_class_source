package exam03;

public class Ex02 {
    /**
     * main() 호출 -> add(10, 20) 호출
     * @param args
     */
    public static void main(String[] args) {    // 메인 함수 - 모든 프로그램의 시작 함수
        System.out.printf("10 + 25 = %d\n", add(10, 25));
    }

    static int add(int num1, int num2) {    // 수행 시 Stack(임시 메모리)에 할당된 후, 끝나면 메모리 반환
        int result = num1 + num2;

        return result;
    }
}
