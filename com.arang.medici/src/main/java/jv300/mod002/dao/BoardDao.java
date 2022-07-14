package jv300.mod002.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jv300.mod001.DataSource;
import jv300.mod002.vo.BoardVo;

public class BoardDao {
	private DataSource ju;
	
	public int insert(BoardVo vo) {
		String query = "insert into JSP_BOARD (NUM, TITLE, WRITER, CONTENTS, REGDATE, CNT) VALUES (BOARD_SEQ.nextval, ?, ?, ?, sysdate, 0) ";
		int ret = -1;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null; 
			try {
				conn = ju.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getWriter());
				pstmt.setString(3, vo.getContents());
				ret = pstmt.executeUpdate();
			}finally {
				try {
					if(pstmt != null) {pstmt.close();}
					if(conn != null) {conn.close();}
				}catch(SQLException e) {
					throw new RuntimeException();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	//전체조회
	public List<BoardVo> selectAll(){
		String query = "select * from JSP_BOARD order by NUM desc ";
		ArrayList<BoardVo> ls = new ArrayList<BoardVo>();
		int num = 0;
		
		try {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs =null;
			try {
				conn = ju.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				updateCnt(num);
				
				while(rs.next()) {
					BoardVo vo = new BoardVo(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							new Date(rs.getDate(5).getTime()),
							rs.getInt(6));
					ls.add(vo);
				}
			}finally {
				try {
					if(rs != null) {rs.close();}
					if(stmt != null) {stmt.close();}
					if(conn != null) {conn.close();}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	//단일조회 / pk로 조회
	public BoardVo selectOne(int num){
		String query = "select * from JSP_BOARD where NUM = ? ";
		BoardVo vo = null;
		
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = ju.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, num);
				updateCnt(num);// 조회수 증가 / 아래에 코드
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					vo = new BoardVo(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							new Date(rs.getDate(5).getTime()),
							rs.getInt(6) + 1);
				}
			}finally {
				try {
					if(rs != null) {rs.close();}
					if(pstmt != null) {pstmt.close();}
					if(conn != null) {conn.close();}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	
	public int update(BoardVo vo) {
		String query = "update JSP_BOARD set TITLE = ?, CONTENTS = ? where NUM = ? ";
		int ret = -1;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = ju.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContents());
				pstmt.setInt(3, vo.getNum());
				ret = pstmt.executeUpdate();
			}finally {
				try {
					if(pstmt != null) {pstmt.close();}
					if(conn != null) {conn.close();}
				}catch(SQLException e) {
					throw new RuntimeException();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	//조회수
	public int updateCnt(int num) {
		String query = "update JSP_BOARD set CNT = CNT+1 where NUM = ? ";
		int ret = -1;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = ju.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, num);
				ret = pstmt.executeUpdate();
			}finally {
				try {
					if(conn != null) {conn.close();}
					if(pstmt != null) {pstmt.close();}
				}catch(SQLException e) {
					throw new RuntimeException();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public int delete(int num) {
		String query = "delete from JSP_BOARD WHERE NUM = ?";
		int ret = -1;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = ju.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, num);
				ret = pstmt.executeUpdate();
			}finally {
				try {
					if(pstmt != null) {pstmt.close();}
					if(conn != null) {conn.close();}
				}catch(SQLException e) {
					throw new RuntimeException();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
}
