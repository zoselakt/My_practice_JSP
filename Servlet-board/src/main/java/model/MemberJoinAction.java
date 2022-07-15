package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.MemberDao;
import controller.MemberVo;

public class MemberJoinAction implements Action{
	
	@Override
	public ActionForward execute (HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		MemberDao dao = MemberDao.getInstance();
		
		MemberVo vo = new MemberVo();
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setGender(request.getParameter("gender"));
		vo.setBirthyy(request.getParameter("birthyy"));
		vo.setBirthmm(request.getParameterValues("birthmm")[0]);
		vo.setBirthdd(request.getParameter("birthdd"));
		vo.setEmail1(request.getParameter("email1"));
		vo.setEmail2(request.getParameterValues("email2")[0]);
		vo.setPhone(request.getParameter("phone"));
		vo.setAddress(request.getParameter("address"));
		
		dao.insertMember(vo);
		
		//가입성공시
		forward.setRedirect(true);
		forward.setNextPath("Result.do");
		request.getSession().setAttribute("msg", "1");
		
		return forward;
	}
}
