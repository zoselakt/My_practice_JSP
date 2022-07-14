package jv300.mod001.dao;

import java.sql.*;
import java.util.*;

import jv300.mod001.DataSource;
import jv300.mod001.InitializeDataSource;
import jv300.mod001.NamingService;

import jv300.mod001.vo.MemberVo;

public class MemberDao {
	private DataSource dataSource;
	
	public MemberDao() {
		NamingService ns = NamingService.getInstance();
		dataSource = (DataSource) ns.getAttribute("dataSource");
	}
	
	public void addUser(MemberVo vo) {
		String sql = "insert into addmember(ID, PASSWORD, NAME, SSN, EMAIL1, EMAIL2, ADDR1, ADDR2) VALUES (?,?,?,?, ?,?,?,?) ";
		Connection con = null;
		PreparedStatement pstmt = null;
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
			pstmt.executeUpdate();
			
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
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<MemberVo> findUser() {
		String sql = "select * from addmember";
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
	public void modifyUser(String id, String password) {
		String sql = "update addmember set (name, email1, email2, addr1, addr2) where (?,?,?,?,?) ";
		Connection con = null;
		PreparedStatement pstmt = null;
		MemberVo vo = null;
		try {
			con = dataSource.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail1());
			pstmt.setString(3, vo.getEmail2());
			pstmt.setString(4, vo.getAddr1());
			pstmt.setString(5, vo.getAddr2());
			pstmt.executeUpdate();
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
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void removeUser(String id, String password) {
		String sql ="delete from addmember where id=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		MemberVo vo = null;
		try {
			con = dataSource.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
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
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}