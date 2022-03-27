package com.hds.app.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hds.app.action.Action;
import com.hds.app.action.ActionForward;
import com.hds.app.member.dao.MemberDAO;
import com.hds.app.member.vo.MemberVO;

public class MemberJoinOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		ActionForward forward = new ActionForward();
		
		vo.setMemberId (req.getParameter("memberId"));
		vo.setMemberPw (req.getParameter("memberPw"));
		vo.setMemberAge (Integer.parseInt(req.getParameter("memberAge")));
		vo.setMemberGender (req.getParameter("memberGender"));
		vo.setMemberEmail (req.getParameter("memberEmail"));
		vo.setMemberZipcode (req.getParameter("memberZipcode"));
		vo.setMemberAddress (req.getParameter("memberAddress"));
		vo.setMemberAddressDetail (req.getParameter("memberAddressDetail"));
		vo.setMemberAddressEtc (req.getParameter("memberAddressEtc"));
		
		dao.join(vo);

		//어떻게 보낼것인가.
		forward.setRedirect(true);
		//어디로 보낼것인가.
		forward.setPath(req.getContextPath() + "/member/MemberLogin.me");
		return forward;
	}

}
