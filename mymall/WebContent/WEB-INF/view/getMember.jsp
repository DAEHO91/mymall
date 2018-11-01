<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${member.getLevel()==0}
${member.getLevel()==1}
	<table border="1">
		<tr>
			<th>회원번호</th><th>아이디</th><th>권한</th>
		</tr>
		<tr>
			<th>${member.getNo()}</th>
			<th>${member.getId()}</th>
			<c:choose>
				<c:when test="${member.getLevel() == 1}">
					<th>관리자</th>
				</c:when>
				<c:otherwise>
					<th>고객</th>
				</c:otherwise>
			</c:choose>
		</tr>	
	</table>
</body>
</html>