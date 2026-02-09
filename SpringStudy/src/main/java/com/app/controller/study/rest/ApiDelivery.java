package com.app.controller.study.rest;

import java.util.List; 

import lombok.Data;

@Data
public class ApiDelivery {

	String staffName; //배달기사이름
	String destination; //도착지
	String phone; //배달기사 전화번호
	
	ApiStore apiStore;
	List<ApiMenu> menuList;
}
