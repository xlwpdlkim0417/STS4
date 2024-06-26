package _sb0322_01.dao;

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

import _sb0322_01.dto.Emp;

@Repository
public class EmpDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Emp> selectAllEmp() {
		List<Emp> list2 = jdbcTemplate.query("SELECT * FROM EMP", (ResultSet rs, int rowNum) -> {
			Emp emp = new Emp(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getInt("mgr"),
					rs.getString("hiredate"), rs.getInt("sal"), rs.getInt("comm"), rs.getInt("deptno"));
			return emp;
		});
		return list2;

	}

	public List<Emp> selectAllByDeptNo(int deptno) {
		List<Emp> list2 = jdbcTemplate.query("SELECT * FROM EMP WHERE DEPTNO = ?", (ResultSet rs, int rowNum) -> {
			Emp emp = new Emp(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getInt("mgr"),
					rs.getString("hiredate"), rs.getInt("sal"), rs.getInt("comm"), rs.getInt("deptno"));
			return emp;
		}, deptno);
		return list2;

	}

	public Emp selectByEmpno(int empno) {
		List<Emp> results = jdbcTemplate.query("SELECT * FROM EMP WHERE EMPNO = ?", (ResultSet rs, int rowNum) -> {
			Emp emp = new Emp(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getInt("mgr"),
					rs.getString("hiredate"), rs.getInt("sal"), rs.getInt("comm"), rs.getInt("deptno"));
			return emp;
		}, empno);
		return results.isEmpty() ? null : results.get(0);
	}

	public void insert(Emp emp) {

		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (?, ?, ?, ?,sysdate,?,?,?)");
				pstmt.setInt(1, emp.getEmpno());
				pstmt.setString(2, emp.getEname());
				pstmt.setString(3, emp.getJob());
				pstmt.setInt(4, emp.getMgr());
				pstmt.setInt(5, emp.getSal());
				pstmt.setInt(6, emp.getComm());
				pstmt.setInt(7, emp.getDeptno());
				return pstmt;
			}
		});

	}

	public void update(Emp emp) {
		jdbcTemplate.update(
				"UPDATE EMP SET ename = ?, job = ?, mgr = ?, sal = ?, comm = ?, deptno = ? where empno = ?",
				emp.getEname(), emp.getJob(), emp.getMgr(), emp.getSal(), emp.getComm(),
				emp.getDeptno(), emp.getEmpno());
	}

}
