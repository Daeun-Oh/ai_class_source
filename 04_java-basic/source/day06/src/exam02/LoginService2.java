package exam02;

public class LoginService2 {
    public void process(String userId, String userPw)
    {
        if (!userId.equals("user01")) {
            throw new UserId2Exception("아이디가 일치하지 않습니다."); // try-catch 예외 처리를 하지 않아도 오류가 없다
                                                                    // RuntimeException을 사용하면 유연하기 때문
        }
        if (!userPw.equals("12345")) {
            throw new UserId2Exception("비밀번호가 일치하지 않습니다."); // try-catch 예외 처리를 하지 않아도 오류가 없다
            // Runtime이 유연하기 때문
        }
        System.out.println("로그인 성공!");
    }
}
