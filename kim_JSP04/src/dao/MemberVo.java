package dao;

import java.util.Date;

public class MemberVo {
	private int num;
	private String id;
	private String password;
	private String name;
	private String email;
	private Date joinDate;
	
	public MemberVo () {}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	@Override
	public String toString() {
		return "MemberVo [num=" + num + ", id=" + id + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", joinDate=" + joinDate + "]";
	}
	public MemberVo(int num, String id, String password, String name, String email, Date joinDate) {
		super();
		this.num = num;
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.joinDate = joinDate;
	}
	
	
}
