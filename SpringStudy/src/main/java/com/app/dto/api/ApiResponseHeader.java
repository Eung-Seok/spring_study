package com.app.dto.api;

import lombok.Data;

@Data
public class ApiResponseHeader {

	String resultCode; //결과 코드
	String resultMsg; //결과 메세지 (설명)
	
}
