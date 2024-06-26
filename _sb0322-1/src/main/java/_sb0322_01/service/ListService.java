package _sb0322_01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _sb0322_01.dao.DeptDao;
import _sb0322_01.dao.EmpDao;
import _sb0322_01.dto.Dept;
import _sb0322_01.dto.Emp;

@Service
public class ListService {

	@Autowired
	private DeptDao deptDao;

	@Autowired
	private EmpDao empDao;

	public List<Dept> selectAll() {
		return deptDao.selectAll();
	}

	public List<Emp> selectAllEmp() {
		return empDao.selectAllEmp();
	}

	public List<Emp> selectAllByDeptNo(int deptno) {
		return empDao.selectAllByDeptNo(deptno);
	}

	public Emp selectByEmpno(int empno) {
		return empDao.selectByEmpno(empno);
	}
}
