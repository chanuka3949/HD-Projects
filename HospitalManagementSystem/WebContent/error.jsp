<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Something went wrong, Please try again in a few seconds.
<br/>
<s:url action="homePage" var="home"></s:url>
<s:a href="%{home}">Home Page</s:a>
</body>
</html>