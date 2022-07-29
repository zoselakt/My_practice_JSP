package comment.model;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;
import model.ActionForward;

public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Action> commendMap;
       
	public void init(ServletConfig config) throws ServletException {
		loadProperties("/properties/CommentCommand");
	}
	
	private void loadProperties(String filePath) {
		commendMap = new HashMap<String, Action>();
		ResourceBundle rb = ResourceBundle.getBundle(filePath);
		Enumeration<String> actionEnum = rb.getKeys();
		
		while(actionEnum.hasMoreElements()) {
			String command = actionEnum.nextElement();
			String clasName = rb.getString(command);
			try {
				Class actionClass = Class.forName(clasName);
				Action actionInstance = (Action) actionClass.newInstance();
				commendMap.put(command, actionInstance);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		String requestURI = request.getRequestURI();
		int cmdIdx = requestURI.lastIndexOf("/") + 1;
		String command = requestURI.substring(cmdIdx);
		
		ActionForward forward = null;
		Action action = null;
		try {
			action = commendMap.get(command);
			if(action == null) {
				System.out.println(command + "는 잘못된 명령어입니다.");
			}
			forward = action.execute(request, response);
			if(forward != null) {
				if(forward.isRedirect()) {
					response.sendRedirect(forward.getNextPath());
				}else {
					RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getNextPath());
					dispatcher.forward(request, response);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
