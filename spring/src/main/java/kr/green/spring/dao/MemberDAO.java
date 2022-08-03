package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.MemberVo;

public interface MemberDAO {
	
	String selectEmail(@Param("me_id")String id);

	MemberVo selectMember(@Param("me_id")String me_id);

	MemberVo selectMember2(@Param("member")MemberVo member);

}
