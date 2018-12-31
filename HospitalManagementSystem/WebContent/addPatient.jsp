<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
<head>
<sj:head />
<meta charset="ISO-8859-1">
<title>Add New Patient</title>
</head>
<body>
<s:url action="homePage" var="home"></s:url>
<s:a href="%{home}">Back</s:a>
<br/>
<s:form action="RegisterPatient">
	<s:textfield name="firstName" label="First Name"></s:textfield>
	<s:textfield name="lastName" label="Last Name"></s:textfield>
	<s:select list="{'Male','Female'}" label="Gender" name="gender"></s:select>
	<sj:datepicker name="dob" changeMonth="true" changeYear="true" label="Date of Birth" yearRange="-200:+0"></sj:datepicker>
	<s:textarea name="address" label="Address"></s:textarea>
	<s:textfield name="telephone" label="Telephone"></s:textfield>
	<s:select name="bloodGroup" label="Blood Group" list="bloodType" headerKey="-1" headerValue="Blood Group"></s:select>
	<s:submit value="Register"></s:submit>
</s:form>
</body>
</html>