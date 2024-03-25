package _sb0322_01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import _sb0322_01.dto.Emp;
import _sb0322_01.mapper.EmpMapper;

@SpringBootTest
class Sb03221ApplicationTests {

	@Autowired
	EmpMapper empMapper;
	
	@Test
	@DisplayName("Emp 리스트 테스트")
	void selectEmpList() {
		System.out.println(empMapper.selectEmpList());
	}
	
	@Test
	@DisplayName("Emp 삽입 테스트")
	void insertEmp() {
		Emp emp =  Emp.builder().empno(9999).ename("MARIO").job("TESTER").mgr(9999).hiredate("20240325").sal(9000).comm(900).deptno(10).build();
		empMapper.insertEmp(emp);
	}
	
	@Test
	@DisplayName("Emp 업데이트 테스트")
	void updateEmp() {
		Emp emp =  Emp.builder().ename("KOOPA").job("TURTLE").mgr(0000).hiredate("20231228").sal(8000).comm(800).deptno(20).empno(9999).build();
		empMapper.updateEmp(emp);
	}
	
	@Test
	@DisplayName("Emp 삭제 테스트")
	void deleteEmp() {
		empMapper.deleteEmp(9999);
	}

}
