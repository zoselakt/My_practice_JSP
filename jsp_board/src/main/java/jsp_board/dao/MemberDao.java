package jsp_board.dao;

import java.sql.*;

import jsp_board.jdbc.Jdbcutil;
import jsp_board.vo.MemberVo;

public class MemberDao {
	Jdbcutil jdbcutil = Jdbcutil.getInstance();
	
	public MemberDao() {}
	
	public int addUser(MemberVo vo) {
		String sql = "insert into jsp_Member(NUM, MEMBERID, PASSWORD, NAME, PHONE, ADDR, ADDR2, GENDER) values (JSP_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?)";
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
}
