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
		사용자아이디 : <input type="text" name="id"><br>
		사용자 이름 : <input type="text" name="name"><br>
		사용자 비번 : <input type="password" name="pw"><br>
		
		<!-- 		서버에서 자동으로 CUS 로 세팅 -->
		
<!-- 		화면에서 form 내부에 hidden 으로 포함 -->
<!-- 		<input type="hidden" name="userType" value="CUS"> -->
		
		<button type="submit">가입하기</button>
	</form>
	
</body>
</html>