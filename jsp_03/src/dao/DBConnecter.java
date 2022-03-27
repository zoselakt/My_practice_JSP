package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnecter {
	//DAO에서 모든 메소드에 필요한 DB연결 문법을 미리 메소드에 선언해 놓는다.
	public static Connection getconnection() {
		Connection conn = null;
		try {
			//DB연결을 위한 정보
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "hr"; 
			String pw = "hr";
			//드라이버를 메모리에 할당한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//입력한 정보를 전달하여 드라이버를 통해 연결 객체를 가져온다.
			conn = DriverManager.getConnection(url, user, pw);
			
			//예외처리
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
