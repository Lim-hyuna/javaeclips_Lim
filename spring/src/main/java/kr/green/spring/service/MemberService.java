package kr.green.spring.service;

import kr.green.spring.vo.MemberVo;

public interface MemberService {

	String getEmail(String id);

	MemberVo getMember(String me_id);

	MemberVo getMember(MemberVo member);

	





}
