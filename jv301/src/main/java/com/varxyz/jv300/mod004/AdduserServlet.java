package com.varxyz.jv300.mod004;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod004/AdduserServlet")
public class AdduserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_NAME = "kim";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		String userName = request.getParameter("userName");
		String ssn = request.getParameter("ssn");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
//		String concerns = request.getParameter("concerns");
		String[] concerns = request.getParameterValues("concerns");
		String location = request.getParameter("location");
		
		String innertitle = "서블릿을 이용한 회원가입 폼";
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print("<h2 style='text-align: center;'>"+innertitle+"</h2>");
		out.print("<hr>");
		out.print("<ul style='margin-left: 50px;'>");
		out.print("<li> 유저아이디: "+userId+"</li>");
		out.print("<li> 패스워드: "+passwd+"</li>");
		out.print("<li> 이름: "+userName+"</li>");
		out.print("<li> 주민번호: "+ssn+"</li>");
		out.print("<li> 이메일: "+email1+"</li>");
		out.print("<li> 이메일: "+email2+"</li>");
		out.print("<li> 관심분야 </li>");
		for(String concern : concerns) {
			out.print("<li style='text-decoration: none;'>"+concern.toString()+"</li>");			
		}
		out.print("<li> 지역: "+location+"</li>");
		out.print("</ul>");
		out.print("</body>");
		out.print("</html>");
		out.close();
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
