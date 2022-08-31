package kr.green.spring.service;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.green.spring.vo.MemberVo;

public interface MemberService {

	boolean signup(MemberVo member);

	MemberVo login(MemberVo member);

	boolean checkId(MemberVo member);

	ArrayList<String> getIdList(MemberVo member);

	void SendEmail(String title, String content, String email);

	boolean findPw(MemberVo member);

	void updateMember(MemberVo member, MemberVo user);

	void keepLogin(String me_id, String id, Date date);

	MemberVo autoLogin(String sessuib_id);

	void logout(HttpServletRequest request, HttpServletResponse response);

	ArrayList<MemberVo> getMemberList(MemberVo user);

	boolean updateAuthority(MemberVo member, MemberVo user);

	
}
