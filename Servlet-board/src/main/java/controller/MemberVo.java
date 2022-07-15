package controller;

import java.sql.Timestamp;

public class MemberVo {
	private String id;
	private String password;
	private String name;
	private String gender;
	private String birthyy;
	private String birthmm;
	private String birthdd;
	private String email1;
	private String email2;
	private String phone;
	private String address;
	private Timestamp reg;
	
	public MemberVo() {}
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthyy() {
		return birthyy;
	}
	public void setBirthyy(String birthyy) {
		this.birthyy = birthyy;
	}
	public String getBirthmm() {
		return birthmm;
	}
	public void setBirthmm(String birthmm) {
		this.birthmm = birthmm;
	}
	public String getBirthdd() {
		return birthdd;
	}
	public void setBirthdd(String birthdd) {
		this.birthdd = birthdd;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getReg() {
		return reg;
	}
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
	
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", password=" + password + ", name=" + name + ", gender=" + gender + ", birthyy="
				+ birthyy + ", birthmm=" + birthmm + ", birthdd=" + birthdd + ", email1=" + email1 + ", email2="
				+ email2 + ", phone=" + phone + ", address=" + address + ", reg=" + reg + "]";
	}
	
	public MemberVo(String id, String password, String name, String gender, String birthyy, String birthmm,
			String birthdd, String email1, String email2, String phone, String address, Timestamp reg) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birthyy = birthyy;
		this.birthmm = birthmm;
		this.birthdd = birthdd;
		this.email1 = email1;
		this.email2 = email2;
		this.phone = phone;
		this.address = address;
		this.reg = reg;
	}
}
