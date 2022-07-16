package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.MemberDao;
import controller.MemberVo;

public class MemberDeleteAction implements Action {
	@Override
	public ActionForward execute (HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		MemberDao dao = MemberDao.getInstance();
		MemberVo vo = new MemberVo();
		
		ActionForward forward = new ActionForward();
		
		HttpSession session = request.getSession();
		String id = session.getAttribute("sessionID").toString();
		String password = request.getParameter("password");
		
		int check = dao.deleteMember(id, password);
		
		if(check == 1 ) {
			session.removeAttribute("sessionID");
			forward.setRedirect(true);
			forward.setNextPath("Result.do");
		}else {
			System.out.println("회원삭제실패");
			return null;
		}
		return forward;
	}
}
