<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>

	<h1>주문 리스트</h1>
	<table border="1">
		<tr>
			<th>주문번호</th><th>주문자</th><th>주문날짜</th><th>상품코드</th><th>상품명</th><th>가격</th>
		</tr>
		<!-- list 객체를 item이름으로 사용.. forEach는 자동증가 -->
		<c:forEach var="orderList" items="${orderList}" varStatus="status">
		<tr>
			<td>${orderList.get("no")}</td><!-- item.getNo() -->
			<td>${orderList.get("id")}</td>
			<td>${orderList.get("order_date")}</td>
			<td>${orderList.get("item_no")}</td>
			<td>${orderList.get("name")}</td>
			<td>${orderList.get("price")}</td>
		</tr>
		</c:forEach>	
	</table>
	<div>
		<!-- ${pageContext.request.contextPath}/itemList.jsp?currentPage=? -->
	</div>
</body>
</html>