package board.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.controller.BoardDao;
import board.controller.BoardVo;
import comment.Controller.CommentDao;
import comment.Controller.CommentVo;
import model.Action;
import model.ActionForward;

public class BoardDetailAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = new ActionForward();
		
		String num = request.getParameter("num");
		int boardNum = Integer.parseInt(num);
		String pageNum = request.getParameter("pageNum");
		
		BoardDao dao = BoardDao.getInstance();
		BoardVo vo = dao.getDetail(boardNum);
		boolean result = dao.updateCount(boardNum);
		
		CommentDao commentDao = CommentDao.getInstance();
		ArrayList<CommentVo> commentList = commentDao.getCommentList(boardNum);
		
		if(commentList.size() > 0) {
			request.setAttribute("commentList", commentList);
		}
		request.setAttribute("vo", vo);
		request.setAttribute("pageNum", pageNum);
		
		if(result) {
			forward.setRedirect(false);
			forward.setNextPath("BoardDetailForm.bo");
		}
		return forward;
	}
}
