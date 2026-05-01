package spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import spring.domain.Member;
import org.springframework.stereotype.Service;
import spring.repository.memberRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final memberRepository repository;

    @Transactional
    public void save(Member member) { repository.save(member); }

    @Transactional(readOnly = true)
    public List<Member> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Member findById(Long id) {
        return repository.findById(id);
    }
}
