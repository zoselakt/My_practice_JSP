package com.varxyz.jv300.mod002;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * 
 * @author Administrator
 * HelloServlet - HttpServlet - GenericServlet - Servlet (인터페이스)
 * server + let
 * GenericServlet(부모인터페이스의 모든 기능을 작성했으나 추상클래스이다. / 상속받아 사용하게끔 처리)
 * HttpServlet내부에 doget,dopost등 모든 메서드가 있기때문에 오버라이딩하여 사용
 * 
 */

public class HelloServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String pageTitle = "Hello world";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>" + pageTitle + "</title></head>");
		out.print("<body>");
		out.print("<h3> Welcome to Servlet Programming</h3>");
		out.print("</body>");
		out.print("<html>");
	}
}
