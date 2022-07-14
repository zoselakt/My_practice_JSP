package jv300.mod001;


import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitializeDataSource implements ServletContextListener {
	private static final String JDBC_FILE_PATH = "/WEB-INF/classes/jdbc.properties";
	
	@Override
    public void contextInitialized(ServletContextEvent event)  { 
    	ServletContext context = event.getServletContext();
    	InputStream is = null;
    	try {
    		is = context.getResourceAsStream(JDBC_FILE_PATH);
    		Properties prop = new Properties();
    		prop.load(is);
    		
    		String jdbcDriver = prop.getProperty("jdbc.driver");
    		String jdbcUrl = prop.getProperty("jdbc.url");
    		String userName = prop.getProperty("jdbc.userName");
    		String password = prop.getProperty("jdbc.password");
    		
    		DataSource dataSource = new DataSource(jdbcDriver, jdbcUrl, userName, password);
    		
    		NamingService namingService = NamingService.getInstance();
    		namingService.setAttribute("dataSource", dataSource);
    		
    		System.out.println("Datasource has been initialized...");
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
	
    public void contextDestroyed(ServletContextEvent event)  { 
    	System.out.println("contextDestroyed...");
    }
}