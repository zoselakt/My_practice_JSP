package comment.model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.Controller.CommentDao;
import comment.Controller.CommentVo;
import model.Action;
import model.ActionForward;

public class CommentReplyAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		int comment_num = Integer.parseInt(request.getParameter("comment_num"));
		int comment_board = Integer.parseInt(request.getParameter("comment_board"));
		String comment_id = request.getParameter("comment_id");
		String comment_content = request.getParameter("comment_content");
		
		CommentDao dao = CommentDao.getInstance();
		
		CommentVo vo = new CommentVo();
		vo.setComment_num(dao.getSeq());
		vo.setComment_board(comment_board);
		vo.setComment_id(comment_id);
		vo.setComment_content(comment_content);
		vo.setComment_parent(comment_num);
		
		boolean result = dao.insertComment(vo);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(result) {
			out.println("1");
		}else {
			out.println("0");
		}
		out.close();
		return null;
	}
}
