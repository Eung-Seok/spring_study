package com.app.controller.study.quiz.quiz09;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/quiz09")
public class Quiz09Controller {

	@GetMapping("/listTest")
	public String listTest(@RequestParam(required = false) String type, Model model) {
		if(type.equals("str")) {
		return "redirect:/quiz07/listTest/str";
		} else if(type.equals("member")) {
			return  "forward:/quiz07/listTest/member";
		}
		return "";
	}

}
