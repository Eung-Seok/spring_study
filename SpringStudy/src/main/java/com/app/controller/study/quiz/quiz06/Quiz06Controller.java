package com.app.controller.study.quiz.quiz06;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz06")
public class Quiz06Controller {

	@GetMapping("/ask-bmi")
	public String ask_bmi() {
		return "/quiz/quiz06/ask_bmi";
	}
	
	@PostMapping("/result-bmi")
	public String result_bmi(HttpServletRequest request) {
		
		double weight = Double.parseDouble(request.getParameter("weight"));
		double height = Double.parseDouble(request.getParameter("height"))/100;
		double bmi = weight / (height * height);
		request.setAttribute("bmi", bmi);
		request.setAttribute("name", request.getParameter("name"));
		request.setAttribute("height", request.getParameter("height"));
		request.setAttribute("weight", request.getParameter("weight"));

		return "/quiz/quiz06/result_bmi";
	}
}
