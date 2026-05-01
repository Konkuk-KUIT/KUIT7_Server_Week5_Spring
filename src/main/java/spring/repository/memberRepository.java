package spring.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import spring.domain.Member;
import spring.repository.rowmapper.memberRowMapper;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class memberRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Member> findAll() {
        String sql = "select * from member";
        return jdbcTemplate.query(sql, new memberRowMapper());
    }

    public Member findById(long id) {
        String sql = "select * from member where id = ?";
        return jdbcTemplate.queryForObject(sql, new memberRowMapper(), id);
    }

    public void save(Member member) {
        String sql = "insert into member (name) values (?)";
        jdbcTemplate.update(sql, member.getName());
    }

}
