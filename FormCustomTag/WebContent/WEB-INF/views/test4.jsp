<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>test4.jsp</h2>
		<form:form modelAttribute="bean" action= "result">
			이름 : <form:input  path="userName"/><br> 
			아이디 : <form:input  path="userId"/><br> 
			비밀번호 : <form:password  path="userPw" showPassword="true"/><br> 
			우편번호 : <form:input  path="userPostcode"/><br> 
			주소1 : <form:input  path="userAddress1"/><br> 
			주소2 : <form:input  path="userAddress1"/><br> 
		</form:form>		
</body>
</html>