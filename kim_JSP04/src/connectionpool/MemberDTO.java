package connectionpool;

import java.sql.Timestamp;

public class MemberDTO {
		private String id;
		private String pw;
		private String name;
		private String email;
		private String address;
		private Timestamp rDate;
		
//		public MemberDTO(String id, String pw, String name, String email, String address, ) {
//		this.name = name;
//		this.id = id;
//		this.pw = pw;
//		this.hp = hp;
//		this.hp2 = hp2;
//		this.hp3 = hp3;
//		this.gender = gender;
//	}

		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Timestamp getrDate() {
			return rDate;
		}
		public void setrDate(Timestamp rDate) {
			this.rDate = rDate;
		}

		
}
