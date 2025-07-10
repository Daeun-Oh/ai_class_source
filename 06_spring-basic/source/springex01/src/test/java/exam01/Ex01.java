package exam01;

import org.junit.jupiter.api.Test;
import org.koreait.configs.AppCtx;
import org.koreait.person.Greeter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    @Test
    void test1() {
        // ctx: AppCtx 설정 클래스를 기반으로 한 Spring 컨테이너
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        // Spring 컨테이너에 등록된 "greeter" Bean을 가져옴
        //Greeter g1 = ctx.getBean("greeter", Greeter.class);
        Greeter g1 = ctx.getBean(Greeter.class);
        Greeter g2 = ctx.getBean("greeter", Greeter.class);
        System.out.println(g1 == g2); // true -> 싱글톤이다

        // Greeter 객체의 hello 메서드 실행
        g1.hello("안녕하세요");

        // 컨테이너 종료 및 자원 해제
        ctx.close();
    }
}
