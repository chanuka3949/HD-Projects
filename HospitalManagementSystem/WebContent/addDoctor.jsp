
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
    <%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<s:a href="Administrator.jsp"></s:a>
<body>
	<s:form action="RegisterDoctor">
		<s:textfield name="firstName" label="First Name"></s:textfield>
		<s:textfield name="lastName" label="Last Name"></s:textfield>
		<s:textfield name="mobile" label="Mobile No"></s:textfield>
		<s:textfield name="medicalLicense" label="Medical License No"></s:textfield>
		<sj:spinner name="appointmentCount" min="1" max="60" step="1" label="Preffered No of Appointments"></sj:spinner>
	<s:submit value="Add New Doctor"></s:submit>
	</s:form>
<br>

<s:url action="homePage" var="home"></s:url>
<s:a href="%{home}">Home Page</s:a>
</body>
</html>