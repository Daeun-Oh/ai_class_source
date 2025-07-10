package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Student s1 = new Student(); // 생성된 객체의 주솟값을 알려 줌
        s1.id = 2020180025;         // 주솟값을 통해 힙에 있는 id, name, major에 접근
        s1.name = "오다은";
        s1.major = "게임공학과";

        s1.showInfo();
        System.out.printf("s1주소: %d\n", System.identityHashCode(s1));   // 물리적 메모리 주소가 아니라 객체의 논리적 식별값

        Student s2 = new Student(); // 생성된 객체의 주솟값을 알려 줌
        s2.id = 2018123456;         // 주솟값을 통해 힙에 있는 id, name, major에 접근
        s2.name = "김이름";
        s2.major = "경영학과";

        s2.showInfo();
        System.out.printf("s2주소: %d\n", System.identityHashCode(s2));

        System.out.printf("s1 == s2: %b\n", s1==s2);

        Student s3 = s2;    // s2가 가지고 있는 주솟값을 s3에 대입
        s3.id = 1003;
        s3.name = "박이름";

        s2.showInfo();
        s3.showInfo();

        System.out.printf("s2 == s3: %b\n", s2==s3);
    }
}
