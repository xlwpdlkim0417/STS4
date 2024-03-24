package _sb0322;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import _sb0322.dao.MemberDao2;
import _sb0322.dto.Member2;

@SpringBootTest
class Sb0322ApplicationTests {

	@Autowired
	private MemberDao2 memberDao;
	
	@Test
	@DisplayName("selectAll() 테스트")
	public void test1() {
		System.out.println(memberDao.selectAll());
	}

//	@Test
	@DisplayName("insert() 테스트")
	public void test2() {
		Member2 member = Member2.builder().email("acroaka@korea.com").name("김태진").age(34).memo("김태진의 메모").build();
		memberDao.insert(member);
	}

//	@Test
	@DisplayName("assertEquals로 테스트")
	public void test3() {
		int before = memberDao.count();
		Member2 member = Member2.builder().email("mmm@korea.com").name("MMM").age(55).memo("mmm의 메모").build();
		memberDao.insert(member);
		int after = memberDao.count();
		assertEquals(before + 1, after);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	@DisplayName("jdbc 테스트")
	void jdbcTest() {
		SqlRowSet rs = jdbcTemplate.queryForRowSet("SELECT * FROM MEMBER WHERE ID = ?", 15);
		rs.next();
		assertEquals(15, rs.getInt("id"));
//		있는지 없는지를 찾아보는 테스트
	}

}
