package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.MemberVo;

public interface MemberDAO {

	MemberVo selectMember(@Param("me_id")String me_id);

	void insertMember(@Param("m")MemberVo member);


}
