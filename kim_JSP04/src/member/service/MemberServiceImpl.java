package member.service;

import java.util.List;

import dao.MemberDao;
import dao.MemberVo;

public class MemberServiceImpl implements MemberService{
	private static final MemberService memberService = new MemberServiceImpl();
	
	public static MemberService getInstance() {
		return memberService;
	}
	
	private MemberServiceImpl() {}
	private MemberDao memberDao = MemberDao.getInstance();
	
	@Override
	public List<MemberVo> list(String keyword){
		return memberDao.list(keyword);
	}

	@Override
	public void register(MemberVo memberVo) {
		
	}

	@Override
	public void remove(String id) {
		
	}

	@Override
	public MemberVo login(String id, String pwd) {
		return null;
	}
}
