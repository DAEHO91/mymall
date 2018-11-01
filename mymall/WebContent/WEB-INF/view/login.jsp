<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 폼</h1>
	<a href="${pageContext.request.contextPath}/addMember">회원가입</a>
	<form action="${pageContext.request.contextPath}/login" method="post">
		아이디
		<input type="text" name="id"><br>
		비밀번호
		<input type="password" name="pw"><br>
		<button type="submit">login</button>
	</form>
</body>
</html>