package com.app.controller.study.quiz.quiz15.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.controller.study.quiz.quiz15.Rooms;
import com.app.controller.study.quiz.quiz15.RoomsDAO;
import com.app.controller.study.quiz.quiz15.RoomsService;

@Service
public class RoomsServiceImpl implements RoomsService {

	@Autowired
	RoomsDAO roomsDAO;
	
	@Override
	public List<Rooms> findRoomList() {

		System.out.println("[Service] 호출 findInfoList");
		
		List<Rooms> roomList = roomsDAO.findRoomList();
		
		return null;
	}

}
