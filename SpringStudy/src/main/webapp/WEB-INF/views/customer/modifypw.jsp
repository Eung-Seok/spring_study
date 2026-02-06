<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="" method="post">
	<input type="hidden" name="id" value="${user.id}"><br>
	<input type="hidden" name="name" value="${user.name}"><br>
	<input type="hidden" name="userType" value="${user.userType}"><br>
	변경하실 비밀번호 : <input type="text" name="pw">
	<button type="submit">변경하기</button>
	</form>
	
	<a href="/customer/mypage">마이페이지로 이동</a>
</body>
</html>