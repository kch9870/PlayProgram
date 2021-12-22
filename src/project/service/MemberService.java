package project.service;

import java.util.ArrayList;

import project.dao.MemberDAO;
import project.vo.Member;

public class MemberService {
	private static MemberService service = new MemberService();
	
	public MemberDAO dao = MemberDAO.getInstance();	
	
	private MemberService() {
		
	}
	
	public static MemberService getInstance() {	
		return service;
	}
	
	public void Register(Member member) {
		dao.Register(member); 
	}
	public Member MemberLogin(String id, String passwd) {
		return dao.MemberLogin(id,passwd);
	}
	public ArrayList<Member> memberList() {
		return dao.memberList();
	}
	
	
	
	
	
	
	/*public Member memberSearch(String id) {
		Member m;
		m =  dao.memberSearch(id);
		return m;
	}
	public void memberUpdate(Member member) {
		dao.memberUpdate(member);
	}
	
	public void memberDelete(Member member) {
		dao.memberDelete(member);
	}}*/
	

	
}
