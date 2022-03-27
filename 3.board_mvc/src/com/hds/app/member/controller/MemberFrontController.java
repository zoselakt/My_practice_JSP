package com.hds.app.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hds.app.action.ActionForward;

public class MemberFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		ActionForward forward = null;
		
		if(command.equals("/member/MemberCheckIdOk.me")) {
			try {
				forward = new MemberCheckIdOk().execute(req, resp);
			} catch (Exception e) {
				System.out.println("아이디 중복검사 오류"+e);
			}
		}else if(command.equals("/member/MemberJoinOk.me")) {
			try {
				forward = new MemberJoinOk().execute(req, resp);
			} catch (Exception e) {
				System.out.println("회원가입오류"+ e);
			}
		}else if(command.equals("/member/MemberLoginOk.me")) {
			try {
				forward = new MemberLoginOk().execute(req, resp);
			} catch (Exception e) {
				System.out.println("회원가입오류"+ e);
			}
		}else if(command.equals("/member/MemberLogin.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/member/login.jsp");
		}else if (command.equals("/member/MemberJoin.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/member/join.jsp");
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
		}
	}
}
