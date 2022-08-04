package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.MemberDAO;
import kr.green.spring.vo.MemberVo;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDAO memberDao;

	@Override
	public boolean signup(MemberVo member) {
		//유효성 검사
		if(member == null)
			return false;
		
		if(member.getMe_id() == null || member.getMe_id().length() == 0)
			return false;
		
		if(member.getMe_pw() == null || member.getMe_pw().length() == 0)
			return false;
		
		if(member.getMe_email() == null || member.getMe_email().length() == 0)
			return false;
		
		if(member.getMe_gender() != 'M' && member.getMe_gender() != 'F')
			return false;
		
		if(member.getMe_birth() == null)
			return false;
		
		MemberVo bdmember = memberDao.selectMember(member.getMe_id());
		//이미 가입된 아이디이면 
		if(bdmember != null)
			return false;
	
		//비밀번호 암호화 
		
		memberDao.insertMember(member);
		return true;
	}

	@Override
	public MemberVo login(MemberVo member) {
		if(member == null || member.getMe_id() == null)
			return null;
		
		MemberVo dbmember = memberDao.selectMember(member.getMe_id());
		//가입된 아이디가 아니면
		if(dbmember == null)
			return null;
		
		//아이디, 비번이 일치하는 경우 
		if(dbmember.getMe_pw().equals(member.getMe_pw()))
			return dbmember;
		//아이디는 있지만 비번이 다른 경우 
		return null;
	}
	

		

}

