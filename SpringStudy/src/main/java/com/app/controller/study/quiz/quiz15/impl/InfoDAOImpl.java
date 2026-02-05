package com.app.controller.study.quiz.quiz15.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.controller.study.quiz.quiz15.Info;
import com.app.controller.study.quiz.quiz15.InfoDAO;

@Repository
public class InfoDAOImpl implements InfoDAO{

	@Override
	public List<Info> findInfoList() {

		System.out.println("[DAO] 호출 findInfoList");
		//DB에 연동 -> room 테이블 데이터를 조회 -> List
		
		
		return null;
	}

}
