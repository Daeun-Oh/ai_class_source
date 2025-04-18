package exam03;

public class Ex06 {
    public static void main(String[] args) {
        /**
         * 정수를 int로 인식 10000000000 -> int 범위 넘어가는 숫자 -> 오류!
         */
        //long num1 = 10000000000;      // 자바는 정수면 처음에 무조건 int로 결정. -> int가 아니면 long으로 변환
        long num1 = 10000000000L;       // 숫자 뒤에 L 또는 l: 처음부터 long 자료형으로 인식해 8바이트의 공간을 할당
        long num2 = 10_000_000_000L;    // 가독성을 높이기 위해서 '_' 사용

        double num3 = 10.1234;
        //float num4 = 10.1234;     // 실수면 무조건 double로 자료형을 결정 -> double이 아니면 변경
        float num4 = 10.1234f;      // 숫자 뒤에 F 또는 f: 처음부터 float 자료형으로 인식

        byte num5 = 100;    // int로 자료형을 결정 -> byte로 변환

        // 일을 적게 하려면 되도록 int와 double을 쓰자!
    }
}
