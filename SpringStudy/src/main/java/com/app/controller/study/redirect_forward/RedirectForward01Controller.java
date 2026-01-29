package com.app.controller.study.redirect_forward;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectForward01Controller {

	
	@GetMapping("/re/re1")
	public String re1() {
		return "re/re1";
	}
	
	@GetMapping("/re/re2")
	public String re2(HttpServletRequest request) {
	
		System.out.println("/re/re2");
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", request.getParameter("msg"));
		
		return "re/re2";
	}
	
	@GetMapping("/re/re3")
	public String re3(HttpServletRequest request) {
	
		System.out.println("/re/re3");
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", request.getParameter("msg"));
		
		return "re/re2";
	}public RedirectForward01Controller() {
		// TODO Auto-generated constructor stub
	}
	@GetMapping("/re/re4")
	public String re4(HttpServletRequest request) {
	
		System.out.println("/re/re4");
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", request.getParameter("msg"));
		
		return "re/re4";
	}
	
	@GetMapping("/re/re5")
	public String re5(HttpServletRequest request) {
	
		System.out.println("/re/re5");
		System.out.println(request.getParameter("msg"));
		
		return "redirect:re/re2"; //redirect:요청날릴 경로
		//화면 view경로 xxxxxx 
	}
	
	@GetMapping("/re/re6")
	public String re6(HttpServletRequest request) {
	
		//서버에서 forward 처리
		System.out.println("/re/re6");
		System.out.println(request.getParameter("msg"));
		
		//forward 서버에서 바로 요청 경로를 이동하여 수행
		return "forward:/re/re2"; //forward:요청경로
	}
	
	@GetMapping("/re/re7")
	public String re7(HttpServletRequest request, RedirectAttributes ra) {
	
		System.out.println("/re/re7");
		System.out.println(request.getParameter("msg"));
//		
//		ra.addAttribute("msg", "hihello");
//		ra.addAttribute("stats", "tired");
		ra.addFlashAttribute("msg", "flashHello");
		
		
		return "redirect:/re/re2";
	}
}
