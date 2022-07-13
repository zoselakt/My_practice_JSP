package com.varxyz.jv300.mod010;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Administrator
 *
 */
public class NamingService {
	private static NamingService obj = new NamingService();
	private Map<String, Object> nameValuePairs;
	
	private NamingService() {
		nameValuePairs = new HashMap<String, Object>();
	}
	public static NamingService getInstance() {
		return obj;
	}
	public void setAttribute(String name, Object obj) throws IllegalAccessException {
		if(!nameValuePairs.containsKey(name)) {
			nameValuePairs.put(name, obj);
		}else {
			throw new IllegalAccessException("This name, "+name+", is already in use");
		}
	}
	public Object getAttribute(String name) {
		return nameValuePairs.get(name);
	}
	public void removeAttribute(String name) {
		nameValuePairs.remove(name);
	}
}
