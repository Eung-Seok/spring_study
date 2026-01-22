package com.app.controller.study.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	
	@RequestMapping("/faq")
	public String faq() {
		return "/board/faq";
	}
	
	@RequestMapping("/notice")
	public String notice() {
		return "/board/notice";
	}
	
	
}
