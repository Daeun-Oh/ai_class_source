package exam01;

public class Student {
    static int id;  // 학번
    String name;    // 이름
    String major;   // 전공과목

    /**
     * 기본 생성자
     * - 정의가 안 되어 있으면 public Student() {}
     * - 메서드 오버로딩
     */
    public Student() {
        /**
         * 객체 생성 이후에 실행되는 코드
         * 객체 생성 이후에는 변수 공간에 값을 최초로 넣어 주는 초기화 작업을 주로 진행
         */
        id = 0;
        name = "이름없음";
        major = "전공없음";
    }

    public Student(int id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }

    void showInfo() {
        System.out.printf("----< 학생 프로필 조회 >----\n");
        System.out.printf("학번: %d\n이름: %s\n전공: %s\n", id, name, major);
        System.out.printf("-------------------------\n");
    }

    // 정적 메서드로, 객체 생성과는 아무런 상관 없음
    static void staticMethod() {
        System.out.println("staticMethod");
        //this.major = "뭐시기학과"; // this가 없어 접근불가
    }
}
