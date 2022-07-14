package jv300.mod001;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jv300.mod001.dao.MemberDao;
import jv300.mod001.vo.MemberVo;

@WebServlet("/mod001/join.do")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	
	public void init(ServletConfig config) throws ServletException {
		userService = new UserService(new MemberDao());
		
	}
	protected void doget(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doget");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		
		request.setCharacterEncoding("UTF-8");
		
		// 1. 폼 파라메터 열기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String ssn = request.getParameter("ssn");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
		
		// 2. 유효성 검증 및 변환
		List<String> errorMsgs = new ArrayList<>();
		if(id == null || id.length() == 0) {
			errorMsgs.add("id는 필수입력 정보입니다.");
		}
		if (password == null || password.length() == 0) {
			errorMsgs.add("비밀번호는 필수입력 정보입니다.");
		}
		
		RequestDispatcher dispatcher = null;
		if(errorMsgs.size() > 0) {
			request.setAttribute("errorMsgs", errorMsgs);
			dispatcher = request.getRequestDispatcher("/error/error.jsp");
			dispatcher.forward(request, response);	// 해당페이지로 보낸다.
			return;
		}
		
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setSsn(ssn);
		vo.setEmail1(email1);
		vo.setEmail2(email2);
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);
		
		userService.addUser(vo);
		request.setAttribute("vo", vo);
		
		dispatcher = request.getRequestDispatcher("/mod001/mypage.jsp");
//		dispatcher = request.getRequestDispatcher("/success/success.jsp");
		dispatcher.forward(request, response);
	}
}