package board.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.controller.BoardDao;
import board.controller.BoardVo;
import model.Action;
import model.ActionForward;

public class BoardReplyAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		
		BoardDao dao = BoardDao.getInstance();
		BoardVo vo = new BoardVo();
		
		String pageNum = request.getParameter("page");
		
		int num = Integer.parseInt(request.getParameter("board_num"));
		String id = request.getParameter("board_id");
		String subject = request.getParameter("board_subject");
		String content = request.getParameter("board_content");
		int ref = Integer.parseInt(request.getParameter("board_re_ref"));
		
		vo.setBoard_num(dao.getSeq());
		vo.setBoard_id(id);
		vo.setBoard_subject(subject);
		vo.setBoard_content(content);
		vo.setBoard_re_ref(ref);
		vo.setBoard_parent(num);
		
		boolean result = dao.boardInsert(vo);
		
		if(result) {
			forward.setRedirect(false);
			forward.setNextPath("BoardListAction.bo?page= "+pageNum);
		}
		return forward;
	}
}
