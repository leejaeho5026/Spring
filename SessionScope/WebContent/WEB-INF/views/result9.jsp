<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>result9.jsp</h2>
	<h3>session scope에 sessionBean1(TestBean1)에서 객체를 가져옴</h3>
	<h3>session scope에 sessionBean2(TestBean2)에서 객체를 가져옴</h3>
	<h3>sessionBean1.data1 : ${sessionScope.sessionBean1.data1 }</h3>
	<h3>sessionBean1.data2 : ${sessionScope.sessionBean1.data2 }</h3>
	<h3>sessionBean2.data3 : ${sessionScope.sessionBean2.data3 }</h3>
	<h3>sessionBean2.data4 : ${sessionScope.sessionBean2.data4 }</h3>
	
</body>
</html>