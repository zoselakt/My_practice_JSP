package jv300.mod002.vo;

import java.util.Date;

public class BoardVo {
	private int num;
	private String title;
	private String writer;
	private String contents;
	private Date regdate;
	private int cnt;
	
	public BoardVo() {}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return "BoardVo [num=" + num + ", title=" + title + ", writer=" + writer + ", contents=" + contents
				+ ", regdate=" + regdate + ", cnt=" + cnt + "]";
	}
	
	public BoardVo(int num, String title, String writer, String contents, Date regdate, int cnt) {
		super();
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.contents = contents;
		this.regdate = regdate;
		this.cnt = cnt;
	}
}