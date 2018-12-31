package com.action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.persistence.Appointment;
import com.persistence.AppointmentManager;
import com.persistence.DoctorManager;
import com.persistence.PatientManager;

public class AppointmentAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int doctorID;
	int patientID;
	String appointmentDate;
	final static String maxDate = "15";
	List<String> dates;
	HashMap<Integer, String> doctorList;
	HashMap<Integer, String> patientList;
	int appointmentNo;
	final static String today = LocalDate.now().toString();
	Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> session) {		
		this.session = session;
	}
	
	@Override
	public String execute() throws Exception {
		Appointment appointment = new Appointment();
		appointment.setAppointmentDate((String)session.get("AppointmentDate"));
		appointment.setDoctorID((Integer)session.get("DoctorID"));
		appointment.setPatientID((Integer)session.get("PatientID"));
		appointment.setAppointmentNo((Integer)session.get("AppointmentNo"));	
		boolean status = AppointmentManager.addAppointment(appointment);
		if(status == false)
			addActionError("Sorry, we couldn't place the appointment. Please try again later");
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		if(getDoctorID() == -1)
			addFieldError("doctorID", "Please Select a Doctor");
		super.validate();
	}

	public String getDoctorDates() {
		session.put("DoctorID",doctorID);
		session.put("PatientID",patientID);
		String doctorName = DoctorManager.getDoctorName(doctorID);
		String patientName = PatientManager.getPatientName(patientID);
		session.put("DoctorName", doctorName);
		session.put("PatientName", patientName);
		dates = DoctorManager.getAvailableDates((Integer)session.get("DoctorID"));
		return SUCCESS;
	}
	
	public String getLastAppointment() {
		doctorID = (Integer)session.get("DoctorID");
		String date = LocalDate.parse(appointmentDate, DateTimeFormatter.ofPattern("MM/dd/yyyy")).toString();
		int lastNo = AppointmentManager.getLastAppointment(doctorID,date );

		if(lastNo == 0) {
			appointmentNo = 1;
			session.put("AppointmentNo", appointmentNo);
			session.put("AppointmentDate", date);
			addActionMessage("Appointment No: "+appointmentNo);
			return SUCCESS;
		}
		else if(lastNo == 40) {
			addActionError("All Appointments have been booked for this date("+appointmentDate+")");
			return ERROR;
		}
		else {
			appointmentNo = (int) (lastNo + 1);
			session.put("AppointmentNo", appointmentNo);
			session.put("AppointmentDate", date);
			addActionMessage("Appointment No: "+appointmentNo);
			return SUCCESS;
		}
	}
	public String autoCompleter() {
		doctorList = DoctorManager.getDoctorList();
		patientList = PatientManager.getPatientList();
		return NONE;
	}
	public HashMap<Integer, String> getPatientList() {
		return patientList;
	}

	public void setPatientList(HashMap<Integer, String> patientList) {
		this.patientList = patientList;
	}

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public List<String> getDates() {
		return dates;
	}

	public void setDates(List<String> dates) {
		this.dates = dates;
	}

	public HashMap<Integer, String> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(HashMap<Integer, String> doctorList) {
		this.doctorList = doctorList;
	}

	public int getAppointmentNo() {
		return appointmentNo;
	}

	public void setAppointmentNo(int appointmentNo) {
		this.appointmentNo = appointmentNo;
	}

	public static String getMaxdate() {
		return maxDate;
	}

	public static String getToday() {
		return today;
	}

	
}
