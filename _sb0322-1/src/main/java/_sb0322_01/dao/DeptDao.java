package _sb0322_01.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;


import _sb0322_01.dto.Dept;

@Repository
public class DeptDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Dept> selectAll() {
		List<Dept> list = jdbcTemplate.query("SELECT * FROM DEPT", (ResultSet rs, int rowNum) -> {
			Dept dept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
			return dept;
		});
		return list;

	}

}
