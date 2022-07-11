package shoppingMall;

public class ProductDTO {
	private String pnum;
	private String pname;
	private String pcategory_fk;
	private String pcompany;
	private String pimage;
	private int pqty;
	private int price;
	private String pspec;
	private String pcontents;
	private int point;
	private String pinputDate;
	
	int totPrice;
	int totPoint;
	int salePrice;
	
	public ProductDTO(){
		super();
	} //기본생성자
	
	public ProductDTO(String pnum, String pname, String pcategory_fk, String pcompany,
			String pimage, int pqty, int price, String pspec, String pcontents,
			int point, String pinputDate, int totPrice, int salePrice){
		super();
		this.pnum = pnum;
		this.pname = pname;
		this.pcategory_fk = pcategory_fk;
		this.pcompany = pcompany;
		this.pimage = pimage;
		this.pqty = pqty;
		this.price = price;
		this.pspec = pspec;
		this.pcontents = pcontents;
		this.point = point;
		this.pinputDate = pinputDate;
		this.totPoint = totPoint;
		this.salePrice = salePrice;
	} //인자 생성자

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPcategory_fk() {
		return pcategory_fk;
	}

	public void setPcategory_fk(String pcategory_fk) {
		this.pcategory_fk = pcategory_fk;
	}

	public String getPcompany() {
		return pcompany;
	}

	public void setPcompany(String pcompany) {
		this.pcompany = pcompany;
	}

	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	public int getPqty() {
		return pqty;
	}

	public void setPqty(int pqty) {
		this.pqty = pqty;
		
		totPrice = this.pqty*price;
		totPoint = this.pqty*point;
		System.out.println("totPrice: "
				+totPrice+",totPoint: "
				+totPoint);		
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPspec() {
		return pspec;
	}

	public void setPspec(String pspec) {
		this.pspec = pspec;
	}

	public String getPcontents() {
		return pcontents;
	}

	public void setPcontents(String pcontents) {
		this.pcontents = pcontents;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getPinputDate() {
		return pinputDate;
	}

	public void setPinputDate(String pinputDate) {
		this.pinputDate = pinputDate;
	}

	public int getTotPrice() {
		return totPrice;
	}

	public void setTotPrice(int totPrice) {
		this.totPrice = totPrice;
	}

	public int getTotPoint() {
		return totPoint;
	}

	public void setTotPoint(int totPoint) {
		this.totPoint = totPoint;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	
	
	
}
