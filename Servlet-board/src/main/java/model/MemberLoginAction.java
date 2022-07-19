package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.MemberDao;
import controller.MemberVo;

public class MemberLoginAction implements Action {
	@Override
	public ActionForward execute (HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		ActionForward forward = new ActionForward();
		MemberDao dao = MemberDao.getInstance();
		MemberVo vo = new MemberVo();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		int check = dao.loginCheck(id, password);
		
		if(check == 0 ) {
			request.setAttribute("fail", "0");
			forward.setRedirect(false);
			forward.setNextPath("LoginForm.do");
			System.out.println(vo);
		}else if(check == -1){
			request.setAttribute("fail", "-1");
			forward.setRedirect(false);
			forward.setNextPath("LoginForm.do");
		}else {
			request.setAttribute("sessionID", id);
			forward.setRedirect(true);
			forward.setNextPath("MainForm.do");
		}
		return forward;
	}
}
