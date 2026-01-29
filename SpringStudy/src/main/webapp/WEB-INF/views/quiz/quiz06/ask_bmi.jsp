<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="/quiz06/result-bmi" method="post">
			이름: <input type='text' name='name'> <br>
			키: <input
				type='text' name='height'> <br>
				몸무게: <input type='text' name='weight'>  <br>
			<button type='submit'>제출</button>
		</form>
	</div>
</body>
</html>