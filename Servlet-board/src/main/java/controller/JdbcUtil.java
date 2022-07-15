package controller;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

public class JdbcUtil {
	private static JdbcUtil instance = new JdbcUtil();
	private static Context ctx;
	
	private static DataSource ds;
	private JdbcUtil() {}
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myOracle"); //context에 있는 경로
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static JdbcUtil getInstance() { 
		return instance;
	}
	public Connection getConnection() throws SQLException{
		return ds.getConnection();//풀에서 커넥션 반환	
	}
}
