package com.app.controller.study.quiz.quiz07;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/quiz07")
public class Quiz07Controller {

	@GetMapping("/listTest")
	public String listTest(@RequestParam(required = false) String type, Model model) {
		if(type.equals("str")) {
		model.addAttribute("num", 10);
		return "redirect:/quiz07/listTest/str";
		} else if(type.equals("member")) {
			List<Member> productList = new ArrayList<Member>();
			for(int i = 0; i < 5; i++) {
				productList.add(new Member("아이디"+(i+1), "비번"+(i+1), "이름"+(i+1)));
			}
			model.addAttribute("memberList", productList);
			
			return  "redirect:/quiz07/listTest/member";
		}
		return "";
	}
	
	@GetMapping("/listTest/str")
	public String str(@RequestParam(required = false) String type, Model model) {
		model.addAttribute("num", 10);
		return "quiz/quiz07/listtest1";
	}
	
	@GetMapping("/listTest/member")
	public String member(@RequestParam(required = false) String type, Model model) {
		List<Member> productList = new ArrayList<Member>();
		for(int i = 0; i < 5; i++) {
			productList.add(new Member("아이디"+(i+1), "비번"+(i+1), "이름"+(i+1)));
		}
		model.addAttribute("memberList", productList);
		
		return "quiz/quiz07/listtest2";
	}
	
}
