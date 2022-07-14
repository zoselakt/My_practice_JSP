package com.test.ex.frontCon;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.ex.cmd.BCommand;
import com.test.ex.cmd.BDelcommand;
import com.test.ex.cmd.BListCommand;
import com.test.ex.cmd.BModifyCommand;
import com.test.ex.cmd.BReplyCommand;
import com.test.ex.cmd.BReplyViewCommand;
import com.test.ex.cmd.BViewCommand;
import com.test.ex.cmd.BWriteCommand;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request,response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		
		request.setCharacterEncoding("UTF-8");
		BCommand command = null;
		
		String viewPage = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String cmd = uri.substring(conPath.length());
		
		if(cmd.equals("/write_view.do")){
			viewPage = "write_form.jsp";
		}else if(cmd.equals("/write.do")){
			command = new BWriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}else if(cmd.equals("/list.do")){
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		}else if(cmd.equals("/view.do")){
			command = new BViewCommand();
			command.execute(request, response);
			viewPage = "view.jsp";
		}else if(cmd.equals("/modify.do")){
			command = new BModifyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}else if(cmd.equals("/delete.do")){
			command = new BDelcommand();
			command.execute(request, response);
			viewPage = "list.do";
		}else if(cmd.equals("/replyView.do")){
			command = new BReplyViewCommand();
			command.execute(request, response);
			viewPage = "reply_form.jsp";
		}else if(cmd.equals("/reply.do")){
			command = new BReplyCommand();
			command.execute(request,response);
			viewPage ="list.do";
		}
		
		RequestDispatcher dispat = request.getRequestDispatcher(viewPage);
		dispat.forward(request, response);
	}
}
