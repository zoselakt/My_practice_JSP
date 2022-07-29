package comment.model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.Controller.CommentDao;
import comment.Controller.CommentVo;
import model.Action;
import model.ActionForward;

public class CommentWriteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = new ActionForward();
		
		CommentDao dao = CommentDao.getInstance();
		CommentVo vo = new CommentVo();
		
		int comment_board = Integer.parseInt(request.getParameter("comment_board"));
		String comment_id = request.getParameter("comment_id");
		String comment_content = request.getParameter("comment_content");
		
		vo.setComment_num(dao.getSeq());
		vo.setComment_board(comment_board);
		vo.setComment_id(comment_id);
		vo.setComment_content(comment_content);
		
		boolean result = dao.insertComment(vo);
		
		if(result) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("1");
			out.close();
		}
		return null;
	}
}