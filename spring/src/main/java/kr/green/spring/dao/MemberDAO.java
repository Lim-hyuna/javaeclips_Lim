package kr.green.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.MemberVo;

public interface MemberDAO {

	MemberVo selectMember(@Param("me_id")String me_id);

	void insertMember(@Param("m")MemberVo member);

	ArrayList<String> selectIdList(@Param("m")MemberVo member);

	MemberVo selectMemberByEmailBirth(@Param("m")MemberVo member);

	void updateMember(@Param("m")MemberVo dbmember);


}
