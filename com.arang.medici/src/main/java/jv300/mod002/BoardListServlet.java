package jv300.mod002;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jv300.mod002.dao.BoardDao;
import jv300.mod002.vo.BoardVo;

@WebServlet("/mod002/mypage.do")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardDao boardDao;
	
	public void init(ServletConfig config) throws ServletException {
		boardDao = new BoardDao();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String contents = request.getParameter("contents");
		
		List<BoardVo> ls = boardDao.selectAll();
		BoardVo vo = new BoardVo();
		request.setAttribute("ls", ls);
		request.setAttribute("vo", vo);
		
		request.getRequestDispatcher("/mod002/list.jsp").forward(request, response);
		System.out.println("doGet 호출 완료");
		
	}
}