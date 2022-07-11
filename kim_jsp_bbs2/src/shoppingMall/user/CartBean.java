package shoppingMall.user;

import java.util.Vector;

import shoppingMall.ProductDTO;

public class CartBean {
	private Vector<ProductDTO> cartList;
	
	public CartBean(){
		cartList = new Vector<ProductDTO>(3,1);
	}//�⺻ ������
	
	//** ��ٱ��Ͽ� ��ǰ�� �߰��ϴ� ��� ***//
	public void addProd(ProdListDAO pdao, String pnum, String pqty, String pspec){
		// ���� ��ٱ��Ͽ� �߰��ϰ����ϴ� ��ǰ�� ���� ��쿡
		// ������ �߰����ָ� �ȴ�.
		
		int addPqty = Integer.parseInt(pqty.trim());
		
		for(ProductDTO pd:cartList){
			if(pnum.equals(pd.getPnum())){
				pd.setPqty(pd.getPqty()+addPqty);
				return;
			}//if
		}//for End
		
		// ��ٱ��Ͽ� �߰��ϰ��� �ϴ� ��ǰ�� ���� ��쿡��
		// ���ο� ��ǰ�� �߰������ش�.
		ProductDTO pdto = pdao.getProduct(pnum, pspec); //��ǰ��ȣ�� �ؽ����̺�� ���� ������ ������
		
		if(pdto !=null){
			pdto.setPqty(addPqty);//���� ����
			cartList.add(pdto); //��ٱ��Ͽ� �߰�
		}//if End
		
	}//addProd()----------------------
	
	//** ��ٱ��Ͽ� �ִ� ��� ��ǰ ����Ʈ�� �������� ��� **//
	public Vector<ProductDTO> getAllProducts(){
		return cartList;
	}//getAllPorducts()---------------------
	
	//** ��ٱ����� ��ǰ�� �����ϴ� ��� **//
	public void setModify(String pnum, String pqty){
    	int qty = Integer.parseInt(pqty.trim());
    	for(ProductDTO pd:cartList){
    		if(pnum.equals(pd.getPnum())){
    			if(qty==0){
    				//����ó���Ѵ�.
    				cartList.removeElement(pd);
    				break;
    			}else{
    				pd.setPqty(qty);
    				break;
    			}//if
    		}//if
    	}//for End
	}//setModify()------------
	
	//** ��ٱ��Ͽ��� ��ǰ�� ���� **//
	public void delProd(String pnum){
		for(ProductDTO pd:cartList){
			if(pnum.equals(pd.getPnum())){
				cartList.removeElement(pd);
				break;
			}//if End----
		}//for
	}//delProd()
	
}












