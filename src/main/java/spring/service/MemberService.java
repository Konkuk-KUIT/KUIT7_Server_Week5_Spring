package spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.domain.Member;

@Service
@Transactional
public class MemberService {

  private final List<Member> members = new ArrayList<>();

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

  public void save(Member member) {
    members.add(member);
  }
}
