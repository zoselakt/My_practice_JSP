package com.test.ex;

// DTO (VO: Value Object)
public class StudentDTO {
	private String hakbun;
	private String pw;
	private String name;
	private String hp;
	
	public StudentDTO() {
		System.out.println("Student() 객체 생성");
	}
	
	public StudentDTO(String hakbun, String pw, String name, String hp) { // 매개변수를 달리하는 생성자
		this.hakbun = hakbun;
		this.pw = pw;
		this.name = name;
		this.hp = hp;
	}

	public String getHakbun() {
		return hakbun;
	}

	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}
}


