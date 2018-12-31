<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:url action="newPatient" var="Add Patient"></s:url>
<s:a href="%{Add Patient}">Add New Patient</s:a>
<br/>
<s:url action="patientList" var="editPatient"></s:url>
<s:a href="%{editPatient}">Edit Patient</s:a>
<br/>
<s:url action="getDoctors.action" var="Add Appointment"></s:url>
<s:a href="%{Add Appointment}">Add New Appointment</s:a>
<br/>
<s:form action="Logout"><s:submit value="Logout"></s:submit></s:form>
</body>
</html>