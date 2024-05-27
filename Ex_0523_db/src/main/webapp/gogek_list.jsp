<%@page import="java.util.ArrayList"%>
<%@page import="vo.GogekVO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	InitialContext ic = new InitialContext();

	Context ctx = (Context)ic.lookup("java:comp/env");
	DataSource ds = (DataSource)ctx.lookup("jdbc/oracle_test");
	Connection conn = ds.getConnection();
	
	String sql = "select * from gogek";
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	ResultSet rs = pstmt.executeQuery();
	
	List <GogekVO> gogek_list = new ArrayList <>();
	
	while (rs.next()) {
		GogekVO vo = new GogekVO();
		
		vo.setGobun(rs.getInt("gobun"));
		vo.setGoname(rs.getString("goname"));
		vo.setGojumin(rs.getString("gojumin"));
		vo.setGoaddr(rs.getString("goaddr"));
		
		gogek_list.add(vo);
	}
	
	rs.close();
	pstmt.close();
	conn.close();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>주민번호</th>
		</tr>
		<%for(int i = 0; i < gogek_list.size(); i++){ %>
		<tr>
			<td><%= gogek_list.get(i).getGobun() %></td>
			<td><%= gogek_list.get(i).getGoname() %></td>
			<td><%= gogek_list.get(i).getGoaddr() %></td>
			<td><%= gogek_list.get(i).getGojumin() %></td>
		</tr>
		<%} %>
	</table>
	
</body>
</html>