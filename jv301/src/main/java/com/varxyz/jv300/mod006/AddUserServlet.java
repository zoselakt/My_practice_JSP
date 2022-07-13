package com.varxyz.jv300.mod006;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod006/add_user.do")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
       
	@Override
	public void init(ServletConfig config) throws ServletException {
//		getInitParameter("userId");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		1. 폼 파라미터 얻기
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		String userName = request.getParameter("userName");
		String Email1 = request.getParameter("Email1");
		String Email2 = request.getParameter("Email2");
		String ssn = request.getParameter("ssn");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
//		2. 유효성 검증 및 변환
		List<String> errorMsgs = new ArrayList<>();
		if(userId == null || userId.length() == 0) {
			errorMsgs.add("id는 필수 입력정보입니다.");
		}else if(passwd == null || passwd.length() == 0) {
			errorMsgs.add("pw는 필수 입력정보입니다.");
		}
		
		RequestDispatcher dispatcher = null;
		if(errorMsgs.size() > 0) {
			return;
		}
		
		User user = new User();
		user.setUserId(userId);
		user.setPasswd(passwd);
		user.setUserName(userName);
		user.setEmail1(Email1 + "@" + Email2);
		user.setSsn(ssn);
		user.setAddr1(addr1 + " " + addr2);
		
//		3. 비즈니스 서비스 호출
//		userService.addUser(user);
		
//		4. next Page
		request.setAttribute("userName", userName);
		dispatcher = request.getRequestDispatcher("/success/success.jsp");
		dispatcher.forward(request, response);
	}
}