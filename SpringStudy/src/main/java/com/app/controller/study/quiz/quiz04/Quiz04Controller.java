package com.app.controller.study.quiz.quiz04;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/quiz04")
public class Quiz04Controller {

	
	@GetMapping("/request1-1")
	public String request1_1(HttpServletRequest request) {
		
		System.out.println(request.getParameter("category"));
		System.out.println(request.getParameter("product"));
		
		return "/quiz/quiz04/request";
	}
	
	@GetMapping("/request1-2")
	public String request1_2(@RequestParam(required = false) String category, @RequestParam(required = false) String product) {
		
		System.out.println(category);
		System.out.println(product);
		
		return "/quiz/quiz04/request";
	}
	
	@GetMapping("/request1-3")
	public String request1_3(@ModelAttribute Request request) {
		
		System.out.println(request);
		
		return "/quiz/quiz04/request";
	}
	
	@GetMapping("/request1-4")
	public String request1_4(@RequestParam Map<String,String> paramMap) {
		
		System.out.println(paramMap.get("category"));
		System.out.println(paramMap.get("product"));
		
		return "/quiz/quiz04/request";
	}
	
	@GetMapping("/viewData1-1")
	public String viewData1_1(HttpServletRequest request) {
		
		request.setAttribute("response001", "hello");
		request.setAttribute("response099", "goodbye");
		return "/quiz/quiz04/viewData";
	}
	
	@GetMapping("/viewData1-2")
	public String viewData1_2(Model model) {
		
		model.addAttribute("response001", "hi");
		model.addAttribute("response099", "bye");
		return "/quiz/quiz04/viewData";
	}
	
	@GetMapping("/viewData1-3")
	public ModelAndView viewData1_3() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/quiz/quiz04/viewData");
		mav.addObject("response001", "ㅎㅇ");
		mav.addObject("response099", "ㅂㅇ");
		
		return mav;
	}
	
	@GetMapping("/viewData1-4")
	public String viewData1_4(@ModelAttribute Request request, Model model) {
		
		TransferItem ti = new TransferItem();
		ti.setValue001("하이");
		ti.setValue099("바이");
		model.addAttribute("transferItem", ti);
		return "/quiz/quiz04/viewData";
	}
	
	
}
