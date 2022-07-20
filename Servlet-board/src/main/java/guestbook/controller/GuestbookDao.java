package guestbook.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.JdbcUtil;

public class GuestbookDao {
	private static GuestbookDao instance;
	private JdbcUtil ju;
	
	private GuestbookDao() {}
	public static GuestbookDao getInstance() {
		if(instance == null) {
			instance = new GuestbookDao();
		}
		return instance;
	}
	public int getSeq() {
		int result = 1;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ju.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select guestbook_no_seq.nextval from dual");
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
	public boolean guestbookInsert(GuestbookVo vo) {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ju.getConnection();
			con.setAutoCommit(false);
			StringBuffer sql = new StringBuffer();
			sql.append("insert into guestbook");
			sql.append("(guestbook_no, guestbook_id, guestbook_password, guestbook_content");
			sql.append(", guestbook_group, guestbook_parent, guestbook_date)");
			sql.append("values(?,?,?,?,?,?,sysdate)");
			
			int no = vo.getGuestbook_no();
			int group = vo.getGuestbook_group();
			int parent = vo.getGuestbook_parent();
			
			if(parent == 0) {
				group = no;
			}
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			pstmt.setString(2, vo.getGuestbook_id());
			pstmt.setString(3, vo.getGuestbook_password());
			pstmt.setString(4, vo.getGuestbook_content());
			pstmt.setInt(5, group);
			pstmt.setInt(6, parent);
			
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
}
