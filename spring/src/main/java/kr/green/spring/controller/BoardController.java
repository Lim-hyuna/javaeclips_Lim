package kr.green.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.MemberVo;

@Controller
//@RequestMapping(value="/board")  // /spring/board/list
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	//url등록 
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv, Criteria cri){
		cri.setPerPageNum(2);
		//System.out.println(cri);
		int totalCount = boardService.getTotalCount();
		//등록된 게시글을 가져옴(여러개)
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		PageMaker pm = new PageMaker(cri, 5, totalCount);
		//System.out.println(pm);
		mv.addObject("pm", pm);
		mv.addObject("list", list);
	    mv.setViewName("/board/list");
	    return mv;
	}
	
	@RequestMapping(value="/board/insert", method=RequestMethod.GET)
	public ModelAndView boardInsertGet(ModelAndView mv){
	    mv.setViewName("/board/insert");
	    return mv;
	}
	@RequestMapping(value="/board/insert", method=RequestMethod.POST)
	public ModelAndView boardInsertPost(ModelAndView mv, BoardVO board, HttpSession session){
		//화면에서 전송한 데이터가 잘 오는 지 확인 
		//System.out.println(board);
		//로그인한 회원 정보를 확인 
		MemberVo user = (MemberVo)session.getAttribute("user");
		//System.out.println(user);
		//게시글등록 진행
		boardService.insertBoard(board,user);
	    mv.setViewName("redirect:/board/list");
	    return mv;
	}
	
	@RequestMapping(value="/board/select/{bd_num}", method=RequestMethod.GET)
	public ModelAndView boardselectGet(ModelAndView mv, @PathVariable("bd_num")Integer bd_num){
		//System.out.println(bd_num);
		//게시글 번호에 맞는 게시글 조회수를 증가 
		boardService.updateViews(bd_num);
		//게시글 번호에 맞는 게시글 정보를 가져옴 
		BoardVO board = boardService.getBoard(bd_num);
		//System.out.println(board);
		//가져온 게시글을 화면에 전달 
		mv.addObject("board",board);
	    mv.setViewName("/board/select");
	    return mv;
	}
	
	@RequestMapping(value="/board/update/{bd_num}", method=RequestMethod.GET)
	public ModelAndView boardUpdateGet(ModelAndView mv, @PathVariable("bd_num")Integer bd_num){
		BoardVO board = boardService.getBoard(bd_num);
		mv.addObject("board",board);
	    mv.setViewName("/board/update");
	    return mv;
	}
	@RequestMapping(value="/board/update/{bd_num}", method=RequestMethod.POST)
	public ModelAndView boardUpdatePost(ModelAndView mv, 
			@PathVariable("bd_num")Integer bd_num, HttpSession session, BoardVO board){
			//수정한 게시글 정보를 확인
			//System.out.println(board);
			//로그인한 회원 정보를 확인
			MemberVo user = (MemberVo) session.getAttribute("user");
			//System.out.println(user);
			//게시글 수정 요청 	
			board.setBd_num(bd_num);
			boardService.updateBoard(board,user);
	    mv.setViewName("redirect:/board/select/"+bd_num);
	    return mv;
	}
	
	@RequestMapping(value="/board/delete/{bd_num}", method=RequestMethod.GET)
	public ModelAndView boardDeleteGet(ModelAndView mv, 
			@PathVariable("bd_num")Integer bd_num, HttpSession session){
		//System.out.println(bd_num);
		MemberVo user = (MemberVo) session.getAttribute("user");
		boardService.deleteBoard(bd_num,user);	
	    //System.out.println(user);
		mv.setViewName("redirect:/board/list");
	    return mv;
	}
	
}

