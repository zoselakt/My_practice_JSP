package board.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.controller.BoardDao;
import board.controller.BoardVo;
import model.Action;
import model.ActionForward;

public class BoardReplyFormAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		ActionForward forward = new ActionForward();
		BoardDao dao = BoardDao.getInstance();
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("page");
		
		BoardVo vo = dao.getDetail(num);
		request.setAttribute("vo", vo);
		request.setAttribute("page", pageNum);
		
		forward.setRedirect(false);
		forward.setNextPath("BoardReplyForm.do");
		
		return forward;
	}
}
