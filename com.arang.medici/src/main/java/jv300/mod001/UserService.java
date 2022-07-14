package jv300.mod001;

import java.util.List;

import jv300.mod001.dao.MemberDao;
import jv300.mod001.vo.MemberVo;

public class UserService {
	private static UserService service = new UserService();
	public MemberDao memberdao;
	
	public UserService(MemberDao memberDao) {
		this.memberdao = memberDao;
	}
	
	public UserService() {}
	

	public static boolean isValidUser(String userId, String passwd) {
		return false;
	}
	
	public void addUser(MemberVo vo) {
		memberdao.addUser(vo);
	}
	public List<MemberVo> findMember(){
		return memberdao.findUser();
	}
	public static UserService getService() {
		return service;
	}
	public void modifyUser(String id, String password) {
		memberdao.modifyUser(id, password);
	}
	public void removeUser(String id, String password) {
		memberdao.removeUser(id, password);
	}
	
}
