package _sb0322.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _sb0322.dao.MemberDao2;

@Service
public class CountService {

	@Autowired
	private MemberDao2 memberDao;
	
	public int countService() {
		return memberDao.count();
	}
}
