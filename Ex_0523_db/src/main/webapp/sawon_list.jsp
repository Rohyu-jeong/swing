<%@page import="vo.SawonVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int no = Integer.parseInt(request.getParameter("deptno"));

	InitialContext ic = new InitialContext();
	Context ctx = (Context)ic.lookup("java:comp/env");
	DataSource ds = (DataSource)ctx.lookup("jdbc/oracle_test");
	Connection conn = ds.getConnection();
	
	String sql = "select * from sawon where deptno="+no;
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	ResultSet rs = pstmt.executeQuery(sql);
	
	List <SawonVO> list = new ArrayList <> ();
	
	while(rs.next()) {
		SawonVO vo = new SawonVO();
		
		vo.setSabun(rs.getInt("sabun"));
		vo.setName(rs.getString("name"));
		vo.setDeptno(rs.getInt("deptno"));
		vo.setSapay(rs.getInt("sapay"));
		
		list.add(vo);
	}
	
	rs.close();
	pstmt.close();
	conn.close();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<caption>부서목록</caption>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>급여</th>
			<th>부서번호</th>
		</tr>
		<%for(int i = 0; i < list.size(); i++){ %>
		<tr>
			<td><%= list.get(i).getSabun() %></td>
			<td><%= list.get(i).getName() %></td>
			<td><%= list.get(i).getDeptno() %></td>
			<td><%= list.get(i).getSapay() %></td>
		</tr>
		<%} %>
	</table>

</body>
</html>