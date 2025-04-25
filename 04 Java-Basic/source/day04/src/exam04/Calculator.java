package exam04;

public interface Calculator {
    int num = 10;   // public static final - 정적 상수 (대문자 권장)
    // public abstract int add(int num1, int num2);  // 굳이 이렇게 선언하지 않아도 됨
    int add(int num1, int num2);    // 앞에 public abstract 존재 (컴파일러가 자동 추가)
}
