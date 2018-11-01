<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 목록</h1>
	<!-- 주문하기 item pk, session member pk,  -->
	<table border="1">
		<tr>
			<th>번호</th><th>이름</th><th>가격</th><th>주문</th>
		</tr>
		
		<c:forEach var="item" items="${list}">
		<tr>
			<td>${item.no}</td><!-- item.getNo() -->
			<td>${item.name}</td>
			<td>${item.price}</td>
			<td><a href="${pageContext.request.contextPath}/Order">주문</a></td>
		</tr>
		</c:forEach>
		
		
	</table>
	<div>
		<!-- ${pageContext.request.contextPath}/itemList.jsp?currentPage=? -->
	</div>
</body>
</html>