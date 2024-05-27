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
	// ��Ĺ�� JNDI�� �˻��ϱ� ���� �ʿ��� Ŭ���� (JNDI ��� : Java naming directory interface)
	InitialContext ic = new InitialContext();

	Context ctx = (Context)ic.lookup("java:comp/env");
	
	// lookup -> ã�� �Լ�
	// java:comp/env -> �ڹٿ� ���� �Ǿ� �ִ� ���ҽ� �ڿ��� �˻��ϴ� ���(����)
	
	// �˻��� Resource�� ���� JNDI�� �ڿ��� �˻�
	// context.xml������ resource ������ �����Ǿ� �ִ� name �Ӽ���
	DataSource ds = (DataSource)ctx.lookup("jdbc/oracle_test");
	
	Connection conn = ds.getConnection();
	
	String sql = "select * from dept";
	
	// ���ڿ� ������ sql���� ���� ���������� ����
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	// executeQuery() : ���޹��� �������� �����Ͽ� ����� ��ȯ�޴´�.
	// ���޹��� �����ʹ� rs��ü�� �����
	ResultSet rs = pstmt.executeQuery();
	
	out.println("--- ��� ���� ���� ---");
	
	List<DeptVO> dept_list = new ArrayList <> ();
	
	while(rs.next()) {
		DeptVO vo = new DeptVO();
		
		// ���� ���� ���� vo�� ��´�.
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
		<caption>�μ����</caption>
		<tr>
			<th>�μ���ȣ</th>
			<th>�μ���</th>
			<th>�μ���ġ</th>
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