package com.varxyz.jv300.mod004;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * 
 * @author Administrator
 * 
//@fileSizeThreshold	fileUpload 시에 메모리에 저장되는 임시 파일 크기를 정의
[자료형 : int]
//@location	파일 업로드 시에 임시 저장 디렉터리를 지정한다.
[자료형 : String]
//@maxFileSize	업로드할 파일의 치대 크기를 지정한다.
[자료형 : long]
//@maxRequestSize	request 시에 최대 크기를 지정한다.
[자료형 : long]

 */

@WebServlet("/mod004/file_upload.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 2,	//2MB 정도의 크기
		maxFileSize = 1024 * 1024 * 10,			//10MB
		maxRequestSize = 1024 * 1024 * 50		//50MB 
		)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "C:/temp";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File saveDir = new File(SAVE_DIR);
		
		if(!saveDir.exists()) {
			saveDir.mkdir();
		}
		for(Part part : request.getParts()) {
			part.write(saveDir.getPath() + File.separator + extractFileName(part));
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h3>Upload has been done successfully.</h3>");
		out.print("<body><html>");
		out.close();
		
//		Enumeration<String> en = request.getHeaderNames();
//		while(en.hasMoreElements()) {
//			String header = en.nextElement();
//			System.out.println(header + "=" +request.getHeader(header));
//		}
	}
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-Disposition");
		for(String s : contentDisp.split(";")) {
			if(s.contains(File.separator)) {
				return s.substring(s.lastIndexOf(File.separator) + 1).replace("/","");
			}else {
				return s;
			}
		}
		return "";
	}
}