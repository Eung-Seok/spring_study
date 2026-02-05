package com.app.controller.study.quiz.quiz10;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz10")
public class Quiz10Controller {

	@RequestMapping("/A")
	public String a(HttpServletRequest request) {
		
		request.setAttribute("from", "FromA");
		request.setAttribute("original", "OriginalA");
		
		return "quiz/quiz10/a";
	}
	
	@RequestMapping("/B")
	public String b(HttpServletRequest request, HttpSession session) {
		
		session.setAttribute("sessionfrom", "FromB");
		request.setAttribute("original", "OriginalB");
		
		
		
		return "quiz/quiz10/b";
	}
}
