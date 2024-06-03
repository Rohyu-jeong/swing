<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/httpRequest.js"></script>
<script type="text/javascript">
	function send(f) {
		let id = f.id.value.trim();
		let pwd = f.pwd.value.trim();
		
		if (id == '') {
			alert("아이디를 입력해주세요");
			return;
		}
		
		if (pwd == '') {
			alert("비밀번호를 입력해주세요");
			return;
		}
		
		let url = "login.do";
		let param = "id="+id"&pwd="+pwd;
		
		sendRequest(url, param, myCheck, "POST");
		
	}
	
	function myCheck() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let data = xhr.responseText;
			let json = (new Function('return' + data))();
			
			if (json[0].param == 'no_id' || json[0].param == 'no_pwd') {
				alert("아이디나 비밀번호가 잘 못되었습니다.");
			}else {
				alert("로그인 성공");
				location.href="main_content.jsp";
			}
			
			
		}
	}
</script>
</head>
<body>
	<form>
		<table border="1" align="center">
			<caption>:::로그인:::</caption>
			<tr>
				<th>아이디</th>
				<td><input name="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input name="pwd" type="password"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="로그인" onclick="send(this.form)"></td>
			</tr>
		</table>
	</form>
</body>
</html>