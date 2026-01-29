package com.app.controller.study.scope;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Scope01Controller {

	// scope
	// request / session / application
	
	@GetMapping("/scope1")
	public String scope1(Model model) {
		
		//view Data 전달
		model.addAttribute("msg1", "이것은 model에 addAttribute한거");
		model.addAttribute("msg2", "이것은 request scope");
		
		return "scope/scope1";
	}
	@GetMapping("/scope2")
	public String scope2(HttpServletRequest request) {
		
		//request scope
		request.setAttribute("requestMsg", "request scope msg");
		
		//session scope
		HttpSession session = request.getSession();
		session.setAttribute("sessionMsg", "session scope msg");
		
		//application scope
		ServletContext app = request.getServletContext();
		app.setAttribute("appMsg", "application scope msg");
		
		return "scope/scope2";
	}
	
	@GetMapping("/scope3")
	public String scope3(HttpServletRequest request) {
		
		return "scope/scope3";
	}
	
	@GetMapping("/scope4")
	public String scope(HttpSession session) {
		
		session.setAttribute("newMsg", "session 받아서 new msg");
		
		session.removeAttribute("sessionMsg");
		
		session.invalidate(); // 세션 초기화 --> 기존 session scope에 저장된 모든 키/값 삭제  
		
		return "scope/scope3";
	}
}
