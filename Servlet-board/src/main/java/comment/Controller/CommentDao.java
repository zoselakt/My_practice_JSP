package comment.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.JdbcUtil;

public class CommentDao {
	private static CommentDao instance;
	private JdbcUtil ju;
	public static CommentDao getInstance() {
		if(instance == null) {
			instance = new CommentDao();
		}
		return instance;
	}
	//시퀀스 불러오기
	public int getSeq() {
		int result = 1;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ju.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" select board_num.nextval from dual ");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return result;
	}
	public boolean insertComment(CommentVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			con = ju.getConnection();
			con.setAutoCommit(false);
			StringBuffer sql = new StringBuffer();
			sql.append(" Insert into jsp_comment ");
			sql.append(" (comment_num, comment_board, comment_id, comment_date");
			sql.append(", comment_parent, comment_content) ");
			sql.append(" values(?,?,?, sysdate, ?,?) ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, vo.getComment_num());
			pstmt.setInt(2, vo.getComment_board());
			pstmt.setString(3, vo.getComment_id());
			pstmt.setInt(4, vo.getComment_parent());
			pstmt.setString(5, vo.getComment_content());
			
			int flag = pstmt.executeUpdate();
			if(flag > 0) {
				result = true;
				con.commit();
			}
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return result;
	}
	public ArrayList<CommentVo> getCommentList(int boardNum){
		ArrayList<CommentVo> list = new ArrayList<CommentVo>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ju.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" select * from ");
			sql.append(" (select rownum as rnum, data.* from ");
			sql.append(" (select level, comment_num, comment_board ");
			sql.append(", comment_id, comment_date, comment_parent, comment_content ");
			sql.append(" from jsp_comment where comment_board = ? ");
			sql.append(" start with comment_parent = 0 ");
			sql.append(" connect by prior comment_num = comment_parent) ");
			sql.append(" data) ");
			sql.append(" where rnum >= ? and rnum <= ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNum);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CommentVo vo = new CommentVo();
				vo.setComment_level(rs.getInt("level"));
				vo.setComment_num(rs.getInt("comment_num"));
				vo.setComment_board(rs.getInt("comment_board"));
				vo.setComment_id(rs.getString("comment_id"));
				vo.setComment_date(rs.getDate("comment_date"));
				vo.setComment_parent(rs.getInt("comment_parent"));
				vo.setComment_content(rs.getString("comment_content"));
				list.add(vo);
			}
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return list;
	}
}
