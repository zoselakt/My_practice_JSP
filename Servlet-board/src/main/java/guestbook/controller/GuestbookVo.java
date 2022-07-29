package guestbook.controller;

import java.sql.Date;

public class GuestbookVo {
	private int guestbook_no;
	private String guestbook_id;
	private String guestbook_password;
	private String guestbook_content;
	private int guestbook_group;
	private int guestbook_parent;
	private Date guestbook_date;
	private int guestbook_level;
	
	public GuestbookVo () {}
	
	public int getGuestbook_no() {
		return guestbook_no;
	}
	public void setGuestbook_no(int guestbook_no) {
		this.guestbook_no = guestbook_no;
	}
	public String getGuestbook_id() {
		return guestbook_id;
	}
	public void setGuestbook_id(String guestbook_id) {
		this.guestbook_id = guestbook_id;
	}
	public String getGuestbook_password() {
		return guestbook_password;
	}
	public void setGuestbook_password(String guestbook_password) {
		this.guestbook_password = guestbook_password;
	}
	public String getGuestbook_content() {
		return guestbook_content;
	}
	public void setGuestbook_content(String guestbook_content) {
		this.guestbook_content = guestbook_content;
	}
	public int getGuestbook_group() {
		return guestbook_group;
	}
	public void setGuestbook_group(int guestbook_group) {
		this.guestbook_group = guestbook_group;
	}
	public int getGuestbook_parent() {
		return guestbook_parent;
	}
	public void setGuestbook_parent(int guestbook_parent) {
		this.guestbook_parent = guestbook_parent;
	}
	public Date getGuestbook_date() {
		return guestbook_date;
	}
	public void setGuestbook_date(Date guestbook_date) {
		this.guestbook_date = guestbook_date;
	}
	public int getGuestbook_level() {
		return guestbook_level;
	}

	public void setGuestbook_level(int guestbook_level) {
		this.guestbook_level = guestbook_level;
	}
}
