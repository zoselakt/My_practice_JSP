package board.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.controller.*;
import model.Action;
import model.ActionForward;

public class BoardUpdateFormAction implements Action{
	@Override
	public ActionForward execute (HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		
		String pageNum = request.getParameter("page");
		String num = request.getParameter("num");
		int boardNum = Integer.parseInt(num);
		
		BoardDao dao = BoardDao.getInstance();
		BoardVo vo = dao.getDetail(boardNum);
		
		request.setAttribute("vo", vo);
		request.setAttribute("pageNum", pageNum);
		
		forward.setRedirect(false);
		forward.setNextPath("BoardUpdateForm.bo");
		
		return forward;
	}
}
