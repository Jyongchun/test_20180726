<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>查看订单</h1>

<table border="1px" cellpadding="0" cellspacing="2px">
	<tr>
		<th>订单id</th>
		<th>订单编号</th>
		<th>用户id</th>
		<th>订单创建时间</th>
		<th>订单总支付价格</th>
		<th>操作订单</th>
	</tr>
	<c:forEach items="${orders}" var="order">
	<tr>
		<td>${order.id}</td>
		<td>${order.order_no}</td>
		<td>${order.user_id }</td>
		<td>${order.create_time}</td>
		<td>${order.payment }</td>
		<td><a href="#">删除</a></td>
		<td><a href="#">修改</a></td>
		<td><a href="OrderServlet?operation=3&order_no=${order.order_no}">查看订单明细</a></td>
	</tr>
	</c:forEach>

</table>



 
</body>
</html>