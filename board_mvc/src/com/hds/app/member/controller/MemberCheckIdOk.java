package com.hds.app.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hds.app.action.Action;
import com.hds.app.action.ActionForward;

public class MemberCheckIdOk implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String memberId = req.getParameter("memberId");
		return null;
	}

}
