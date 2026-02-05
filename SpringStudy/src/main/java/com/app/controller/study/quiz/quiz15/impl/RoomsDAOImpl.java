package com.app.controller.study.quiz.quiz15.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.controller.study.quiz.quiz15.Rooms;
import com.app.controller.study.quiz.quiz15.RoomsDAO;

@Repository
public class RoomsDAOImpl implements RoomsDAO{

	@Override
	public List<Rooms> findRoomList() {

		System.out.println("[DAO] 호출 findRoomoList");
		
		return null;
	}

}
