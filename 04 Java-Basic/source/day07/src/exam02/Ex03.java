package exam02;

public class Ex03 {
    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "ABC";
        String s3 = new String("ABC");

        checkEqual1(s1, s2);    // true
        checkEqual1(s1, s3);    // false

        checkEqual2(s1, s2);    // true
        checkEqual2(s1, s3);    // true
    }

    static void checkEqual1(String s1, String s2) {
        System.out.println(s1 == s2);   // X, 주소를 비교하므로 문자열 상수가 아닌 경우는 false
    }

    static void checkEqual2(String s1, String s2) {
        System.out.println(s1.equals(s2));  // O, 문자열이 생성되는 출처가 다양하므로 동등성 비교를 해야 함
    }
}
