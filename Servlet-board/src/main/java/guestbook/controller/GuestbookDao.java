package guestbook.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			sql.append("insert into guestbook ");
			sql.append(" (guestbook_no, guestbook_id, guestbook_password, guestbook_content ");
			sql.append(", guestbook_group, guestbook_parent, guestbook_date )");
			sql.append(" values(?,?,?,?,?,?,sysdate) ");
			
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
	//
	public ArrayList<GuestbookVo> getGuestbookList(int pageNum){
		ArrayList<GuestbookVo> list = new ArrayList<GuestbookVo>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ju.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * from");
			sql.append(" (select rownum as rnum, data.* from ");
			sql.append(" guestbook_password, guestbook_content, ");
			sql.append(" guestbook_group, guestbook_parent, guestbook_date ");
			sql.append(" from guestbook ");
			sql.append(" start with guestbook_parent = 0 ");
			sql.append(" connection by prior guestbook_no = guestbook_parent ");
			sql.append(" order siblings by guestbook_group desc) ");
			sql.append(" data) ");
			sql.append(" where rnum >= ? and rnum <=?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, pageNum);
			pstmt.setInt(2, pageNum+4);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GuestbookVo vo = new GuestbookVo();
				vo.setGuestbook_no(rs.getInt("guestbook_no"));
				vo.setGuestbook_id(rs.getString("guestbook_id"));
				vo.setGuestbook_password(rs.getString("guestbook_password"));
				vo.setGuestbook_content(rs.getString("guestbook_content"));
				vo.setGuestbook_group(rs.getInt("guestbook_group"));
				vo.setGuestbook_parent(rs.getInt("guestbook_parent"));
				vo.setGuestbook_date(rs.getDate("guestbook_date"));
				list.add(vo);
			}
		}catch (SQLException e) {
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
		return list;
	}
	public int getGuestbookCount() {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ju.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select count(*) from guestbook");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (SQLException e) {
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
	public GuestbookVo getGuestbook(int g_num) {
		GuestbookVo vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ju.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * from guestbook where guestbook_no = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, g_num);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new GuestbookVo();
				vo.setGuestbook_no(rs.getInt("guestbook_no"));
				vo.setGuestbook_id(rs.getString("guestbook_id"));
				vo.setGuestbook_password(rs.getString("guestbook_password"));
				vo.setGuestbook_content(rs.getString("guestbook_content"));
				vo.setGuestbook_group(rs.getInt("guestbook_group"));
				vo.setGuestbook_parent(rs.getInt("guestbook_parent"));
				vo.setGuestbook_date(rs.getDate("guestbook_date"));
			}
		}catch (SQLException e) {
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
		return vo;
	}
	public String getPassword(int guestbook_no) {
		String password = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ju.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select guestbook_password from guestbook whereguestbook_no = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, guestbook_no);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				password = rs.getString("guestbook_password");
			}
		}catch (SQLException e) {
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
		return password;
	}
	public boolean deleteGuestbook(int guestbook_no) {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ju.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete from guestbook ");
			sql.append(" where guestbook_no in ");
			sql.append(" from guestbook ");
			sql.append(" start with guestbook_no = ? ");
			sql.append(" connect by prior guestbook_no = guestbook_parent) ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, guestbook_no);
			
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
	public boolean updateGuestbook(GuestbookVo vo) {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ju.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update guestbook set ");
			sql.append(" guestbook_id = ? ");
			sql.append(" ,guestbook_content = ? ");
			sql.append(" ,guestbook_date = sysdate ");
			sql.append(" where guestbook_no=? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, vo.getGuestbook_id());
			pstmt.setString(2, vo.getGuestbook_content());
			pstmt.setInt(3, vo.getGuestbook_no());
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
