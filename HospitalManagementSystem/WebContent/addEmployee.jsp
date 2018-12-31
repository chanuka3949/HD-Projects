<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Employee</title>
</head>
<body>
<s:url action="homePage" var="home"></s:url>
<s:a href="%{home}">Back</s:a>
<br/>
	<s:form action="registerEmployee">
		<s:textfield name="username" label="Username"></s:textfield>
		<s:password name="password" label="Password"></s:password>
		<s:password name="cpassword" label="Re-enter Password"></s:password>
		<s:submit value="Add Employee"></s:submit>
	</s:form>
	<s:actionmessage/>
	<s:actionerror/>
</body>
</html>