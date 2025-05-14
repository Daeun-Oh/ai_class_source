package org.koreait.member.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.koreait.member.RequestLogin;
import org.koreait.member.dao.MemberDao;
import org.koreait.member.entities.Member;
import org.koreait.member.validators.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
//    @Autowired
    private final LoginValidator validator;

    //@Autowired
    //private MemberDao memberDao;

    //@Autowired
    @NonNull
    private Optional<MemberDao> opt;    // Optional 클래스도 자동 주입 가능

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd");

    /**
     * DateTimeFormatter에 @Bean(의존성)이
     * 있으면 setFormatter 호출
     * 없으면 호출하지 않고, 기본값을 사용한다.
     * @param formatter
     */
    @Autowired(required = false)    // 있으면 있는대로, 없으면 없는대로
    //@Qualifier("dtf2")
    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }


    public void process(RequestLogin form) {
        validator.validate(form);
        MemberDao memberDao = opt.orElse(null);

        if (memberDao == null) {
            return;
        }

        Member member = memberDao.get(form.getEmail());
        if (member != null && formatter != null) {
            String dateStr = formatter.format(member.getRegDt());
            member.setRegDtStr(dateStr);
        }

        System.out.println(member);
        System.out.println("로그인 완료");
    }
}
