package com.varxyz.jv300.mod006;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.varxyz.jv300.mod010.DataSource;
import com.varxyz.jv300.mod010.dao.MemberDao;
import com.varxyz.jv300.mod010.vo.MemberVo;

@WebServlet("/mod011/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource dataSource;
	
	protected void doget(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		joinMember(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		joinMember(request, response);
	}
	protected void joinMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String ssn = request.getParameter("ssn");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		
		int addMember = dao.addUser(vo);
		if(addMember > 0) {
			response.sendRedirect("login.jsp");
		}else {
			response.sendRedirect("join");
		}
	}
}
