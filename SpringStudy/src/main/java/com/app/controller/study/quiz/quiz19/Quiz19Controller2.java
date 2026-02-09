package com.app.controller.study.quiz.quiz19;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.CommonCode;
import com.app.dto.user.User;

@RestController
public class Quiz19Controller2 {

	@GetMapping("/quiz19/quiz2")
	public String quiz2() {
		return "text quiz2";
	}
	
	@GetMapping("/quiz19/quiz3")
	public User quiz3() {
		User user = new User();
		user.setId("quizid");
		user.setPw("secret");
		user.setName("quiz이름");
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		
		return user;
	}
}
