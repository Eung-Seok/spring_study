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

	
	<p>스트링 리스트입니다.</p>
	<p>스트링 리스트입니다.</p>
	<p>스트링 리스트입니다.</p>
	<p>스트링 리스트입니다.</p>
	<p>스트링 리스트입니다.</p>
	<p>스트링 리스트입니다.</p>
	<p>스트링 리스트입니다.</p>
	<p>스트링 리스트입니다.</p>
	<p>스트링 리스트입니다.</p>
	<p>스트링 리스트입니다.</p>
	<hr>
	<c:forEach var="i" begin="1" end="10" step="1">
		<div>
			<p>스트링 리스트입니다.</p>
		</div>
	</c:forEach>
	<hr>
	<c:forEach var="i" begin="1" end="${num}" step="1">
		<div>
			<p>스트링 리스트입니다.</p>
		</div>
	</c:forEach>
	
</body>
</html>