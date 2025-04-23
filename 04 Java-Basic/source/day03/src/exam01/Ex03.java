package exam01;

public class Ex03 {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.id = 1001;
        s1.name = "김이름";
        s1.major = "전공";
        s1.showInfo();

        Student s2 = new Student();
        s2.showInfo();

        Student s3 = new Student(1000, "김멈멈", "무슨무슨전공");
        s3.showInfo();
    }
}
