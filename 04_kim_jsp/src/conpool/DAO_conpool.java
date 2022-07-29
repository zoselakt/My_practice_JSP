package conpool;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import conpool.MemberDTO;

// 커넥션 풀 적용후 비교하기
public class DAO_conpool {
//	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
//	private String uid = "hr";
//	private String upw = "hr";
	
	private DataSource ds;
//	
//	public MemberDAO(String url, String uid, String upw) {
	public DAO_conpool(String url, String uid, String upw) {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		try {
			Context ctx = new InitialContext(); // 컨텍스트 객체
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g(작성한 이름)"); // 룩업으로 매칭(값을 찾아오는 과정)
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDTO> selectMember(){
		ArrayList<MemberDTO> mdtos = new ArrayList<MemberDTO>();
		
		Connection dbconn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member";
		try {
//			dbconn = DriverManager.getConnection(url, uid, upw); // Was가 대신수행함.
			dbconn = ds.getConnection(); // 커넥션 객체
			stmt = dbconn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String hp = rs.getString("hp");
				String hp2 = rs.getString("hp2");
				String hp3 = rs.getString("hp3");
				String gender = rs.getString("gender");
				
				MemberDTO mdto = new MemberDTO(name, id, pw, hp, hp2, hp3, gender);
				mdtos.add(mdto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(dbconn != null) dbconn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return mdtos;
	}
}
