<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList, OCM.Model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Servlet</title>

</head>
<body>
	<h1>I'm being dispatched from TestServlet.java!</h1>
	<p>My name is: aaa.</p>
	<c:forEach items="${data}" var="i">
		<p>${i.getID()}</p>
		<p>${i.getEmail()}</p>
		<p>${i.getJoinedAt()}</p>
		<p>${i.getBio()}</p>
	</c:forEach>
</body>
</html>