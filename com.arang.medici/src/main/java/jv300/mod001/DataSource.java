package jv300.mod001;

import java.sql.*;

public class DataSource {
	private String jdbcDriver;
	private String jdbcUrl;
	private String jdbcUserName;
	private String jdbcPassword;
	
	public DataSource() {}
	
	public DataSource(String jdbcDriver, String jdbcUrl, String jdbcUserName, String jdbcPassword) {
		super();
		this.jdbcDriver = jdbcDriver;
		this.jdbcUrl = jdbcUrl;
		this.jdbcUserName = jdbcUserName;
		this.jdbcPassword = jdbcPassword;
		
		try {
			Class.forName(jdbcDriver);
		}catch(ClassNotFoundException e) {
			throw new RuntimeException("JdbcDriverNotAvailableExcpetion");
		}
	}
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(jdbcUrl, jdbcUserName, jdbcPassword);
		} catch (SQLException e) {
			throw new RuntimeException("Connection No Available Exception");
		}
	}
	public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) throws SQLException{
		if(rs != null && rs.isClosed()) {rs.close();}
		if(pstmt != null && pstmt.isClosed()) {pstmt.close();}
		if(conn != null && conn.isClosed()) {conn.close();}
	}
	public void close(PreparedStatement pstmt, Connection conn) throws SQLException{
		close(null, pstmt, conn);
	}
}
