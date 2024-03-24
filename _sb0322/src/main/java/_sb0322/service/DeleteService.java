package _sb0322.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _sb0322.dao.MemberDao2;
import _sb0322.dto.Member2;



@Service
public class DeleteService {
	
	@Autowired
	private MemberDao2 memberDao;
	
	public void deleteService(Member2 member) {
		memberDao.delete(member);
	}
	
}
