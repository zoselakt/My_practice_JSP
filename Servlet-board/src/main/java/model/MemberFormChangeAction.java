package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFormChangeAction implements Action{
	private String form = "MainForm.jsp?contentPage=member/";
	private String path;
	
	public void setCommand(String command) {
		int idx = command.indexOf(".");
		path = command.substring(0, idx)+".jsp";
	}
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		if(path.equals("MainForm.jsp")) {
			forward.setNextPath(path);
		}else {
			forward.setNextPath(form + path);
		}
		return forward;
	}
}
