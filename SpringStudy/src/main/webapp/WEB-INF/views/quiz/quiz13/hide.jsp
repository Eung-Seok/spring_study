<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/quiz13/hideAd" method="post">
	<c:if test="${hide != 'hide' || open != 'false'}">
		<p>addadd</p>
	</c:if>
	<input type="checkbox" name="check">24시간안볼래요 <br>
	<button type="submit">닫기</button>
	</form>
	
	<script>
		const add = document.getElementById("adForm");
	</script>
</body>
</html>