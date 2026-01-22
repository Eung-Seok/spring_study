package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/main") // 어떤 주소로 접속 했을 때!
	public String main() {
		
		//return -> view 자원이름
		
		return "main";
	}
}
