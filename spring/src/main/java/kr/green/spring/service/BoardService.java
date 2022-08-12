package kr.green.spring.service;

import java.util.ArrayList;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.LikesVO;
import kr.green.spring.vo.MemberVo;

public interface BoardService {

	void insertBoard(BoardVO board, MemberVo user);

	ArrayList<BoardVO> getBoardList(Criteria cri);

	void updateViews(Integer bd_num);

	BoardVO getBoard(Integer bd_num);

	void updateBoard(BoardVO board, MemberVo user);

	void deleteBoard(Integer bd_num, MemberVo user);

	int getTotalCount(Criteria cri);

	String updateLikes(LikesVO likes);

	LikesVO getLikes(BoardVO board, MemberVo user);

	

	

}