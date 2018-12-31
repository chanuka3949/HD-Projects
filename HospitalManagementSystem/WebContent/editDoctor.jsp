<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="/struts-tags" prefix="s"%>
    <%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<sj:head jqueryui="true"/>
<meta charset="ISO-8859-1">
<title>Edit Doctor Details</title>
</head>
<body>
<s:url action="homePage" var="home"></s:url>
<s:a href="%{home}">Home Page</s:a>
<br/>
	<s:form action="selectDoctor">
		<sj:autocompleter list="doctorList" selectBox="true" selectBoxIcon="true" name="id" label="Doctor Name"></sj:autocompleter>
		<s:submit value="Get Details"></s:submit>
	</s:form>
	<br>
	<s:form action="editDoctor">
		<s:hidden name="id" value="%{id}"></s:hidden>
		<sj:textfield name="firstName" label="First Name" value="%{doc.get(0).getFirstName()}" requiredLabel="true"></sj:textfield>
		<s:textfield name="lastName" label="Last Name" value="%{doc.get(0).getLastName()}" requiredLabel="true"></s:textfield>
		<s:textfield name="mobile" label="Mobile No" value="%{doc.get(0).getMobile()}" requiredLabel="true"></s:textfield>
		<s:textfield name="medicalLicense" label="Medical License No" value="%{doc.get(0).getMedicalLicense()}" requiredLabel="true"></s:textfield>
		<sj:spinner name="appointmentCount" min="1" max="60" step="1" requiredLabel="true" label="Preffered No of Appointments" value="%{doc.get(0).getAppointmentCount()}"></sj:spinner>
	<s:submit value="Edit Doctor Details"></s:submit>
	</s:form>
	<s:actionmessage/>
	<s:actionerror/>
</body>
</html>