package exam01;

import java.lang.reflect.Method;

public class Ex05 {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student.id = 10000;
        System.out.println(Student.id);
        s1.showInfo();

        Class cls = Student.class;
        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
