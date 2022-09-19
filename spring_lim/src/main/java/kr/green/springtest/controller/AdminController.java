package kr.green.springtest.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springtest.service.MemberService;
import kr.green.springtest.vo.MemberVO;

@Controller
public class AdminController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/admin/member/list")
	public ModelAndView adminMemberList(ModelAndView mv, HttpSession session){
		MemberVO user = (MemberVO)session.getAttribute("user");
		ArrayList<MemberVO> list = memberService.getMemberList(user);
		mv.addObject("list", list);
	    mv.setViewName("/admin/member/list");
	    return mv;
	}	
}
