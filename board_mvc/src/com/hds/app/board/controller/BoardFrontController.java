package com.hds.app.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hds.app.action.ActionForward;

public class BoardFrontController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String requestURI = req.getRequestURI();
		 String contextPath = req.getContextPath();
		 String command = requestURI.substring(contextPath.length());
		 ActionForward forward = null;
		 if(command.equals("/board/BoardListOk.bo")) {
			 try {
				forward = new BoardListOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }else if(command.equals("/board/BoardWrite.bo")) {
			 forward = new ActionForward();
			 forward.setRedirect(false);
			 forward.setPath("/app/board/boardWrite.jsp");
		 }else if(command.equals("/board/BoardWriteOk.bo")) {
			 try {
				forward = new BoardWriteOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }else if(command.equals("/board/BoardViewOk.bo")) {
			 try {
				forward = new BoardViewOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }else if(command.equals("/board/FileDownloadOk.bo")) {
			 try {
				forward = new FileDownloadOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }else if(command.equals("/board/BoardDeleteOk.bo")) {
			 try {
				forward = new BoardDeleteOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }else if(command.equals("/board/BoardModify.bo")) {
			 try {
				forward = new BoardModify().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }else if(command.equals("/board/BoardModifyOk.bo")) {
			 try {
				forward = new BoardModifyOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		 //**********************댓글**********************
		 else if(command.equals("/board/BoardReplyListOk.bo")) {
			 try {
				forward = new BoardReplyListOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }else if(command.equals("/board/BoardReplyWriteOk.bo")) {
			 try {
				forward = new BoardReplyWriteOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }else if(command.equals("/board/BoardReplyModifyOk.bo")) {
			 try {
				forward = new BoardReplyModifyOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }else if(command.equals("/board/BoardReplyDeleteOk.bo")) {
			 try {
				forward = new BoardReplyDeleteOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
