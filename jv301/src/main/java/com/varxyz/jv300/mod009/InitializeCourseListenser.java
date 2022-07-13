package com.varxyz.jv300.mod009;

import java.io.*;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitializeCourseListenser implements ServletContextListener {

	@Override
    public void contextInitialized(ServletContextEvent event) {
		System.out.println("contextInitalized() method called");
		
		ServletContext context = event.getServletContext();
		InputStream is = null;
		BufferedReader reader = null;
		List<String[]> contentList = new ArrayList<>();
		try {
			is = context.getResourceAsStream("/WEB-INF/classes/course_contents.txt");
			reader = new BufferedReader(new InputStreamReader(is)); //decoration 패턴
			String record = null;
			//한번에 모든 글자를 담을수는 있지만 \t(탭)을 기준으로 나누어 받겠다
			while((record = reader.readLine()) != null) {
				String[] fields = record.split("\t");
				contentList.add(fields);
			}
			context.setAttribute("contentList", contentList);
			context.log("The course contensts has been loaded");
		}catch(Exception e) {
			e.printStackTrace();
		}
    }

	@Override
    public void contextDestroyed(ServletContextEvent event)  { 
		System.out.println("contextDestroy() method called");
    }
	private String escapeHtml(String line) {
		if(line.length() == 0) {
			return line;
		}
		return line.replace("<", "&lt;").replace(">", "&gt;");
	}
}