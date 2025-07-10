package exam01;

import java.util.HashMap;

public class Ex01 {
    public static void main(String[] args) {
        HashMap<String, String> members = new HashMap<>();

        // 추가
        members.put("user01", "회원1");
        members.put("user02", "회원2");
        members.put("user03", "회원3");
        members.put("user04", "회원4");
        members.put("user05", "회원5");

        // 조회
        String user03 = members.get("user03");
        System.out.println(user03);     // 회원3

        // 수정
        members.put("user03", "회원3(*)");
        user03 = members.get("user03");
        System.out.println(user03);     // 회원3(*)

        // 제거
        members.remove("user03");
        user03 = members.get("user03");
        System.out.println(user03);     // null

        // 조회 - 값이 null일 때, 기본값 반환
        user03 = members.getOrDefault("user03", "default");
        System.out.println(user03);     // default
    }
}
