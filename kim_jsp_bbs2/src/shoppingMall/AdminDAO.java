package shoppingMall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AdminDAO {
	public static final int ADMIN_NONEXISTENT = 0;
	public static final int ADMIN_EXIST= 1;
	public static final int ADMIN_LOGIN_PW_FAIL= 0;
	public static final int ADMIN_LOGIN_SUCESS= 1;
	public static final int ADMIN_LOGIN_NOT= -1;
	
	private static AdminDAO insAdmin = new AdminDAO();
	
	private AdminDAO(){		
	}
	
	public static AdminDAO getInstance(){
		return insAdmin;
	}
	
	public int adminCheck(String id, String pw){
		int n = 0;
		String dbPw;
		
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select password from admin where id = ?";
		
		try {
			dbconn = getConnection();
			pstmt=dbconn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dbPw = rs.getString("password");
				if(dbPw.equals(pw)){
					n = AdminDAO.ADMIN_LOGIN_SUCESS; //�α��� ����
				}else{
					n = AdminDAO.ADMIN_LOGIN_PW_FAIL; //��� ����ġ
				}
			}else{
				n = AdminDAO.ADMIN_LOGIN_NOT;
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally{
			try{
				rs.close();
				pstmt.close();
				dbconn.close();
			}catch(Exception ee){
				ee.printStackTrace();
			}
		}
		
		return n;		
	} //adminCheck
	
	
	public AdminDTO getAdmin(String id){
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from admin where id = ?";
		AdminDTO adto = null;
		
		try{
			dbconn = getConnection();
			pstmt = dbconn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				adto = new AdminDTO();
				adto.setId(rs.getString("id"));
				adto.setPw(rs.getString("password"));
				adto.setName(rs.getString("name"));
				adto.setEmail(rs.getString("email"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				dbconn.close();
			}catch(Exception ee){
				ee.printStackTrace();
			}
		}
		return adto;
	}
	
	
	
	private Connection getConnection(){
		Context ctx = null;
		DataSource dataSource = null;
		Connection dbconn = null;
		
		try{
			ctx = new InitialContext();
			dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/myOracle");
			dbconn = dataSource.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return dbconn;
	}
	
}
