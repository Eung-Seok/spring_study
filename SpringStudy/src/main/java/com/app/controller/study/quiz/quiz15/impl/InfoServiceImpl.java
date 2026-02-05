package com.app.controller.study.quiz.quiz15.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.controller.study.quiz.quiz15.Info;
import com.app.controller.study.quiz.quiz15.InfoDAO;
import com.app.controller.study.quiz.quiz15.InfoService;
import com.app.controller.study.quiz.quiz15.RoomsDAO;

@Service
public class InfoServiceImpl implements InfoService {

	@Autowired
	InfoDAO infoDAO;
	
	@Override
	public List<Info> findInfoList() {

		System.out.println("[Service] 호출 findInfoList");
		
		List<Info> info = infoDAO.findInfoList();
		
		return null;
	}

}
