package connectionpool;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	//상수화
	public static final int MEM_NONEXIST = 0;
	public static final int MEM_EXIST = 1;
	public static final int MEM_JOIN_SUCCESS = 1;
	public static final int MEM_JOIN_FAIL = 0;
	public static final int MEM_LOGIN_SUCCESS = 1;
	public static final int MEM_LOGIN_FAIL = -1;
	
	private static MemberDAO memDAOIns = new MemberDAO();
	
	private MemberDAO() {
		//생성자
	}
	public static MemberDAO getInstance() {
		return memDAOIns;
	}
	//데이터를 삽입하는 과정 / 커넥션풀을 사용하는 메서드
	public int insertMember(MemberDTO mdto){
		int n = 0;
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member1 values(?,?,?,?,?,?)";
		try {
			dbconn = getConnection();
			pstmt = dbconn.prepareStatement(sql);
			pstmt.setString(1, mdto.getId());
			pstmt.setString(2, mdto.getPw());
			pstmt.setString(3, mdto.getName());
			pstmt.setString(4, mdto.getEmail());
			pstmt.setString(5, mdto.getAddress());
			pstmt.setTimestamp(6, mdto.getrDate());
			
			pstmt.executeUpdate();
			n = MemberDAO.MEM_JOIN_SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(dbconn != null) dbconn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return n;
	}
	// 아이디값으로
	public int checkId(String id) {
		int n=0;
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select id from member1 where id = ?";
		try {
			dbconn = getConnection();
			pstmt = dbconn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				n = MemberDAO.MEM_EXIST;
			}else {
				n = MemberDAO.MEM_NONEXIST;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(dbconn != null) dbconn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return n;
	}

	//커넥션 풀을 사용하기 위한 메서드
	private Connection getConnection() {
		Context ctx = null;
		DataSource ds = null;
		Connection dbconn = null;
		
		try {
			ctx = new InitialContext(); 
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			dbconn = ds.getConnection();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dbconn;
	}
}
