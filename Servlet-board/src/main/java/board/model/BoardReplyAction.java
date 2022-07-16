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
		String id = request.getParameter("vo_id");
		String subject = request.getParameter("vo_subject");
		String content = request.getParameter("vo_content");
		int ref = Integer.parseInt(request.getParameter("board_re_ref"));
		int lev = Integer.parseInt(request.getParameter("board_re_lev"));
		int seq = Integer.parseInt(request.getParameter("board_re_seq"));
		
		vo.setBoard_re_ref(ref);
		vo.setBoard_re_ref(ref);
		dao.updateReSeq(vo);
		
		vo.setBoard_num(dao.getSeq());
		vo.setBoard_id(id);
		vo.setBoard_subject(subject);
		vo.setBoard_content(content);
		vo.setBoard_re_ref(ref);
		vo.setBoard_re_lev(lev+1);
		vo.setBoard_re_seq(seq+1);
		
		boolean result = dao.boardInsert(vo);
		if(result) {
			forward.setRedirect(false);
			forward.setNextPath("BoardListAction.do?page="+pageNum);
		}
		return forward;
	}
}
