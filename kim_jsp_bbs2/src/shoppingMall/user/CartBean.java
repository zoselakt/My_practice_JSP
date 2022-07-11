package shoppingMall.user;

import java.util.Vector;

import shoppingMall.ProductDTO;

public class CartBean {
	private Vector<ProductDTO> cartList;
	
	public CartBean(){
		cartList = new Vector<ProductDTO>(3,1);
	}//기본 생성자
	
	//** 장바구니에 상품을 추가하는 모듈 ***//
	public void addProd(ProdListDAO pdao, String pnum, String pqty, String pspec){
		// 가령 장바구니에 추가하고자하는 상품이 있을 경우에
		// 수량만 추가해주면 된다.
		
		int addPqty = Integer.parseInt(pqty.trim());
		
		for(ProductDTO pd:cartList){
			if(pnum.equals(pd.getPnum())){
				pd.setPqty(pd.getPqty()+addPqty);
				return;
			}//if
		}//for End
		
		// 장바구니에 추가하고자 하는 상품이 없을 경우에는
		// 새로운 상품을 추가시켜준다.
		ProductDTO pdto = pdao.getProduct(pnum, pspec); //상품번호로 해시테이블로 부터 정보를 가져옴
		
		if(pdto !=null){
			pdto.setPqty(addPqty);//수량 설정
			cartList.add(pdto); //장바구니에 추가
		}//if End
		
	}//addProd()----------------------
	
	//** 장바구니에 있는 모든 상품 리스트를 가져오는 모듈 **//
	public Vector<ProductDTO> getAllProducts(){
		return cartList;
	}//getAllPorducts()---------------------
	
	//** 장바구니의 상품을 수정하는 모듈 **//
	public void setModify(String pnum, String pqty){
    	int qty = Integer.parseInt(pqty.trim());
    	for(ProductDTO pd:cartList){
    		if(pnum.equals(pd.getPnum())){
    			if(qty==0){
    				//삭제처리한다.
    				cartList.removeElement(pd);
    				break;
    			}else{
    				pd.setPqty(qty);
    				break;
    			}//if
    		}//if
    	}//for End
	}//setModify()------------
	
	//** 장바구니에서 상품을 삭제 **//
	public void delProd(String pnum){
		for(ProductDTO pd:cartList){
			if(pnum.equals(pd.getPnum())){
				cartList.removeElement(pd);
				break;
			}//if End----
		}//for
	}//delProd()
	
}












