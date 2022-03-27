package vo;
/*
NUM NUMBER PRIMARY KEY,
ID VARCHAR2(1000)
NAME VARCHAR2(1000),
PASSWORD VARCHAR2(1000),
GENDER VARCHAR2(100),
ZIPCODE VARCHAR2(100),
ADDRESS VARCHAR2(1000),
ADDRESS)DETAIL VARCHAR2(1000),
ADRESS_ETC VARCHAR2(1000)
*/

//그리드 모드 :alt + shift + a

public class UserVO {
	int num;
	private String id;
	private String name;
	private String password;
	private String gender;
	private String zipcode;
	private String address;
	private String address_detail;
	private String address_etc;
	
	public UserVO() {;}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}

	public String getAddress_etc() {
		return address_etc;
	}

	public void setAddress_etc(String address_etc) {
		this.address_etc = address_etc;
	}
	
	
}
