<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style >
.error {
color:red;
}
</style>
</head>
<body>
 <h1>Login</h1>
 
 <form:errors path="user" />
 <form:form 
 		 action = "${pageContext.request.contextPath}/user/login"
		 method = "POST"
		 modelAttribute="userModel">
		 
	user login<form:input path="login" />
	<br>
	user password <form:password path="password"/> 
		<br> 
 	<input type = "submit" value = "create new car" >
 </form:form>
 
</body>
</html>