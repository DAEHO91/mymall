<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	회원삭제확인
<h3>탈퇴하시겠습니까?</h3>
탈퇴를 위해 비밀번호를 입력해주세요
	<form action="${pageContext.request.contextPath}/DeleteMemberController" method="post">
		<input type="password" name="pw">
		<button type="submit">회원탈퇴</button>
	</form>
</body>
</html>