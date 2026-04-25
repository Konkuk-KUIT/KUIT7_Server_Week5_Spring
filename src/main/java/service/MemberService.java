package service;

import domain.Member;
import java.util.ArrayList;

import java.util.*;

public class MemberService {

    private static final MemberService instance = new MemberService();
    private final List<Member> members = new ArrayList<>();

    public static MemberService getInstance() {
        return instance;
    }

    public void save(Member member) {
        members.add(member);
    }

    public List<Member> findAll() {
        return members;
    }

    public Member findById(Long id) {
        return members.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}