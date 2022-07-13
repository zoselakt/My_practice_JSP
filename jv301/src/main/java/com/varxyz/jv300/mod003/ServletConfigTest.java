package com.varxyz.jv300.mod003;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTest extends HttpServlet{
	private static final String DEFAULT_SEASONS = "Spring, Summer, Fall, Winter";
	private String[] seasons;
//	
//	@Override
//	public void init(ServletConfig config) throws ServletException{
//		//web.xml에있는 param-name의 값을 읽어들인다. (현재클래스의 배열아님 주의!@!!)
//		String season_list = config.getInitParameter("season-list"); //부모에서 받아온 메서드! / ~~.getInitParameter 이면 ~~부모객체에 있는 ~~메소드!
//		
//		// 만일 아무것도 없다면 현재클래스에서 받아온다.
//		if(season_list == null) {
//			season_list = DEFAULT_SEASONS;
//		}
//		seasons = season_list.split(", ");
//	}
//	
	@Override
	public void init() throws ServletException{
		String season_list = getInitParameter("season-list"); //부모에서 받아온 메서드! / ~~.getInitParameter 이면 ~~부모객체에 있는 ~~메소드!
		if(season_list == null) {
			season_list = DEFAULT_SEASONS;
		}
		seasons = season_list.split(", ");
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h2 style='text-align: center;'>Servlet Config Test</h2>");
		out.print("<hr>");
		out.print("<ul>");
		for(String season : seasons) {
			out.println("<li>"+season+"</li>");
		}
		out.print("</ul>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
}
