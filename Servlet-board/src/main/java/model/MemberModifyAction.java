package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.MemberDao;
import controller.MemberVo;

public class MemberModifyAction implements Action{
	@Override
	public ActionForward execute (HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		ActionForward forward = new ActionForward();
		MemberDao dao = MemberDao.getInstance();
		
		String id = session.getAttribute("sessionID").toString();
		
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPassword(request.getParameter("password"));
		vo.setEmail1(request.getParameter("email1"));
		vo.setEmail1(request.getParameterValues("email2")[0]);
		vo.setPhone(request.getParameter("phone"));
		vo.setAddress(request.getParameter("address"));
		
		dao.updateMember(vo);
		
		forward.setRedirect(true);
		forward.setNextPath("ResultForm.do");
		session.setAttribute("msg", "0");
		return forward;
	}
}
