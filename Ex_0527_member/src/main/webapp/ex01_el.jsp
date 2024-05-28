<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String msg = "안녕";

	// JSP에 EL 표현식으로 출력을 하고 싶으면 4개의 영역 객체 중 하나에 담아야 한다.
	
	pageContext.setAttribute("msg", msg);
	
	request.setAttribute("msg", "request 영역에 저장됨");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${requestScope.msg}
	<!-- 영역 참조 순서
	1. pageContext
	2. request
	3. session
	4. application -->
</body>
</html>