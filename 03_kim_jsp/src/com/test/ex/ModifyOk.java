package com.test.ex;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class ModifyOk
 */
@WebServlet("/ModifyOk")
public class ModifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Connection dbconn;
	private Statement stmt;
	
	private String name, id, pw, hp, hp2, hp3, gender;
	
	HttpSession httpSession;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modifyDo(request, response);
	}
	private void modifyDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		httpSession = request.getSession();
		// modify.jsp에서 수정내용 가져오기
		name = request.getParameter("name");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		hp = request.getParameter("hp");
		hp2 = request.getParameter("hp2");
		hp3 = request.getParameter("hp3");
		gender = request.getParameter("gender");
		
		if(pwCheck()) {
			System.out.println("수정 ok");
			String sql = "update member set name = '"+name+"', hp='"+hp+"', hp2='"+hp2+"' ,hp3='"+hp3+"', gender='"+gender+"'";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				dbconn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
				stmt = dbconn.createStatement();
				int n = stmt.executeUpdate(sql);
				
				if(n>0) {
					System.out.println("수정되었습니다.");
					httpSession.setAttribute("name", name);
					response.sendRedirect("modifyRes.jsp");
				}else {
					System.out.println("수정실패...");
					response.sendRedirect("modify.jsp");
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				try {
					if(stmt != null) stmt.close();
					if(dbconn != null) dbconn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}else {
			System.out.println("비밀번호가 잘못입력되었습니다.");
			response.sendRedirect("modify.jsp");
		}
	}
	// 수정후에 비밀번호 확인 세션을 이용해서 확인과정을 거친다.
	private boolean pwCheck() {
		boolean bool = false;
		
		String sessionPw = (String)httpSession.getAttribute("pw");
		
		if(sessionPw.equals(pw)) {
			bool = true;
		}else {
			bool = false;
		}
		return bool;
	}
}
