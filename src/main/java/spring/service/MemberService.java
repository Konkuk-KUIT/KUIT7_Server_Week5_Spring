package spring.service;

import spring.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final List<Member> members = new ArrayList<>();

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
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }
}
