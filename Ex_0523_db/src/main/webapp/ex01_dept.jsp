<%@page import="vo.DeptVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// 톰캣이 JNDI를 검색하기 위해 필요한 클래스 (JNDI 기법 : Java naming directory interface)
	InitialContext ic = new InitialContext();

	Context ctx = (Context)ic.lookup("java:comp/env");
	
	// lookup -> 찾는 함수
	// java:comp/env -> 자바에 내장 되어 있는 리소스 자원을 검색하는 상수(고정)
	
	// 검색된 Resource를 통해 JNDI의 자원을 검색
	// context.xml파일의 resource 영역에 참조되어 있는 name 속성값
	DataSource ds = (DataSource)ctx.lookup("jdbc/oracle_test");
	
	Connection conn = ds.getConnection();
	
	String sql = "select * from dept";
	
	// 문자열 형태의 sql문을 실제 쿼리문으로 전달
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	// executeQuery() : 전달받은 쿼리문을 실행하여 결과를 반환받는다.
	// 전달받은 데이터는 rs객체에 저장됨
	ResultSet rs = pstmt.executeQuery();
	
	out.println("--- 디비 접속 성공 ---");
	
	List<DeptVO> dept_list = new ArrayList <> ();
	
	while(rs.next()) {
		DeptVO vo = new DeptVO();
		
		// 현재 행의 값을 vo에 담는다.
		vo.setDeptno(rs.getInt("deptno"));
		vo.setDname(rs.getString("dname"));
		vo.setLoc(rs.getString("loc"));
		
		dept_list.add(vo);
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
<script type="text/javascript">
	function send(data) {
		let f = document.m_form;
		let no = f.deptno;
		no.value = data;
		
		f.action = 'sawon_list.jsp';
		f.submit();
	}
</script>
</head>
<body>
	<form name="m_form">
	<table border="1">
		<caption>부서목록</caption>
		<tr>
			<th>부서번호</th>
			<th>부서명</th>
			<th>부서위치</th>
		</tr>
		<%for(int i = 0; i < dept_list.size(); i++){ %>
		<tr>
			<td><%= dept_list.get(i).getDeptno() %></td>
			<td>
				<a href="javascript:send('<%= dept_list.get(i).getDeptno() %>');">
					<%= dept_list.get(i).getDname() %>
				</a>
			</td>
			<td><%= dept_list.get(i).getLoc() %></td>
		</tr>
		<%} %>
	</table>
	<input type="hidden" name='deptno'>
	</form>
</body>
</html>