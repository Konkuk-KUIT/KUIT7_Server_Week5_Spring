package spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.domain.Member;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private final List<Member> members = new ArrayList<>();

    @Transactional
    public void save(Member member) {
        members.add(member);
    }

    @Transactional(readOnly = true)
    public List<Member> findAll() {
        return members;
    }

    @Transactional(readOnly = true)
    public Member findById(Long id) {
        return members.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
