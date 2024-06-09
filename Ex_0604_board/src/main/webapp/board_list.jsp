<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a{text-decoration: none;}
	
	table{border-collapse: collapse;}
</style>
</head>
<body>
	<table border="1" width="700">
		<tr>
			<td><img src="img/title_04.gif"></td>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>	
		</tr>
		<c:forEach var="vo" items="${list}">
		<tr>
			<td>${vo.idx}</td>	
			<td>
				<c:forEach begin="1" end="${vo.depth}">&nbsp;</c:forEach>
				<c:if test="${vo.depth > 0}">ㄴ</c:if>
				<a href="view.do?idx="${vo.idx}>
					${vo.subject}
				</a>
			</td>	
			<td>${vo.name}</td>	
			<td>${vo.regdate}</td>	
			<td>${vo.readhit}</td>	
			<td>${vo.readhit}</td>	
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="center">
				<- 1 2 3 ->
			</td>
		</tr>
		<tr>
			<td colspan="5" align="right">
				<img src="img/btn_reg.gif" onclick="location.href='insert_form.jsp'" style="cursor:pointer">
		</tr>
	</table>
</body>
</html>