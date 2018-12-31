<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<sj:head jqueryui="true"/>
<meta charset="ISO-8859-1">
<title>Edit Patient Details</title>
</head>
<body>
<s:url action="homePage" var="home"></s:url>
<s:a href="%{home}">Home Page</s:a>
<br/>
	<s:form action="selectPatient">
		<sj:autocompleter list="patientList" selectBox="true" selectBoxIcon="true" name="id" label="Patient Name"></sj:autocompleter>
		<s:submit value="Get Details"></s:submit>
	</s:form>
	<br>
	<s:form action="editPatient">
		<s:hidden name="id" value="%{id}"></s:hidden>
	<s:textfield name="firstName" label="First Name" value="%{p.get(0).getFirstName()}"></s:textfield>
	<s:textfield name="lastName" label="Last Name" value="%{p.get(0).getLastName()}"></s:textfield>
	<s:select list="{'Male','Female'}" name="gender" label="Gender" value="%{p.get(0).getGender()}"></s:select>
	<s:textarea name="address" label="Address" value="%{p.get(0).getAddress()}"></s:textarea>
	<s:textfield name="telephone" label="Telephone" value="%{p.get(0).getTelephone()}"></s:textfield>
	<s:select value="%{p.get(0).getBloodGroup()}" name="bloodGroup" label="Blood Group" list="bloodType" headerKey="-1" headerValue="Blood Group"></s:select>
	<s:submit value="Edit Patient Details"></s:submit>
	</s:form>
	<s:actionmessage/>
	<s:actionerror/>
</body>
</html>