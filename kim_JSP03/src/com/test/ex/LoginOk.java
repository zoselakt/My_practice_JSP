package com.test.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginOk
 */
@WebServlet("/LoginOk")
public class LoginOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Connection dbconn;
	private Statement stmt;
	private ResultSet rs;
	
	private String name, id, pw, hp ,hp2, hp3, gender;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		loginDo(request, response);
	}
	
	private void loginDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		
		String sql = "select * from member where id = '"+id+"' and pw = `"+pw+"'";
		
	 	try {
	 		Class.forName("oracle.jdbc.driver.OracleDriver");
	 		dbconn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
	 		stmt = dbconn.createStatement();
	 		rs = stmt.executeQuery(sql);
	 		while (rs.next()) {
	 			name = rs.getString("name");
	 			id = rs.getString("id");
	 			pw = rs.getString("pw");
	 			hp = rs.getString("hp");
	 			hp2 = rs.getString("hp2");
	 			hp3 = rs.getString("hp3");
	 			gender = rs.getString("gender");
	 		}
	 		//세션 생성
	 		HttpSession httpSession = request.getSession();
	 		httpSession.setAttribute("name", name);
	 		httpSession.setAttribute("id", id);
	 		httpSession.setAttribute("pw", pw);
	 		
	 		response.sendRedirect("loginRes.jsp");
	 	}catch(Exception e){
	 		e.printStackTrace();
	 	}finally {
			try {
				if(stmt != null) stmt.close();
				if(dbconn != null) dbconn.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		}
	}
}
