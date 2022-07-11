package shoppingMall;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.oreilly.servlet.MultipartRequest;

public class ProductDAO {
	private static ProductDAO insPDAO = new ProductDAO();
	
	private ProductDAO(){		
	}// 기본생성자
	
	public static ProductDAO getInstance(){
		return insPDAO;
	}
	
	//상품 등록 모듈
	public int registerProduct(MultipartRequest multi) throws SQLException{
		Connection dbconn = null;
		PreparedStatement ps = null;
		
		try{
			dbconn = getConnection();
			String sql = "insert into product values(product_seq.nextval,?,?,?,?,?,?,?,?,?,sysdate)";
			
			ps = dbconn.prepareStatement(sql);
			
			String pname = multi.getParameter("pname");
			String pcategory_fk = multi.getParameter("pcategory_fk");
			String pcompany = multi.getParameter("pcompany");
			String pimage = multi.getFilesystemName("pimage");
			String pqty = multi.getParameter("pqty");
			String price = multi.getParameter("price");
			String pspec = multi.getParameter("pspec");
			String pcontents = multi.getParameter("pcontents");
			String point = multi.getParameter("point");
			
			ps.setString(1, pname);
			ps.setString(2, pcategory_fk);
			ps.setString(3, pcompany);
			ps.setString(4, pimage);
			ps.setString(5, pqty);
			ps.setString(6, price);
			ps.setString(7, pspec);
			ps.setString(8, pcontents);
			ps.setString(9, point);
			
			int n = ps.executeUpdate();
			return n;
		}finally{
			if(ps !=null) ps.close();
			if(dbconn !=null) dbconn.close();
		}
	}//registerProduct()
	
	//상품번호로 특정 상품 정보 가져오기
	
	public ProductDTO selectProduct(String pnum) throws SQLException{
		Connection dbconn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from product where pnum=?";
		
		try{
			dbconn = getConnection();
			ps = dbconn.prepareStatement(sql);
			ps.setString(1, pnum);
			rs=ps.executeQuery();
			ArrayList<ProductDTO> pdtos = this.makeArrayList(rs);
			ProductDTO pdto = null;
			if(pdtos !=null && pdtos.size() !=0){
				pdto=pdtos.get(0);
			}//if
			return pdto;
		}finally{
			if(rs !=null) rs.close();
			if(ps !=null) ps.close();
			if(dbconn !=null) dbconn.close();
		}
	}//selectProduct()
	
	
	//모든 상품 리스트를 가져오기 모듈 
	public ArrayList<ProductDTO> productAll() throws SQLException{
		Connection dbconn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from product order by pnum desc";
		
		try{
			dbconn = getConnection();
			ps =dbconn.prepareStatement(sql);
			rs = ps.executeQuery();	
			ArrayList<ProductDTO> pdtos = makeArrayList(rs);
			return pdtos;
		}finally{
			if(rs !=null) rs.close();
			if(ps!=null) ps.close();
			if(dbconn !=null) dbconn.close();
		}
		
	}//productAll()
	
	public ArrayList<ProductDTO> makeArrayList(ResultSet rs) throws SQLException{
		ArrayList<ProductDTO> pdtos = new ArrayList<ProductDTO>();
		
		while(rs. next()){
			String pnum=rs.getString(1);
			String pname = rs.getString(2);
			String pcategory_fk =rs.getString(3);
			String pcompany = rs.getString(4);
			String pimage = rs.getString(5);
			int pqty = rs.getInt(6);
			int price = rs.getInt(7);
			String pspec = rs.getString(8);
			String pcontents = rs.getString(9);
			int point = rs.getInt(10);
			Date d = rs.getDate(11);
			String pinputDate = d.toString();
			
			ProductDTO pdto = new ProductDTO(pnum, pname, pcategory_fk, pcompany,pimage,
					          pqty, price, pspec, pcontents,point, pinputDate, 0, 0);
			pdtos.add(pdto);
		}//while End
		
		return pdtos;
	}//makeArrayList()
	
	// 상품 정보를 수정처리하는 로직
	public int updateProd(MultipartRequest multi) throws SQLException{
		Connection dbconn =null;
		PreparedStatement ps = null;
		
		String pname=multi.getParameter("pname");
		String pcategory_fk = multi.getParameter("pcategory_fk");
		String pcompany = multi.getParameter("pcompany");
		String pimageNew = multi.getFilesystemName("pimageNew");
		//pimageNew가 null인 경우는 이미지를 수정하지 않았다는 것 
		if(pimageNew==null){
			pimageNew=multi.getParameter("pimageOld");
		}
		String pqty=multi.getParameter("pqty");
		String price = multi.getParameter("price");
		String pspec = multi.getParameter("pspec");
		String pcontents = multi.getParameter("pcontents");
		String point = multi.getParameter("point");
		String pnum = multi.getParameter("pnum");
				
		
		String sql="update product set pname=?,"
				+ "pcategory_fk=?, pcompany=?, pimage=?,"
				+ "pqty=?, price=?, pspec=?,pcontents=?, point=?,"
				+ "pinputDate=sysdate where pnum=?";
		
		try{
			dbconn=getConnection();			
			ps = dbconn.prepareStatement(sql);
			
			ps.setString(1,pname);
			ps.setString(2, pcategory_fk);
			ps.setString(3, pcompany);
			ps.setString(4, pimageNew);
			ps.setInt(5,Integer.parseInt(pqty));
			ps.setInt(6,Integer.parseInt(price));
			ps.setString(7, pspec);
			ps.setString(8, pcontents);
			ps.setInt(9, Integer.parseInt(point));
			ps.setInt(10, Integer.parseInt(pnum));
			
			return ps.executeUpdate();
		}finally{
			if(ps !=null) ps.close();
			if(dbconn !=null) dbconn.close();
		}
	}//updateProd()
	
	
	//상품번호로 해당 상품정보를 삭제하는 로직
	public int delProd(String pnum)throws SQLException{
		Connection dbconn = null;
		PreparedStatement ps = null;
		String sql = "delete from product where pnum=?";
		
		try{
			dbconn=getConnection();
			ps = dbconn.prepareStatement(sql);
			ps.setString(1, pnum);
			int n = ps.executeUpdate();
			return n;
		}finally{
			if(ps !=null) ps.close();
			if(dbconn !=null) dbconn.close();
		}
	}//delProd()////////
	
	
	//connection pool에서 connection 확보
	private Connection getConnection(){
		Context ctx = null;
		DataSource ds = null;
		Connection dbconn = null;
		
		try {
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			dbconn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dbconn;
	}
}
