package exam01;

import org.junit.jupiter.api.Test;
import org.koreait.global.member.controllers.RequestJoin2;

public class Ex01 {
    @Test
    void test1() {
        RequestJoin2 data = new RequestJoin2("user01@test.org", "1234", "1234", "user01", true);
        System.out.printf("email=%s, name=%s%n", data.email(), data.name());
        System.out.println(data);
    }
}
