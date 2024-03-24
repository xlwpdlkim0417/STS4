package _sb0322.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import _sb0322.dto.Member2;

@Repository
public class MemberDao2 {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Member2> selectAll() {
		List<Member2> results = jdbcTemplate.query("SELECT * FROM MEMBER", (ResultSet rs, int rowNum) -> {
			Member2 member = new Member2(rs.getInt("id"), rs.getString("NAME"), rs.getInt("AGE"), rs.getString("EMAIL"),
					rs.getString("MEMO"));
			return member;
		});
		return results;

	}

	public Member2 selectById(int id) {
		List<Member2> results = jdbcTemplate.query("SELECT * FROM MEMBER WHERE ID = ?", (ResultSet rs, int rowNum) -> {
			Member2 member = new Member2(rs.getInt("ID"), rs.getString("NAME"), rs.getInt("AGE"), rs.getString("EMAIL"),
					rs.getString("MEMO"));
			return member;
		}, id);
		return results.isEmpty() ? null : results.get(0);
	}

	public void insert(Member2 member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO MEMBER (NAME, AGE, EMAIL, MEMO) VALUE (?, ?, ?, ?)", new String[] { "ID" });
				pstmt.setString(1, member.getName());
				pstmt.setInt(2, member.getAge());
				pstmt.setString(3, member.getEmail());
				pstmt.setString(4, member.getMemo());

				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.intValue());
	}

	public void update(Member2 member) {
		jdbcTemplate.update("UPDATE MEMBER SET NAME = ?, EMAIL =?, AGE = ?, MEMO = ? WHERE ID = ?", member.getName(),
				member.getEmail(), member.getAge(), member.getMemo(), member.getId());
	}

	public void delete(Member2 member) {
		jdbcTemplate.update("DELETE FROM MEMBER WHERE ID = ?", member.getId());
	}
	
	public int count() {
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM MEMBER", Integer.class);
	}

}
