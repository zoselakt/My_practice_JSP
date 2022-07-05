package board;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import common.JdbcUtil;

public class BoardDao {
	private JdbcUtil ju;
	
	public BoardDao() {
		ju = JdbcUtil.getInstance();
	}
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public int insert(BoardVo vo) {
		String query = "insert into \"BOARD\" (\"NUM\", \"TITLE\", \"WRITER\", \"CONTENTS\", \"REGDATE\", \"CNT\") VALUES(\"BOARD_SEQ\".nextval, ?, ?, ?, sysdate, 0 ";
		int ret = -1;
		try {
			conn = ju.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContents());
			ret = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			}catch(SQLException e) {
				throw new RuntimeException();
			}
		}
		return ret;
	}
	//전체조회
	public List<BoardVo> selectAll(){
		String query = "select \"NUM\", \"TITLE\", \"WRITER\", \"CONTENTS\", \"REGDATE\", \"CNT\" from \"BOARD\" ";
		ArrayList<BoardVo> ls = new ArrayList<BoardVo>();
		try {
			conn = ju.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery(query);
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
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
				if(rs != null) {rs.close();}
			}catch(SQLException e) {
				throw new RuntimeException();
			}
		}
		return ls;
	}
	//단일조회 / pk로 조회
	public BoardVo selectOne(int num){
		String query = "select \"NUM\", \"TITLE\", \"WRITER\", \"CONTENTS\", \"REGDATE\", \"CNT\" from \"BOARD\" where \"NUM\" = ?  ";
		BoardVo vo = null;
		try {
			conn = ju.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery(query);
			pstmt.setString(1, query);
			
			if(rs.next()) {
				vo = new BoardVo(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						new Date(rs.getDate(5).getTime()),
						rs.getInt(6));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
				if(rs != null) {rs.close();}
			}catch(SQLException e) {
				throw new RuntimeException();
			}
		}
		return vo;
	}
}
