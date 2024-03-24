package _sb0322.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _sb0322.dao.MemberDao2;
import _sb0322.dto.Member2;


@Service
public class ListService {
	@Autowired
	private MemberDao2 memberDao;

	public List<Member2> selectAll() {
		return memberDao.selectAll();
	}
}
