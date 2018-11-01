<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원정보수정</h2>
	<form action="${pageContext.request.contextPath}/UpdateMemberController" method="post">
	
		아이디 : 
		<input type="text" name="id" value="${member.getId()}" readonly><br>
		
		비밀번호 :
		<input type="password" name="pw" value="${member.getPw()}"><br>
		
		권한 :
		<select name="level">
		<!-- 셀렉트박스 오토셀렉트 -->
			<c:choose>
				<c:when test="${member.getLevel() == 1}">
					<option value="1" selected="selected">관리자</option>
					<option value="0">고객</option>
				</c:when>
				<c:otherwise>
					<option value="1">관리자</option>
					<option value="0" selected="selected">고객</option>
				</c:otherwise>
			</c:choose>
		</select><br>
		
		<input type="hidden" name="no" value="${member.getNo()}">
		<button type="submit">수정완료</button>
	</form>
</body>
</html>
