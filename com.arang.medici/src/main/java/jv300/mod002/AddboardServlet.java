package jv300.mod002;

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
import jv300.mod002.dao.BoardDao;
import jv300.mod002.vo.BoardVo;

@WebServlet("/mod002/regist.do")
public class AddboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardDao boardDao;
	
	public void init(ServletConfig config) throws ServletException {
		boardDao = new BoardDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 1. 폼 파라메터 열기
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String contents = request.getParameter("contents");
		
		
		// 2. 유효성 검증 및 변환
		List<String> errorMsgs = new ArrayList<>();
		if(title == null || title.length() == 0) {
			errorMsgs.add("제목은 필수입력 정보입니다.");
		}
		if (writer == null || writer.length() == 0) {
			errorMsgs.add("작성자는 필수입력 정보입니다.");
		}
		
		RequestDispatcher dispatcher = null;
		if(errorMsgs.size() > 0) {
			request.setAttribute("errorMsgs", errorMsgs);
			dispatcher = request.getRequestDispatcher("/error/error.jsp");
			dispatcher.forward(request, response);	// 해당페이지로 보낸다.
			return;
		}
		
		BoardVo vo = new BoardVo();
		BoardDao Dao = new BoardDao();
		
		vo.setTitle("title");
		vo.setWriter("writer");
		vo.setContents("contents");
		
		Dao.insert(vo);
		request.setAttribute("vo", vo);
		
		dispatcher = request.getRequestDispatcher("/success/success.jsp");
		dispatcher.forward(request, response);
	}
}