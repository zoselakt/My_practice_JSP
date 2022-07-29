package com.test.ex;

import java.sql.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinOk
 */
@WebServlet("/JoinOk")
public class JoinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Connection dbconn;
	private Statement stmt;
	
	private String name, id, pw, hp, hp1, hp2, hp3, gender;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		registerMember(request, response);
	}
	//가입처리: 데이터베이스 연동
	private void registerMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	 	request.setCharacterEncoding("UTF-8");
	 	
	 	name = request.getParameter("name");
	 	id = request.getParameter("id");
	 	pw = request.getParameter("pw");
	 	hp = request.getParameter("hp");
	 	hp2 = request.getParameter("hp2");
	 	hp3 = request.getParameter("hp3");
	 	gender = request.getParameter("gender");
	 	
	 	String sql = "insert into member values('"+name+"', '"+id+"', '"+pw+"', '"+hp+"', '"+hp2+"', '"+hp3+"', '"+gender+"')";
	 	
	 	try {
	 		Class.forName("oracle.jdbc.driver.OracleDriver");
	 		dbconn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
	 		stmt = dbconn.createStatement();
	 		int n = stmt.executeUpdate(sql);
	 		if(n>0) {
	 			System.out.println("가입성공");
	 			response.sendRedirect("joinRes.jsp");
	 		}else {
	 			System.out.println("가입 실패");
	 			response.sendRedirect("join.html");
	 		}
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
