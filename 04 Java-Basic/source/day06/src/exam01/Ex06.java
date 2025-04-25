package exam01;

public class Ex06 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 2;

        try {
            int result = num1 / num2;   // ArithmeticException
            System.out.println(result);

            String str = null;
            str = str.toUpperCase();    // 소문자 -> 대문자 변환 실패, NullPointerException 발생
            System.out.println(str);
            // NullPointerException e = new NullPointerException()...
        } catch (ArithmeticException | NullPointerException e) {  // RuntimeException에 포함이 안 되는 예외도 존재
            String message = e.getMessage();
            System.out.println(message);
        } catch (Exception e) {
            System.out.println("나도 모르는 예외를 처리한다...");
        }
    }
}
