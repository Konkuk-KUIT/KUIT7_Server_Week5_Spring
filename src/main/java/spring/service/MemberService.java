package spring.service;

import domain.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberService {
    private static final service.MemberService instance = new service.MemberService();
    private final List<Member> members = new ArrayList<>();

    public static service.MemberService getInstance() {
        return instance;
    }

    @Transactional
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
