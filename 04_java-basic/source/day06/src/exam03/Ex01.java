package exam03;

public class Ex01 {
    public static void main(String[] args) {
        try (MyResource myResource = new MyResource()) {
            /**
             * 내부적으로 어떤 객체인지 알 수 없지만,
             * 알 수 있는 단 한 가지는 AutoCloseable 인터페이스의 구현 클래스라는 것
             * if (myResource instanceof AutoCloseable) {
             *     AutoCloseable my = myResource;
             *     my.close()...
             * }
             *
             * try-with-resources 구문은 컴파일 시점에
             * AutoCloseable 인터페이스를 구현한 객체만 사용할 수 있다.
             * 즉, myResource가 어떤 구체 클래스인지는 몰라도
             * 최소한 AutoCloseable이라는 추상 타입이라는 것은 보장된다.
             *
             * 이건 SOLID의 D: Dependency Inversion Principle(의존 역전 원칙)
             * "구체화보다 추상화에 의존하라"를 잘 보여주는 사례
             * -> AutoCloseable로 형변환이 가능하면 자원 해제
             * -> 불가능하면 자원 해제 불가
             */
        } catch (Exception e) {}
    }
}
