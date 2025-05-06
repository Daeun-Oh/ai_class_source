package member.services;

import global.Validator;
import global.configs.DBConnection;
import member.controllers.RequestJoin;
import member.mappers.MemberMapper;
import member.validators.JoinValidator;

import javax.sound.midi.MetaMessage;

/**
 * 회원가입 기능
 * 1. DTO - RequiestJoin
 * 2. Validator - JoinValidator
 * 3. DAO - MemberMapper
 */
public class JoinService {

    // 확장된 기능 - 상속보다는 구성, 의존성
    private Validator<RequestJoin> validator;
    private MemberMapper mapper;

    // 확장에 열려있는 구조(Open)
    public void setValidator(Validator<RequestJoin> validator) {
        this.validator = validator;
    }

    public void setMapper(MemberMapper mapper) {
        this.mapper = mapper;
    }

    public void process(RequestJoin form) {
        /**
         * validator가 수행하는 기능이 변경되면, process의 처리 방식도 변경될 수 있다.
         * 변화에 서로 영향을 받는 관계, 의존하는 관계, 의존성
         * 변화에 대응하기 위해서 함수 영역으로 닫아 놓은 상태, 통제를 하기 위한 소스 구성이 필요하므로
         * - 변화에는 닫혀 있는 구조(Closed)
         */
        validator.check(form);  // 검증 성공

        mapper.register(form);  // db 처리
    }


    /*public JoinService() {
        System.out.println("기본 생성자");
    }

    public JoinService(String str, int num) {
        System.out.printf("str=%s, num=%d%n", str, num);
    }*/
}
