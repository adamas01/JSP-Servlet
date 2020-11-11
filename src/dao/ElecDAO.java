package dao;

import java.sql.SQLException;
import java.util.List;

import domain.ElecDTO;

public interface ElecDAO {

	List<ElecDTO> selectAll() throws SQLException;
	
	/**
	 * 모델번호에 해당하는 레코드 검색
	 * @param
	 * @return
	 * */
	ElecDTO searchByModelNum(String modelNum) throws SQLException;
	
	/**
	 * 조회수를 증가하는 기능
	 * */
	int increaseViews(String modelNum) throws SQLException;
	
	/**
	 * 레코드 삽입
	 * @return: 1-삽입성공, 0-삽입실패
	 * */
	int writing(ElecDTO elec) throws SQLException;
	
	/**
	 * 모델번호에 해당하는 레코드 수정(모델이름, 가격, 내용)
	 * @return:1-수정성공, 0-수정실패
	 * */
	int editPost(ElecDTO elec) throws SQLException;
	
	/**
	 * 모델번호에 해당하는 레코드 삭제
	 * @return: 1-삭제성공, 0-삭제실패
	 * */
	int delete(String modelNum, String password) throws SQLException;
}
