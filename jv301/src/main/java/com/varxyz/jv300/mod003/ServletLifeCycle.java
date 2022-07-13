package com.varxyz.jv300.mod003;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLifeCycle extends HttpServlet{
	@Override
	public void init(ServletConfig config) throws ServletException{
		System.out.println("init() method called.");
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		System.out.println("service() method called");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h2 style='text-align: center;'>Servlet LifeCycle Test</h2>");
		out.print("<hr>");
		out.print("<ul>");
		out.print("<h3 style='text-align: center; font-color: red;'> 서블릿라이프사이클 </h3>");
		out.print("<li> init() 호출 </li>");
		out.print("<li> service(), doGet(), doPost() 호출 </li>");
		out.print("<li> destroy() 호출로 close처리(빠져나온다) </li>");
		out.print("<li> 이후 배울내용 : 선처리, 후처리 어노테이션 </li>");
		out.print("</ul>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy Servlet Called...");
	}
}
