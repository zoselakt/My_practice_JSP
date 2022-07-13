package com.varxyz.jv300.mod002;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ServletGugudan extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String gugudan = "Gugudan";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>" + gugudan + "</title></head>");
		out.print("<body>");
		
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
//				out.print(i*j + "<p></p>");			
				out.print(i+" * "+j+" = "+i*j+"<br><br>");
			}
			out.print("<hr>");
		}
		
		out.print("</body>");
		out.print("<html>");
	}
}
