package kr.green.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView boardListGet(ModelAndView mv){
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
	
}

