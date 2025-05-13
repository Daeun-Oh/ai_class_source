package org.koreait.member.dao;

import org.koreait.member.entities.Member;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DB에 연결되어 있다고 가정
 */
@Repository
public class MemberDao {
    private Map<String, Member> members = new HashMap<>();

    public void register(Member member) {
        member.setRegDt(LocalDateTime.now());
        members.put(member.getEmail(), member);
    }

    public Member get(String email) {
        return members.get(email);
    }

    public List<Member> getList() {
        return new ArrayList<>(members.values());
    }
}
