package com.app.controller.study.quiz.quiz19;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Quiz19Controller {

	@GetMapping("/quiz19/quiz1")
	public String quiz1() {
		return "quiz/quiz19/quiz1";
	}
	
	
}
