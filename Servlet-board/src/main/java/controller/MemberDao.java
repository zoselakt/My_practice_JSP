package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
	private static MemberDao instance;
	private JdbcUtil ju = JdbcUtil.getInstance();
	
	private MemberDao() {}
	
	public static MemberDao getInstance() {
		if(instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	public Date stringToDate(MemberVo vo) {
		String year = vo.getBirthyy();
		String month = vo.getBirthmm();
		String day = vo.getBirthdd();
		Date birthday = Date.valueOf(year+"-"+month+"-"+day);
		return birthday;
	}
	
	public void insertMember(MemberVo vo) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ju.getConnection();
			con.setAutoCommit(false);
			
			StringBuffer sql = new StringBuffer();
			sql.append("insert into jsp_member");
			sql.append("(id, password, name, gender, birth, email1, phone, address, reg)");
			sql.append("values(?,?,?,?, ?,?,?,?, sysdate)");
			stringToDate(vo);
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getGender());
			pstmt.setDate(5, stringToDate(vo));
			pstmt.setString(6, vo.getEmail1() + "@" + vo.getEmail2());
			pstmt.setString(7, vo.getPhone());
			pstmt.setString(8, vo.getAddress());
			pstmt.executeUpdate();
			System.out.println(con);
			con.commit();
		}catch(SQLException e){
			con.rollback();
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	public MemberVo getUserInfo(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo vo = null;
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("select * from jsp_member where id=?");
			
			con = ju.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				String birthday = rs.getDate("birth").toString();
				String year = birthday.substring(0, 4);
				String month = birthday.substring(5, 7);
				String day = birthday.substring(8, 10);
				
				String email = rs.getString("mail");
				int idx = email.indexOf("@");
				String email1 = email.substring(0, idx);
				String email2 = email.substring(idx + 1);
				
				vo = new MemberVo();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setGender(rs.getString("gender"));
				vo.setBirthyy(year);
				vo.setBirthmm(month);
				vo.setBirthdd(day);
				vo.setEmail1(email1);
				vo.setEmail2(email2);
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setReg(rs.getTimestamp("reg"));
			}
			return vo;
		}catch(SQLException  e){
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	public void updateMember(MemberVo vo)throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE jsp_member set");
			sql.append("password =?, email=?, phone=?, address=?");
			sql.append("where id=?");
			
			con = ju.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			
			con.setAutoCommit(false);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getEmail1() + "@" + vo.getEmail2());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getAddress());
			pstmt.setString(5, vo.getId());
			pstmt.executeUpdate();
			con.commit();
		}catch(SQLException  e){
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	public int deleteMember(String id, String pw) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbPW="";
		int x = -1;
		try {
			StringBuffer sql1 = new StringBuffer();
			sql1.append("select password from jsp_member where id=?");
			
			StringBuffer sql2 = new StringBuffer();
			sql1.append("delete from jsp_member where id=?");
			con = ju.getConnection();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql1.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbPW = rs.getString("password");
				if(dbPW.equals(pw)) {
					pstmt = con.prepareStatement(sql2.toString());
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					con.commit();
					x = 1; //삭제성공
				}else {
					x = 0; // 비밀번호 비교 결과 다름
				}
			}
			return x;
		}catch(SQLException  e){
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	public int loginCheck(String id, String pw) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbPW="";
		int x = -1;
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("select password from jsp_member where id=?");
			con = ju.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dbPW = rs.getString("password");
				if(dbPW.equals(pw)) {
					x = 1;
				}else {
					x = 0;
				}
			}else {
				x = -1;
			}
			return x;
		}catch(SQLException  e){
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	public ArrayList<MemberVo> getMemberList(){
		ArrayList<MemberVo> memberList = new ArrayList<MemberVo>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo vo = null;
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("select * from jsp_member");
			con = ju.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVo();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setGender(rs.getString("gender"));
				vo.setBirthyy(rs.getString("birth").toString());
				vo.setEmail1(rs.getString("email1"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setReg(rs.getTimestamp("reg"));
				memberList.add(vo);
			}
		}catch(SQLException  e){
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return memberList;
	}
}
