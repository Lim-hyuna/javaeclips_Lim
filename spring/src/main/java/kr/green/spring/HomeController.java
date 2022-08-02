package kr.green.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	/* 접근제한자 : public - 고정
	 * 리턴타입 : ajax(차후 배울예정)를 이용한 경우는 제외하고는 기본적으로 ModelAndView
	 * 메소드명 : url 경로와 처리방식(GET/POST)에서 따오는 게 편함
	 * 			예로, url/login이고 get방식이면 loginGet으로 짓는 게 편함
	 * 매개변수 : ajax를 제외하고는 기본적으로 ModelAndView mv는 들어가고, 다른 매개변수는 추가로 올수 있음.
	 * 예외처리 : 안해도 됨 
	 * */
	/* mv.setViewName(문자열) 
	 * 	- ViewResolver로 보낼 문자열을 설정
	 *  - redirect, forward가 있는 경우 url로 이동 
	 *    예 : "redirect:/" 또는 "forward:/"
	 * mv.addObject("화면에서 사용할 이름", 변수/객체)
	 * 	- 화면에서 사용할 데이터를 이름과 함께 추가 
	 * */
	/* @RequestMapping
	 * value : 처리할 url, {"url1", "url2"}을 이용하여 여러 url을 하나로 처리할 수 있다. 
	 * method : url요청 방식, RequestMethod.GET/RequestMethod.POST
	 * 			생략하면 둘다 처리 
	 * */
	@RequestMapping(value="/")
	public ModelAndView openTilesView(ModelAndView mv){
	    mv.setViewName("/main/home");
	    mv.addObject("setHeader", "타일즈");
	    return mv;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv){
	    mv.setViewName("/main/login");
	    mv.addObject("setHeader", "타일즈");
	    return mv;
	}
	

	
}
