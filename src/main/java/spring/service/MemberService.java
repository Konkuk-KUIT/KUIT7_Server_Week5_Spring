package spring.service;

import org.springframework.stereotype.Service;
import spring.domain.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberService {

    private static final Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    public void save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public Member findById(Long id) {
        return store.get(id);
    }
}