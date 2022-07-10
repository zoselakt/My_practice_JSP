package jsp_board.jdbc;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

public class Jdbcutil {
	private static Jdbcutil instance = new Jdbcutil();
	private static Context ctx;
	
	private static DataSource ds;
	private Jdbcutil() {}
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myOracle");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Jdbcutil getInstance() {
		return instance;
	}
	public Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
}
