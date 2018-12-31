<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
    <%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm Appointment</title>
<sj:head/>
</head>
<body>
<script>
	var timeStamps[];
	var selectedDate;
	function validateDates() {
		
	}
    var unAvailableDates = [];
    <s:iterator value="dates">
    	unAvailableDates.push("<s:property/>");
    </s:iterator>
    $(function(){           
        $.subscribe('beforeDatepickerShow', function(event, data) {
            var date = event.originalEvent.date;
            var dmy = date.getDate() + "-" 
                    + (date.getMonth()+1) + "-" 
                    + date.getFullYear();
            if ($.inArray(dmy, unAvailableDates) != -1) {
                event.originalEvent.returnValue = [false, "","unAvailable"];
            } else{
                event.originalEvent.returnValue = [true,"","Available"];
            }
    })});
</script>

<s:url action="homePage" var="home"></s:url>
<s:a href="%{home}">Home Page</s:a>

	<s:form action="addAppointment">
		<sj:datepicker label="Appointment Date" 
					name="appointmentDate" 
					minDate="0" 
					maxDate="%{maxDate}"
					onBeforeShowDayTopics="beforeDatepickerShow"
					/>			
		<s:submit value="Get Available Appointment Time"></s:submit>
	</s:form>
</body>
</html>