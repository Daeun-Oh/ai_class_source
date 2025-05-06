package exam03;

import board.entities.BoardData;
import member.entities.Member;
import member.services.JoinService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Ex01 {
    @Test
    void test1() throws Exception {
        /**
         * Java의 리플렉션(Reflection) 기능을 사용해서
         * JoinService 클래스의 생성자를 가져오고,
         * 해당 생성자들로 객체를 동적으로 생성하는 예제
         */
        Class<JoinService> cls = JoinService.class;
        Constructor<JoinService> con1 = cls.getDeclaredConstructor();
        Constructor<JoinService> con2 = cls.getDeclaredConstructor(String.class, int.class);

        JoinService s1 = con1.newInstance();    // 기본 생성자로 객체 생성
        JoinService s2 = con2.newInstance("ABC", 100);  // 매개변수 넣어서 객체 생성
    }

    @Test
    void test2() throws Exception {
        Member member = createObject(Member.class);
        System.out.println(member);

        BoardData item = createObject(BoardData.class);
        System.out.println(item);
    }

    private <T> T createObject(Class<T> cls) throws Exception {
        Constructor<T> con = cls.getDeclaredConstructor();
        Object obj = con.newInstance();

        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName(); // 메서드명, setter 메서드만 필요하므로, set으로 시작하지 않는 메서드는 전부 배게
            if (!name.startsWith("set")) continue;
            System.out.println("name: " + name);

            Class[] classes = method.getParameterTypes();
            Object value = null;
            for (Class c : classes) {
                if (c == String.class) { // 문자열 값
                    value = "임의값";
                } else if (c == long.class) {
                    value = 1L;
                } else if (c == LocalDateTime.class) {
                    value = LocalDateTime.now();
                } else if (c == boolean.class) {
                    value = false;
                }
            }
            method.invoke(obj, value);
        }

        return (T)obj;
    }
}
