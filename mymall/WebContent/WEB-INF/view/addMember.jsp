<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>addMember Form</h2>
	<form action="${pageContext.request.contextPath}/AddMemberController" method="post">
		아이디 : 
		<input type="text" name="id"><br>
		비밀번호 :
		<input type="password" name="pw"><br>
		권한 :
		<select name="level">
			<option value="1">관리자</option>
			<option value="0">고객</option>
		</select><br>
		<button type="submit">가입</button>
	</form>
</body>
</html>