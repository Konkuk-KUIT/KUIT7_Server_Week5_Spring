package spring.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import spring.domain.Member;

import java.sql.ResultSet;
import java.sql.SQLException;

public class memberRowMapper implements RowMapper<Member> {

    @Override
    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
        Member member = new Member(rs.getString("name"));
        member.setId(rs.getLong("id"));
        return member;
    }
}
