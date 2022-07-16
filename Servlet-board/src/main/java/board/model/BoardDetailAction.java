package board.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.controller.BoardDao;
import board.controller.BoardVo;
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
		
		request.setAttribute("vo", vo);
		request.setAttribute("pageNum", pageNum);
		
		if(result) {
			forward.setRedirect(false);
			forward.setNextPath("BoardDetailForm.do");
		}
		return forward;
	}
}
