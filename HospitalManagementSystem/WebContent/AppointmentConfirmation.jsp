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
<s:url action="homePage" var="home"></s:url>
<s:a href="%{home}">Home Page</s:a>
<br/>
<s:form action="setAppointment">
	<s:textfield label="Patient Name" value="%{#session.PatientName}"></s:textfield>
	<s:textfield label="Doctor Name" value="%{#session.DoctorName}"></s:textfield>
	<s:textfield label="Appointment No" value="%{#session.AppointmentNo}"></s:textfield>
	<s:textfield label="Appointment Date" value="%{#session.AppointmentDate}"></s:textfield>
	<s:submit value="Set Appointment"></s:submit>
</s:form>
<s:actionerror/>
<br/>

</body>
</html>