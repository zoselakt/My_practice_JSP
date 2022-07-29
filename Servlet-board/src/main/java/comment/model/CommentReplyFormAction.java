package comment.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.Controller.CommentDao;
import comment.Controller.CommentVo;
import model.Action;
import model.ActionForward;

public class CommentReplyFormAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = new ActionForward();
		
		int comment_num = Integer.parseInt(request.getParameter("num"));
		
		CommentDao dao = CommentDao.getInstance();
		CommentVo vo = dao.getComment(comment_num);
		
		request.setAttribute("vo", vo);
		
		forward.setRedirect(false);
		forward.setNextPath("board/CommentReplyForm.jsp");
		
		return forward;
	}
}