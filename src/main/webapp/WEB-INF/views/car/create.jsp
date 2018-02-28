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
 <h1>Add car</h1>
 
 <form:form 
 		 action = "${pageContext.request.contextPath}/car/create"
		 method = "POST"
		 modelAttribute="carModel">
		 
	Car make<form:input path="make" />
	<form:errors path = "make" cssClass="error"/> <br>
	Car model <form:input path="model"/> 
	<form:errors path = "model" cssClass="error" />
		<br>	
	
	Car color <form:select path="color">
		<c:forEach items = "${colorList}" var = "color">
			<form:option value="${color}">${color.id}</form:option>
		</c:forEach>
	</form:select> <br>
 
 	<input type = "submit" value = "create new car" >
 </form:form>
 
</body>
</html>