<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>signup 회원 가입 페이지</h1>
	
<!-- 	<form action="" method="post"> -->
	<form action="/customer/signup" method="post">
		사용자아이디 : <input type="text" id="inputId" name="id">
		<button type="button" id="btn_checkDupId">중복체크</button>
		<p id="checkDupIdMsg"></p>
		
		
		사용자 이름 : <input type="text" name="name"><br>
		사용자 비번 : <input type="password" name="pw"><br>
		
		<!-- 		서버에서 자동으로 CUS 로 세팅 -->
		
<!-- 		화면에서 form 내부에 hidden 으로 포함 -->
<!-- 		<input type="hidden" name="userType" value="CUS"> -->
		
		<button type="submit">가입하기</button>
	</form>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script>
		const btn_checkDupId = document.getElementById('btn_checkDupId');
		const p_checkDupIdMsg = document.getElementById('checkDupIdMsg');
		
		btn_checkDupId.addEventListener('click', ()=> {
			//아이디 중복체크 버튼 클릭시
			//입력 아이디 값 확인 -> 서버로 ajax 요청(아이디) -> (서버) 중복체크 확인
			//(클라이언트) -> 결과를 Y/N 응답 -> 화면에 표시
			let inputId = document.getElementById('inputId').value;
			console.log(inputId);
			
			//서버에 요청
			
			
			//1) 단순 텍스트 id 요청  "inputId"   -> 응답 Y/N
// 			$.ajax({
// 				type: "POST",
// 				url: "http://localhost:8080/customer/checkDupId",
// 				headers: {
// 					"Content-type":"application/json"
// 				},
// 				data: inputId,  //서버에 보낼 데이터 값
// 				dataType: 'text', 
// 				success: function(result){
// 					console.log('ajax success');
// 					console.log(result);  //Y  N
					
// 					if(result == 'Y'){//중복
// 						p_checkDupIdMsg.textContent = '중복된 아이디입니다.';
// 						p_checkDupIdMsg.style.color = 'red';
// 					} else {//중복 아님
// 						p_checkDupIdMsg.textContent = '사용 가능한 아이디입니다.';
// 						p_checkDupIdMsg.style.color = 'green';
// 					}
					
					
// 				},
// 				error: function(error){
// 					console.log(error);
// 				}
				
// 			})

			// 2) json 포멧 전송, json 포멧 서버 응답 수신
			
			//요청할 데이터 json 포멧
			
			let obj = {		//javascript 객체 타입
					"id": inputId,
					"type": "CUS"	
			};
			
			// js obj -> JSON format text   JSON.strinfy
			// JSON format -> js obj		JSON.parse
			
			let jsonText = JSON.stringify(obj);
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/customer/checkDupIdJson",
				headers: {
					"Content-type":"application/json"
				},
				data: jsonText,  //서버에 보낼 데이터 값
				dataType: 'json',   //서버에서 응답도 json 포멧으로 보낼 예정
				success: function(result){
					console.log('ajax success');
					console.log(result);  //Y  N
					
					//dataType -> test -> json format text -> JSON.parse(result) ->javascript Object
					//dataType -> json -> result(javascript obj로 변환된 상태)
					
					// dataType -> text
					// let jsObj = JSON.parse(result);
					
					// dataType -> json
					let jsObj = result;
					
					console.log(jsObj.header.resultCode);
					console.log(jsObj.header.resultMsg);
					console.log(jsObj.body);
					
					if(jsObj.body == 'Y'){//중복
						p_checkDupIdMsg.textContent = '중복된 아이디입니다.';
						p_checkDupIdMsg.style.color = 'red';
					} else {//중복 아님
						p_checkDupIdMsg.textContent = '사용 가능한 아이디입니다.';
						p_checkDupIdMsg.style.color = 'green';
					}
					
					
				},
				error: function(error){
					console.log(error);
				}	
			})
		})
		
	
	</script>
	
	
	
</body>
</html>