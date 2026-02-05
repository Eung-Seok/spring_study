package com.app.controller.study.quiz.quiz15;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/quiz15")
public class Quiz15Controller {

	@Autowired
	RoomsService roomService;
	@Autowired
	InfoService infoService;
	
	@GetMapping("/info")
	public String info(Model model) {

		List<Info> infoList = infoService.findInfoList();

		// 화면에 보여줄 데이터 -> view 전달
		model.addAttribute("infoList", infoList);
		return "/quiz/quiz15/quiz15";
	}

	@GetMapping("/room")
	public String room(Model model) {

		List<Rooms> roomList = roomService.findRoomList();

		// 화면에 보여줄 데이터 -> view 전달
		model.addAttribute("roomList", roomList);
		
		return "/quiz/quiz15/quiz15";
	}
}
