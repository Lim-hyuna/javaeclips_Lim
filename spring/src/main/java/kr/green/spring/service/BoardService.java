package kr.green.spring.service;

import java.util.ArrayList;

import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.MemberVo;

public interface BoardService {

	void insertBoard(BoardVO board, MemberVo user);

	ArrayList<BoardVO> getBoardList();

	void updateViews(Integer bd_num);

	BoardVO getBoard(Integer bd_num);

	void updateBoard(BoardVO board, MemberVo user);

	void deleteBoard(Integer bd_num, MemberVo user);

	

}
