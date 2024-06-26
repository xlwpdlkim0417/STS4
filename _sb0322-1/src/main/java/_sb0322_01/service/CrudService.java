package _sb0322_01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _sb0322_01.dao.EmpDao;
import _sb0322_01.dto.Emp;

@Service
public class CrudService {

	@Autowired
	private EmpDao empDao;

	public void updateService(Emp emp) {
		empDao.update(emp);
	}

	public void insertService(Emp emp) {
		empDao.insert(emp);
	}

}
