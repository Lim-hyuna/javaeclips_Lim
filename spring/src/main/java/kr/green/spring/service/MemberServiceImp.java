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
	public String getEmail(String me_id) {
		if(me_id == null) {
			return null;
		}
		return memberDao.selectEmail(me_id);
	}

	@Override
	public MemberVo getMember(String me_id) {
		if(me_id == null)
		return null;
	  return memberDao.selectMember(me_id);
	}

	@Override
	public MemberVo getMember(MemberVo member) {
		if(member == null || member.getMe_id() == null || member.getMe_pw() == null)
			return null;
		
		MemberVo dbMember = memberDao.selectMember(member.getMe_id());
		if(dbMember == null)
			return null;
		if(dbMember.getMe_pw().equals(member.getMe_pw()))
			return dbMember;
		return null;
	}

	@Override
	public MemberVo getMember2(MemberVo member) {
		if(member == null || member.getMe_id() == null || member.getMe_pw() == null)
			return null;
		
		return memberDao.selectMember2(member);
	}
	

		

}

