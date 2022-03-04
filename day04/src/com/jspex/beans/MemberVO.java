package com.jspex.beans;

/*
NUM NUMBER PRIMARY KEY,
NAME VARCHAR2(1000),
BIRTHDAY DATE
*/
public class MemberVO {
	private int num;
	private String name;
	private String birthday;
	
	public MemberVO() { //초기값
		this.name = "이름이 없습니다.";
		this.birthday = "생일이 등록되지 않았습니다.";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
}
