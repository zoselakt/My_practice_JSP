package member.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/MemberList")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = MemberServiceImpl.getInstance();
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = req.getParameter("keyword");
		req.setAttribute("members", memberService.list(keyword));
		req.getRequestDispatcher("/WEB-INF/lib/jsp/member/list.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
