package kr.green.spring.dao;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.MemberVo;

public interface MemberDAO {

	MemberVo selectMember(@Param("me_id")String me_id);

	void insertMember(@Param("m")MemberVo member);

	ArrayList<String> selectIdList(@Param("m")MemberVo member);

	MemberVo selectMemberByEmailBirth(@Param("m")MemberVo member);

	void updateMember(@Param("m")MemberVo dbmember);

	void updateMemberSession(@Param("me_id")String me_id, @Param("me_session_id")String me_session_id, @Param("me_session_limit")Date me_session_limit);

	MemberVo selectMemberBySession(@Param("session_id")String sessuib_id);

	ArrayList<MemberVo> selectMemberList(@Param("me_authority")int me_authority);


}
