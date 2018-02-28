<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>upload file</title>
</head>
<body>
	<form action = "${pageContext.request.contextPath}/file/upload"
		  method = "POST"
		  enctype = "multipart/form-data" > 
		
		<input type = "file" name = "fileUpload"> <br>
		<input type = "submit" value = "upload file">	  
	</form>	
</body>
</html>