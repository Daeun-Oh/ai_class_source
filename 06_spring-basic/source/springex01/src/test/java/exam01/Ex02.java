package exam01;

import org.junit.jupiter.api.Test;
import org.koreait.configs.AppCtx2;
import org.koreait.configs.DBConfig;
import org.koreait.member.RequestJoin;
import org.koreait.member.RequestLogin;
import org.koreait.member.dao.MemberDao;
import org.koreait.member.entities.Member;
import org.koreait.member.services.JoinService;
import org.koreait.member.services.LoginService;
import org.koreait.person.Greeter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Ex02 {
    @Test
    void test1() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx2.class);

        JoinService service = ctx.getBean("joinService", JoinService.class);
        LoginService loginService = ctx.getBean("loginService", LoginService.class);
        MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);

        RequestJoin form = new RequestJoin();
        form.setEmail("user01@test.org");
        form.setName("User01");
        form.setPassword("12341234");

        service.process(form);


        List<Member> memberList = memberDao.getList();
        memberList.forEach(System.out::println);

        RequestLogin loginForm = new RequestLogin();
        loginForm.setEmail(form.getEmail());
        loginService.process(loginForm);

        ctx.close();
    }

    @Test
    void test2() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx2.class, DBConfig.class);

        JoinService service = ctx.getBean(JoinService.class);
        Greeter g1 = ctx.getBean(Greeter.class);

        System.out.println("service: " + service);
        System.out.println("g1: " + g1);

        ctx.close();
    }
}
