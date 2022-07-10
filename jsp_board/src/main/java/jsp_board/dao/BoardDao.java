package jsp_board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jsp_board.jdbc.Jdbcutil;
import jsp_board.vo.BoardVo;

public class BoardDao {
	Jdbcutil jdbcutil = Jdbcutil.getInstance();
	private static BoardDao daoutil = new BoardDao();
	
	private BoardDao() {}
	
	private static BoardDao getInstance() {
		return daoutil;
	}
	
	public int create(BoardVo vo) {
		String sql = "insert into JSP_BOARD (NUM, TITLE, WRITER, CONTENTS, REGDATE, CNT) VALUES(JSP_SEQ.nextval, ?,?,? sysdate, 0)" ;
		Connection con = null;
		PreparedStatement pstmt = null;
		int ref = -1;
		try {
			con = jdbcutil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContents());
			ref = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return ref;
	}
	public List<BoardVo> boardAll(){
		String sql = "select * from jsp_board";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardVo> ls = new ArrayList<BoardVo>();
		try {
			con = jdbcutil.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
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
				if(con != null) {con.close();}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return ls;
	}
}
