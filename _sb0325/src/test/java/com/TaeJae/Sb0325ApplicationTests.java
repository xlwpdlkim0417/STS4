package com.TaeJae;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.TaeJae.dto.BoardDto;
import com.TaeJae.mapper.BoardMapper;

@SpringBootTest
class Sb0325ApplicationTests {

	@Autowired
	BoardMapper boardMapper;

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("member 테이블의 개수")
	void memberCount() {
		System.out.println(boardMapper.selectCount());
	}

	@Test
	@DisplayName("member 테이블의 내용")
	void memberSelectAll() {
		for (BoardDto dto : boardMapper.selectBoardList()) {
			System.out.println(dto);
		}
	}

//	@Test
	@DisplayName("member insert 테스트")
	void memberInsert() {
		BoardDto dto = BoardDto.builder().email("acroaka@gmail.com").name("나하나").password("7654").build();
		boardMapper.insertBoard(dto);
	}

//	@Test
	@DisplayName("member delete 테스트")
	void memberDelete() {
		int before = boardMapper.selectCount();
		boardMapper.deleteBoard(7);
		int after = boardMapper.selectCount();
		assertEquals(before - 1, after);
	}
	
	@Test
	@DisplayName("member insert 테스트")
	void memberUpdate() {
		BoardDto dto = BoardDto.builder().email("hanakang@gmail.com").name("강하나").password("3296").id(8).build();
		boardMapper.updateBoard(dto);
	}

}
