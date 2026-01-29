package com.app.controller.study.quiz.quiz05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz05")
public class Quiz05Controller {

	
	@RequestMapping("/pathA")
	public String pathA() {
		return "/quiz/quiz05/pathA";
	}
	
	@RequestMapping("/pathCommon/A")
	public String pathCommonA() {
		return "/quiz/quiz05/pathA";
	}
	
	@RequestMapping("/pathB")
	public String pathB() {
		return "/quiz/quiz05/pathB";
	}
	
	
	@RequestMapping("/pathCommon/B")
	public String pathCommonB() {
		return "/quiz/quiz05/pathB";
	}
}
