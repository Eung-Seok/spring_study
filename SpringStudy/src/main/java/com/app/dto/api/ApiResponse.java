package com.app.dto.api;

import lombok.Data;

@Data
public class ApiResponse<T> {
	//Generic 제네틱   타입을 고정하지 않고 일반화
	
	ApiResponseHeader header;
	T body;
	
//	List<String>
//	List<Integer>
//	List<ApiMenu>
}
