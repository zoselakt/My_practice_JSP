package com.test.ex;

import java.sql.*;
import java.util.*;

public class StudentDAO {
	Connection dbconn;
	PreparedStatement ps;
	ResultSet rs;
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "hr", pwd="hr";
	
	public StudentDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			dbconn = DriverManager.getConnection(url, uid, pwd);
			System.out.println("데이터베이스 연결");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int insertStudent(StudentDTO sdto) throws SQLException{
		String hakbun = sdto.getHakbun();
		String pw = sdto.getPw();
		String name = sdto.getName();
		String hp = sdto.getHp();
		int n = this.insertStudent(hakbun, pw, name, hp);
		return n;
	}
	public int insertStudent(String hakbun, String pw, String name, String hp)throws SQLException{
		try {
		String sql = "insert into student values(?,?,?,?)";
		ps = dbconn.prepareStatement(sql);
		ps.setString(1, hakbun);
		ps.setString(2, pw);
		ps.setString(3, name);
		ps.setString(4, hp);
		int n = ps.executeUpdate();
		return n;
	}finally {
		if(ps!=null)ps.close();
		if(dbconn!=null)dbconn.close();
		}
	}
	// 정보(list)를 가져오는 메소드
	public StudentDTO[] select() throws SQLException{
		try {
			String sql = "select * from where student";
			ps = dbconn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			StudentDTO arr[] = createArray(rs);
			return arr;
		}finally {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(dbconn != null) dbconn.close();
		}
	}
	
	// db연동 및 jsp재정의를 위한 DTO객체
	public StudentDTO[] findSt(String name) throws SQLException{
		try {
			String sql = "select * from student where name=?"; //db연동을 위한 sql문
			ps = dbconn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			StudentDTO stArray[] = createArray(rs); 
			return stArray; //StudentDTO객체를 받아온다.
		}finally { //마지막 닫아주는 작업
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(dbconn != null) dbconn.close();
		}
	}
	//생성(find)을 위한 DTO객체
	public StudentDTO[] createArray(ResultSet rs) throws SQLException{ //배열을 사용하여 각 객체의 값을 얻는다.
		Vector<StudentDTO> v = new Vector<StudentDTO>();
		while(rs.next()) {
			String hakbun = rs.getNString(1);
			String pw = rs.getNString(2);
			String name = rs.getNString(3);
			String hp = rs.getNString(4);
			
			StudentDTO rowSt = new StudentDTO(hakbun, pw, name, hp);
			v.add(rowSt);
		}
		int vSize = v.size();
		StudentDTO stArray[] = new StudentDTO[vSize];
		v.copyInto(stArray); // 벡터사이즈크기만큼 객체를 만들고, 백터에 저장된 값을 stArray객체에 복사
		return stArray;
	}
	//삭제(delete)를 위한 객체
	public int delStudent(String name) throws SQLException{
		try {
			String sql = "delete from student where name=?"; //?: prepareStatement쓰기위함
			ps = dbconn.prepareStatement(sql);
			ps.setString(1, name);
			int n = ps.executeUpdate();
			return n;
		}finally {
			if(ps != null) ps.close();
			if(dbconn != null) dbconn.close();
		}
	}
}