package jv300.mod001.vo;

public class MemberVo {
	private long num;
	private String id;
	private String password;
	private String name;
	private String ssn;
	private String email1;
	private String email2;
	private String addr1;
	private String addr2;
	private double regdata;
	
	public MemberVo() {}

	public MemberVo(long num, String id, String password, String name, String ssn, String email1, String email2,
			String addr1, String addr2, double regdata) {
		super();
		this.num = num;
		this.id = id;
		this.password = password;
		this.name = name;
		this.ssn = ssn;
		this.email1 = email1;
		this.email2 = email2;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.regdata = regdata;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
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

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public double getRegdata() {
		return regdata;
	}

	public void setRegdata(double regdata) {
		this.regdata = regdata;
	}

	@Override
	public String toString() {
		return "MemberVo [num=" + num + ", id=" + id + ", password=" + password + ", name=" + name + ", ssn=" + ssn
				+ ", email1=" + email1 + ", email2=" + email2 + ", addr1=" + addr1 + ", addr2=" + addr2 + ", regdata="
				+ regdata + "]";
	}
	
	
}
