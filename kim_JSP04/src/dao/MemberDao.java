package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	Jdbcutil jdbcutil = Jdbcutil.getInstance();
	private static MemberDao daoIns = new MemberDao();
	
	public MemberDao() {}
	
	public static MemberDao getInstance() {
		return daoIns;
	}
	
	public List<MemberVo> list(String keyword) {
		List<MemberVo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String query = "SELECT * FROM T_MEMBER";
			conn = jdbcutil.getConnection();
			
			if(keyword != null && !keyword.isEmpty()) {
				query += " WHERE NAME LIKE '%' || ? || '%'";
			}
			
			pstmt = conn.prepareStatement(query);
			
			if(keyword != null && !keyword.isEmpty()) {
				pstmt.setString(1, keyword);
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int idx = 1;
				MemberVo vo = new MemberVo();
				rs.getString(idx++);
				rs.getString(idx++);
				rs.getString(idx++);
				rs.getString(idx++);
				rs.getString(idx++);
				rs.getString(idx++);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
