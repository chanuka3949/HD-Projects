<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- <meta http-equiv="refresh" content="0;URL=autoCompleter.action" />   -->
<title>Insert title here</title>
</head>
<body>
	<s:form action="Login">
		<s:textfield name="username" label="Username"></s:textfield>
		<s:password name="password" label="Password"></s:password>
		<s:submit name="btnLogin" value="Login"></s:submit>
	</s:form>
	<s:actionerror/>
	<s:actionmessage/>
</body>
</html>