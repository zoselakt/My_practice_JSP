package com.hds.app.mybatis.comfig;

import java.io.IOException;
import java.io.Reader;

import javax.management.RuntimeErrorException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConfig {
	private static SqlSessionFactory sqlsession_f;
	
	static {
		try {
			String resouce = "./com/hds/app/mybatis/config/config.xml";
			Reader reader = Resources.getResourceAsReader(resouce);
			sqlsession_f = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("초기화 문제 발생, MybatisConfig.java");
		}
	}

	public static SqlSessionFactory getSqlsession_f() {
		return sqlsession_f;
	}
	
	
}
