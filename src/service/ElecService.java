package service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import dao.ElecDAO;
import dao.ElecDAOImpl;
import domain.ElecDTO;

public class ElecService {
	
	//DAO 싱글톤 생성
	private static ElecDAO elecDAO = new ElecDAOImpl();
	
	public static List<ElecDTO> selectAll() throws SQLException{
		List<ElecDTO> list = elecDAO.selectAll();
		return list;
	}
	/**
	 * ElecDAOImpl의 모델번호에 해당하는 레코드 검색하는 메서드 호출
	 * @param: boolean flag- 조회수 증가 여부를 판별하는 매개변수(true이면 조회수 증가/false이면 조회수 증가 안함)
	 * */
	public static ElecDTO searchByModelNum(String modelNum, boolean flag) throws SQLException{
		if(flag) {
			int result = elecDAO.increaseViews(modelNum);
			if(result==0) throw new SQLException("조회수 증가에 오류가 발생했습니다.");
		}
		ElecDTO elec = elecDAO.searchByModelNum(modelNum);
		if(elec==null) throw new SQLException();
		return elec;
	}
		
	/**
	 * ElecDAOImpl의 레코드 삽입하는 메서드 호출
	 * */
	public static int writing(ElecDTO elec) throws SQLException{
		int result = elecDAO.writing(elec);
		if(result==0) throw new SQLException("글이 등록되지 않았습니다.");
		return result;
	}
	
	/**
	 * ElecDAOImpl의 모델번호에 해당하는 레코드 수정 메서드 호출
	 * */
	public static int editPost(ElecDTO elec) throws SQLException{
		ElecDTO dbElec = elecDAO.searchByModelNum(elec.getModelNum());
		
		if(!dbElec.getPassword().equals(elec.getPassword())) {
			throw new SQLException("비밀번호를 재확인해주세요");
		}
		int result = elecDAO.editPost(elec);
		if(result==0) throw new SQLException();
		
		return result;
		
	}
	public static int delete(String modelNum, String password,String path) throws SQLException{
		ElecDTO dbElec = elecDAO.searchByModelNum(modelNum);
		if(!dbElec.getPassword().equals(password)) {
			throw new SQLException("비밀번호 오류입니다.");
		}
		int result = elecDAO.delete(modelNum, password);
		if(result==0)throw new SQLException("삭제되지 않았습니다.");
		
		//삭제 완료후에 파일 삭제하기
		if(dbElec.getFname()!=null) {
			new File(path, dbElec.getFname()).delete();
		}
		return result;	
	
	}

}


