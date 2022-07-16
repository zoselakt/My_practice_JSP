package model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.MemberDao;
import controller.MemberVo;

public class MemberListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = new ActionForward();
		MemberDao dao = MemberDao.getInstance();
		ArrayList<MemberVo> memberList = dao.getMemberList();
		
		request.setAttribute("memberList", memberList);
		forward.setRedirect(false);
		forward.setNextPath("MemberListForm.do");
		
		return forward;
	}
}
