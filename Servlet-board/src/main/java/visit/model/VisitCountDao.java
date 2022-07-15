package visit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.JdbcUtil;

public class VisitCountDao {
	private static VisitCountDao instance;
	JdbcUtil ju = JdbcUtil.getInstance();
	
	private VisitCountDao() {}
	public static VisitCountDao getInstance() {
		if(instance == null) {
			instance = new VisitCountDao();
		}
		return instance;
	}
	public void setTotalCount() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("insert into visit (v_date) values(sysdate)");
			con = ju.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql.toString());
			pstmt.executeUpdate();
			con.commit();
		}catch(SQLException  e){
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
	public int getTotalCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalCount = 0;
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("select count(*) as totalcnt from visit");
			con = ju.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalCount = rs.getInt("totalcnt");
			}
			return totalCount;
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
	public int getTodayCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalCount = 0;
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("select count(*) as todaycnt from visit");
			sql.append("where to_date(v_date, 'yyyy-mm-dd') = to_date(sysdate, 'yyyy-mm-dd')");
			
			con = ju.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				totalCount = rs.getInt("totalcnt");
			}
			return totalCount;
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
}
