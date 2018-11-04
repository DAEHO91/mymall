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
		<c:set var="num" value="0"/>
		<!-- list 객체를 item이름으로 사용.. forEach는 자동증가 -->
		<c:forEach var="item" items="${itemlist}" varStatus="status">
		<tr>
			<td>${item.get("no")}</td><!-- item.getNo() -->
			<td>${item.get("name")}</td>
			<td>${item.get("price")}</td>
			<td><a href="${pageContext.request.contextPath}/OrderController?itemNo=${item.get("no")}">주문</a></td>
		</tr>
		</c:forEach>	
	</table>
	<div>
		<!-- ${pageContext.request.contextPath}/itemList.jsp?currentPage=? -->
	</div>
</body>
</html>