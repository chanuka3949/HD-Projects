<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.action.AppointmentAction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
    <%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Appointment</title>
<sj:head jqueryui="true"/>
</head>
<body>
<s:url action="newPatient" var="Add Patient"></s:url>
<s:a href="%{Add Patient}">Add New Patient</s:a>
<br/>
<s:url action="homePage" var="home"></s:url>
<s:a href="%{home}">Home Page</s:a>
<br/>

	<s:form action="getDoctorDetails">	
		<sj:autocompleter name="patientID" list="patientList" label="Patient Name" selectBox="true" selectBoxIcon="true" requiredLabel="true"/>
 		<sj:autocompleter list="doctorList" label="Doctor Name" name="doctorID" selectBox="true" selectBoxIcon="true" requiredLabel="true"/>
		<s:submit value="Add Appointment"></s:submit>
	</s:form>
</body>
</html>
