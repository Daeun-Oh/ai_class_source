package exam01;

public class Ex01 {
    public static void main(String[] args) {
        C c = new C();

        /**
         * 하위 클래스의 자료형이 상위 클래스의 자료형으로 자동 형변환
         * -> 다형성
         */
        A a = c;    // 자동 형변환
        B b = c;    // 자동 형변환

        System.out.println(System.identityHashCode(c));
        System.out.println(System.identityHashCode(c.numB));
        System.out.println(System.identityHashCode(c.numC));
    }
}
