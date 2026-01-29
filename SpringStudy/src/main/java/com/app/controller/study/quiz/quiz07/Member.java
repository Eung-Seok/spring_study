package com.app.controller.study.quiz.quiz07;

import lombok.Data;

@Data
public class Member {
	String id;
	String pw;
	String name;
	
	public Member() {};
	public Member(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
}
