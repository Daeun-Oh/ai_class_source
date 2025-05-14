package exam01;

import org.junit.jupiter.api.Test;
import org.koreait.configs.AppCtx;
import org.koreait.lifecycle.Message2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {

    @Test
    void test1() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);  // Spring 컨테이너 생성
        // 객체 생성 -> 의존 주입 -> 초기화(afterPropertiesSet())

        Message2 m1 = ctx.getBean(Message2.class);
        Message2 m2 = ctx.getBean(Message2.class); // 싱글톤일 때 정상 작동. 이렇게 2개를 만들면 close가 2번 불려온다.
        System.out.println(m1 == m2);   // false


        ctx.close();    // destroy() -> 소멸
    }
}
