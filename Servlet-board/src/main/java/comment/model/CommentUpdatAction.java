package comment.model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.Controller.CommentDao;
import comment.Controller.CommentVo;
import model.Action;
import model.ActionForward;

public class CommentUpdatAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = new ActionForward();
		
		int comment_num = Integer.parseInt(request.getParameter("comment_num"));
		String comment_content = request.getParameter("comment_content");
		
		CommentDao dao = CommentDao.getInstance();
		CommentVo vo = new CommentVo();
		vo.setComment_num(comment_num);
		vo.setComment_content(comment_content);
		
		boolean result = dao.updateComment(vo);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(result) {
			out.println("1");
		}
		out.close();
		return null;
	}
}
