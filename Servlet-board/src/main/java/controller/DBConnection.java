package controller;

import java.sql.*;

import javax.naming.*;

public class DBConnection {
	public static Connection getconnection() throws SQLException, NamingException, ClassNotFoundException{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/myOracle");
		Connection con = ds.getConnection();
		return con;
	}
}
