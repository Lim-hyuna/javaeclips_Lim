package kr.green.spring.service;

import java.util.ArrayList;

import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.MemberVo;

public interface BoardService {

	void insertBoard(BoardVO board, MemberVo user);

	ArrayList<BoardVO> getBoardList();

}
