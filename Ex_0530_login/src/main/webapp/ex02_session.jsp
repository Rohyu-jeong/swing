<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("param1", "asdf");
	session.setAttribute("param2", "qwer");
	session.setAttribute("param3", "zxcv");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${param1}<br>
	${param2}<br>
	${param3}<br>
</body>
</html>