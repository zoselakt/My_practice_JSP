package com.hds.app.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hds.app.action.Action;
import com.hds.app.action.ActionForward;
import com.hds.app.member.dao.MemberDAO;

public class MemberLoginOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		MemberDAO dao = new MemberDAO();
		HttpSession session = req.getSession();
		
		String memberId = req.getParameter("memberId");
		String memberPw = req.getParameter("memberPw");
		
		forward.setRedirect(true);
		
		if(dao.login(memberId, memberPw)) {
			session.setAttribute("sessionId", memberId);
			forward.setPath(req.getContextPath() + "/board/BoardListOk.bo");
		}else {
			forward.setPath(req.getContextPath() + "/member/MemberLogin.me?code=false");
		}
		
		return forward;
	}
}
