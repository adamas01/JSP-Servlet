package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.ElecDTO;
import util.DB;

public class ElecDAOImpl implements ElecDAO {

	@Override
	public List<ElecDTO> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// DTO에 있는 값을 받아올 list객체 생성
		List<ElecDTO> list = new ArrayList<>();

		String sql = "SELECT * FROM ELECTRONICS ORDER BY WRITEDAY DESC";
		// DB연결. sql문 실행
		try {
			con = DB.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			// 쿼리에 값이 있으면 while반복문으로 돌려서 DTO값을 받아온다.
			while (rs.next()) {
				// list에 받은 객체 값을 넣어준다.
				ElecDTO elec = new ElecDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9));

				list.add(elec);
			}
		} finally {
			DB.dbClose(rs, ps, con);
		}
		return list;
	}

	// ModelNum을 가지고 게시글 조회를 한다.
	@Override
	public ElecDTO searchByModelNum(String ModelNum) throws SQLException {
		Connection con = DB.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ElecDTO elec = null;

		String sql = "SELECT * FROM ELECTRONICS WHERE MODEL_NUM=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ModelNum);
			rs = ps.executeQuery();

			if (rs.next()) {
				elec = new ElecDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9));
			}
		} finally {
			DB.dbClose(rs, ps, con);
		}
		return elec;
	}

	// 조회수 증가
	@Override
	public int increaseViews(String ModelNum) throws SQLException {
		Connection con = DB.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE ELECTRONICS SET READNUM = READNUM+1 WHERE MODEL_NUM=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ModelNum);
			result = ps.executeUpdate();
		} finally {
			DB.dbClose(ps, con);
		}
		return result;
	}

	// 글쓰기
	@Override
	public int writing(ElecDTO elec) throws SQLException {
		Connection con = DB.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO ELECTRONICS " + "VALUES(?,?,?,?,?,SYSDATE,0,?,?)";
		try {
			// sql을 통해서 값 세팅하기
			ps = con.prepareStatement(sql);
			ps.setString(1, elec.getModelNum());
			ps.setString(2, elec.getModelName());
			ps.setInt(3, elec.getPrice());
			ps.setString(4, elec.getDescription());
			ps.setString(5, elec.getPassword());
			ps.setString(6, elec.getFname());
			ps.setInt(7, elec.getFsize());
			
			// int변수안에 sql업데이트값을 넣기
			result = ps.executeUpdate();
		} finally {
			DB.dbClose(ps, con);
		}
		return result;

	}

	//수정하기
	@Override
	public int editPost(ElecDTO elec) throws SQLException {
		Connection con = DB.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		String sql="UPDATE ELECTRONICS SET "+"MODEL_NAME=?,PRICE=?,DESCRIPTION=?"
		+" WHERE MODEL_NUM=? AND PASSWORD=?";		
		try {
			ps = con.prepareStatement(sql);
			//sql실행해서 각 수정값을 가져온다.
			ps.setString(1, elec.getModelName());
			ps.setInt(2, elec.getPrice());
			ps.setString(3, elec.getDescription());
			ps.setString(4, elec.getModelNum());
			ps.setString(5, elec.getPassword());
			
			//sql실행결과값을 변수에 넣어준다.
			result = ps.executeUpdate();
		}finally {
			DB.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int delete(String modelNum, String password) throws SQLException {
		Connection con = DB.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		String sql ="DELETE ELECTONICS WHERE MODEL_NUM=? AND PASSWORD=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, modelNum);
			ps.setString(2, password);
			result = ps.executeUpdate();
		}finally {
			DB.dbClose(ps, con);
		}
		return result;
	}


}
