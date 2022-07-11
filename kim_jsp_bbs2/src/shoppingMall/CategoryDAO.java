package shoppingMall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CategoryDAO {
	private static CategoryDAO insCatDAO = new CategoryDAO();
	
	private CategoryDAO(){
		
	}
	
	public static CategoryDAO getInstance(){
		return insCatDAO;
	}
	
	public int insertCat(String code, String cname){
		
		int n = 0;
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into category values(category_seq.nextval,?,?)";
		
		try {
			dbconn = getConnection();
			pstmt = dbconn.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.setString(2, cname);
			n = pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(dbconn !=null) dbconn.close();
			}catch(Exception ee){
				ee.printStackTrace();
			}
		} 
		
		return n;
	} //insertCat
	
	//**** 카테고리 목록을 가져오기 *****//
	public ArrayList<CategoryDTO> categoryAll() throws SQLException{
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			dbconn = getConnection();
			String sql = "select * from category order by catenum desc";
			pstmt = dbconn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<CategoryDTO> cdtos = new ArrayList<CategoryDTO>();
			while(rs.next()){
				String cnum = rs.getString("catenum");
				String code = rs.getString("code");
				String cname = rs.getString("catename");
				
				CategoryDTO cdto = new CategoryDTO(cnum, code, cname);
				cdtos.add(cdto);
			}//while End
			return cdtos;			
		}finally{
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
			if(dbconn != null) dbconn.close();
		}
	}//categoryAll()
	
	public int categoryDelete(String cnum) throws SQLException{
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		
		try{
			dbconn = getConnection();
			String sql = "delete from category where catenum=?";
			pstmt = dbconn.prepareStatement(sql);
			pstmt.setString(1,cnum);
			int n = pstmt.executeUpdate();
			return n;
		}finally{			
			if(pstmt !=null) pstmt.close();
			if(dbconn !=null) dbconn.close();
		}
	}
	
	
	private Connection getConnection(){
		Context ctx = null;
		DataSource dataSource = null;
		Connection dbconn = null;
		
		try{
			ctx = new InitialContext();
			dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			dbconn = dataSource.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}		
		return dbconn;
	}	
}


