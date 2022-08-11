package kr.green.spring.service;

import kr.green.spring.vo.MemberVo;

public interface MemberService {

	boolean signup(MemberVo member);

	MemberVo login(MemberVo member);

	boolean checkId(MemberVo member);


}
