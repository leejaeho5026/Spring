<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>result2.jsp</h2>
	<h3>ByType방식</h3>
	<h3>request Scope에서 data 가져옴</h3>
	<h3>applicationBean3.data5 : ${requestScope.applicationBean3.data5 }</h3>
	<h3>applicationBean3.data6 : ${requestScope.applicationBean3.data6 }</h3>
	
	<h3>ByName방식</h3>
	<h3>request Scope에서 data 가져옴</h3>
	<h3>applicationBean4.data7 : ${requestScope.applicationBean4.data7 }</h3>
	<h3>applicationBean4.data8 : ${requestScope.applicationBean4.data8 }</h3>
</body>
</html>