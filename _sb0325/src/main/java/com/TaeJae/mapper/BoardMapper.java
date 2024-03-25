package com.TaeJae.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.TaeJae.dto.BoardDto;

@Mapper
public interface BoardMapper {
	List<BoardDto> selectBoardList();

	int selectCount();

	void insertBoard(BoardDto board);

//	BoardDto selectBoardDetail(int boardIdx);
//
//	void updateHitCount(int boardIdx);
	
	void updateBoard(BoardDto board);

	void deleteBoard(int boardIdx);
}
