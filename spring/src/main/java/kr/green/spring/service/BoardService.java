package kr.green.spring.service;

import java.util.ArrayList;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.CommentVO;
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

	String insertComment(CommentVO comment, MemberVo user);

	ArrayList<CommentVO> getCommentList(int co_bd_num, Criteria cri);

	int getTotalCountComment(int co_bd_num);

	boolean deleteComment(CommentVO comment, MemberVo user);

	

	

}
