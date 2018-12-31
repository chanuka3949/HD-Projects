<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administrator</title>

</head>
<body>
<s:a href="addDoctor.jsp">Add New Doctor</s:a><br/>

<s:url var="editDoctor" action="doctorList"></s:url>
<s:a href="%{editDoctor}">Edit Doctor Details</s:a><br/>

<s:a href="addEmployee.jsp">Add New Employee</s:a><br/>
<s:form action="Logout"><s:submit value="Logout"></s:submit></s:form>

</body>
</html>