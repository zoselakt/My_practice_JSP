package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.MemberDao;
import controller.MemberVo;

public class MemberInfoAction implements Action{
	@Override
	public ActionForward execute (HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		ActionForward forward = new ActionForward();
		String id = session.getAttribute("sessionID").toString();
		
		MemberDao dao = MemberDao.getInstance();
		MemberVo vo = dao.getUserInfo(id);
		
		request.setAttribute("memberInfo", vo);
		forward.setRedirect(false);
		forward.setNextPath("UserInfoForm.do");
		return forward;
	}
}
