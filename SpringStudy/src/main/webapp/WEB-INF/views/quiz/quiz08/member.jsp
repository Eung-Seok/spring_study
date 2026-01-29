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

	<c:choose>
		<c:when test="${auth == 'basic'}">
			<c:forEach var="p" items="${basicList}">
				<p>${p.id}${p.pw}, ${p.name} ${p.type}</p>
			</c:forEach>
		</c:when>
		<c:when test="${auth.equals('manager')}">
			<c:forEach var="p" items="${managerList}">
				<p>${p.id}${p.pw}, ${p.name} ${p.type}</p>
			</c:forEach>
		</c:when>
		<c:when test="${auth.equals('admin')}">
			<c:forEach var="p" items="${memberList}">
				<p>${p.id}${p.pw}, ${p.name} ${p.type}</p>
			</c:forEach>
		</c:when>
		
		
		

	</c:choose>
</body>
</html>