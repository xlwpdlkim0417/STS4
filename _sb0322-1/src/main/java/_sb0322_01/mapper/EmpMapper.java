package _sb0322_01.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import _sb0322_01.dto.Emp;

@Mapper
public interface EmpMapper {
	List<Emp> selectEmpList();

	int selectCount();

	void insertEmp(Emp board);

//	BoardDto selectBoardDetail(int boardIdx);
//
//	void updateHitCount(int boardIdx);

	void updateEmp(Emp board);

	void deleteEmp(int boardIdx);
}
