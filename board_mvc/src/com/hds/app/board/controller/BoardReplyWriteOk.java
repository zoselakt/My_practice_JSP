package com.hds.app.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hds.app.action.Action;
import com.hds.app.action.ActionForward;
import com.hds.app.board.dao.BoardReplyDAO;
import com.hds.app.board.vo.BoardReplyVO;

public class BoardReplyWriteOk implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		BoardReplyDAO dao = new BoardReplyDAO();
		BoardReplyVO vo = new BoardReplyVO();
		
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		String memberId = (String)req.getSession().getAttribute("sessionId");
		String replyContent = req.getParameter("replyContent");
		
		vo.setBoardNum(boardNum);
		vo.setMemberId(memberId);
		vo.setReplyContent(replyContent);
		
		dao.insertReply(vo);
		
		return null;
	}
}
