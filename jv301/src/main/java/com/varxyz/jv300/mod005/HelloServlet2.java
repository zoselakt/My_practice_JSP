package com.varxyz.jv300.mod005;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * 
 * @author Administrator
 doGet을 다른말로 jspService메소드 라고한다. (라이프사이클)
 모든 메서드가 있기때문에 오버라이딩하여 사용
 * 
 */

@WebServlet(name = "HelloSerblet2", urlPatterns = "/mod005/hello.view" )
public class HelloServlet2 extends HttpServlet{
	private static final String DEFAULT_NAME = "게임";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String pageTitle = "Hello world";
		
		String name = request.getParameter("userName");
		if(name == null || name.length() == 0) {
			name = DEFAULT_NAME;
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>" + pageTitle + "</title></head>");
		out.print("<body>");
		out.print("<h3> Welcome to"+name+"</h3>");
		out.print("</body>");
		out.print("<html>");
	}
}
