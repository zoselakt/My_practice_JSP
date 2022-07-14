package jsp_board.dao;

import java.sql.*;

import jsp_board.jdbc.Jdbcutil;
import jsp_board.vo.MemberVo;

public class MemberDao {
	Jdbcutil jdbcutil = Jdbcutil.getInstance();
	private static MemberDao daoIns = new MemberDao();
	
	public MemberDao() {}
	
	public static MemberDao getInstance() {
		return daoIns;
	}
	
	public int addUser(MemberVo vo) {
		String sql = "insert into jsp_Member(NUM, MEMBERID, PASSWORD, NAME, PHONE, ADDR, ADDR2, GENDER) values (BOARD_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement pstmt =null;
		int ref = -1;
		
		try {
			con = jdbcutil.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getMemberid());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getAddr());
			pstmt.setString(6, vo.getAddr2());
			pstmt.setString(7, vo.getGender());
			ref = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
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
	//아이디 중복검사
	public boolean checkId(String memberid) {
		String sql = "select COUNT(memberid) from jsp_Member where memberid = ? ";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean check = false;
		
		try {
			con = jdbcutil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberid);
			rs = pstmt.executeQuery();
			
			rs.next();
			check = rs.getInt(1) == 1;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			}catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
		return check;
	}
	public boolean login(String memberid, String password) {
		String sql = "select COUNT(memberid) from jsp_member where memberid=? and password=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean check = false;
		
		try {
			con = jdbcutil.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberid);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();
			rs.next();
			check = rs.getInt(1) == 1;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			}catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
		return check;
	}
	
	public MemberVo getMember(String memberid) {
		String sql = "select * from jsp_member where memberid=?";
		MemberVo vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = jdbcutil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVo();
				vo.setMemberid(rs.getString("memberid"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddr(rs.getString("addr"));
				vo.setAddr2(rs.getString("addr2"));
				vo.setGender(rs.getString("gender"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	// 회원정보 다 바뀌니 수정하자!
	public int modifyMember(MemberVo vo) {
		String sql = "update jsp_member set password=?, name=?, phone=?, addr=?, addr2=?, gender=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int n=0;
		
		try {
			con = jdbcutil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getAddr());
			pstmt.setString(5, vo.getAddr2());
			pstmt.setString(6, vo.getGender());
			n = pstmt.executeUpdate(); 
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return n;
	}
	public MemberVo removeMember(MemberVo vo) {
		String sql = "delete from jsp_member where num=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = jdbcutil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			pstmt.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return vo;
	}
}
