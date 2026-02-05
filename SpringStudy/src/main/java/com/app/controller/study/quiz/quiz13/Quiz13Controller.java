package com.app.controller.study.quiz.quiz13;

import java.net.http.HttpResponse;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.util.MyCookieUtil;

@Controller
@RequestMapping("/quiz13")
public class Quiz13Controller {

	@GetMapping("/hideAd")
	public String hide(HttpServletRequest request, HttpSession session) {
		String hide = MyCookieUtil.getCookie(request, "hide");
		
		if(hide == null) {
			request.setAttribute("hide", "hide");
		}
		
		
		return "/quiz/quiz13/hide";
	}
	
	@PostMapping("/hideAd")
	public String hideAdd(HttpServletResponse response, HttpServletRequest request) {
		if(request.getParameter("check") != null) {
			Cookie ck = MyCookieUtil.createCookie("hide", "hide");
			ck.setMaxAge(60*60*24);
			response.addCookie(ck);
		}

		
		return "redirect:/quiz13/hideAd";
	}
}
