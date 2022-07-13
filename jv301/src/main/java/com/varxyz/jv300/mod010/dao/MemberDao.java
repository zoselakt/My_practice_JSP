package com.varxyz.jv300.mod010.dao;

import java.sql.*;
import java.util.*;

import com.varxyz.jv300.mod010.DataSource;
import com.varxyz.jv300.mod010.InitializeDataSource;
import com.varxyz.jv300.mod010.NamingService;
import com.varxyz.jv300.mod010.vo.MemberVo;

public class MemberDao {
	private DataSource dataSource;
	
	public MemberDao() {
		NamingService ns = NamingService.getInstance();
		DataSource ds = (DataSource) ns.getAttribute("name");
	}
	
	public int addUser(MemberVo vo) {
		String sql = "insert into addmember(ID, PASSWORD, NAME, SSN, EMAIL1, EMAIL2, ADDR1, ADDR2) VALUES (?,?,?,?,?,?,?,?) ";
		Connection con = null;
		PreparedStatement pstmt = null;
		int ret = -1;
		try {
			con = dataSource.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getSsn());
			pstmt.setString(5, vo.getEmail1());
			pstmt.setString(6, vo.getEmail2());
			pstmt.setString(7, vo.getAddr1());
			pstmt.setString(8, vo.getAddr2());
			ret = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			}catch (SQLException e) {
				throw new RuntimeException();
			}catch(Exception e) {
				throw new RuntimeException();
			}
		}
		return ret;
	}
	
	public List<MemberVo> findUser() {
		String sql = "select \"NUM\", \"id\", \"password\", \"name\", \"email1\",\"email2\",\"addr1\",\"addr2\",\"regdata\", "
				+ "from addmember";
		MemberVo vo = new MemberVo();
		ArrayList<MemberVo> ls = new ArrayList<MemberVo>();
		Connection conn = null; Statement stmt = null;	ResultSet rs = null;
		
			try {
				conn = dataSource.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					vo.getId();
					vo.getPassword();
					vo.getName();
					vo.getEmail1();
					vo.getEmail2();
					vo.getAddr1();
					vo.getAddr2();
					ls.add(vo);
				}
			}catch(Exception e) {
				throw new RuntimeException(); 
			}finally {
				try {
					if(rs != null) {rs.close();}
					if(stmt != null) {stmt.close();}
					if(conn != null) {conn.close();}
				}catch(Exception e) {
					throw new RuntimeException(); 
				}
			}
		return ls;
	}
	
	public static boolean isValidUser(String userId, String passwd) {
		return false;
	}
}