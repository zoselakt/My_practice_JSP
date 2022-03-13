package board;

public class BoardDTO {
	private int num;
	private String writer;
	private String subject;
	private String passwd;
	private String reg_date;
	private int hit;
	private int group_num;
	private int re_order;
	private int re_depth;
	private String contents;
	private String ip;
	private int count_comments;
	private String filename;
	private int filesize;
	private int down;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getGroup_num() {
		return group_num;
	}
	public void setGroup_num(int group_num) {
		this.group_num = group_num;
	}
	public int getRe_order() {
		return re_order;
	}
	public void setRe_order(int re_order) {
		this.re_order = re_order;
	}
	public int getRe_depth() {
		return re_depth;
	}
	public void setRe_depth(int re_depth) {
		this.re_depth = re_depth;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getCount_comments() {
		return count_comments;
	}
	public void setCount_comments(int count_comments) {
		this.count_comments = count_comments;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	public int getDown() {
		return down;
	}
	public void setDown(int down) {
		this.down = down;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", writer=" + writer + ", subject=" + subject + ", passwd=" + passwd
				+ ", reg_date=" + reg_date + ", hit=" + hit + ", group_num=" + group_num + ", re_order=" + re_order
				+ ", re_depth=" + re_depth + ", contents=" + contents + ", ip=" + ip + ", count_comments="
				+ count_comments + ", filename=" + filename + ", filesize=" + filesize + ", down=" + down + "]";
	}
	
}
