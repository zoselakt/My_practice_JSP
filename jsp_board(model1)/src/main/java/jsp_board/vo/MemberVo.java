package jsp_board.vo;

public class MemberVo {
	private int num;
	private String memberid;
	private String password;
	private String name;
	private String phone;
	private String addr;
	private String addr2;
	private String gender;
	
	public MemberVo() {}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "MemberVo [num=" + num + ", memberid=" + memberid + ", password=" + password + ", name=" + name
				+ ", phone=" + phone + ", addr=" + addr + ", addr2=" + addr2 + ", gender=" + gender + "]";
	}

	public MemberVo(int num, String memberid, String password, String name, String phone, String addr, String addr2,
			String gender) {
		super();
		this.num = num;
		this.memberid = memberid;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.addr = addr;
		this.addr2 = addr2;
		this.gender = gender;
	}
}