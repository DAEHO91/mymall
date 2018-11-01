<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index</h1>
		<c:if test="${loginMember != null}">
		${loginMember.getId()}님 반갑습니다.
		<!-- 미구현 -->
		<a href="${pageContext.request.contextPath}/GetMember">내정보보기</a> 
		<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
	</c:if>
	<c:if test="${loginMember == null}">
		<a href="${pageContext.request.contextPath}/LoginController">로그인</a>
		<a href="${pageContext.request.contextPath}/AddMemberController">회원가입</a>
	</c:if>
</body>
</html>