package com.test.ex;

public class MemberDTO {
		private String name;
		private String id;
		private String pw;
		private String hp, hp2, hp3;
		private String gender;
		
		public MemberDTO(String name, String id, String pw, String hp, String hp2, String hp3, String gender) {
			this.name = name;
			this.id = id;
			this.pw = pw;
			this.hp = hp;
			this.hp2 = hp2;
			this.hp3 = hp3;
			this.gender = gender;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

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

		public String getHp() {
			return hp;
		}

		public void setHp(String hp) {
			this.hp = hp;
		}

		public String getHp2() {
			return hp2;
		}

		public void setHp2(String hp2) {
			this.hp2 = hp2;
		}

		public String getHp3() {
			return hp3;
		}

		public void setHp3(String hp3) {
			this.hp3 = hp3;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}
		
}
