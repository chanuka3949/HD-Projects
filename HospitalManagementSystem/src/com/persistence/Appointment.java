package com.persistence;

import java.io.Serializable;
import java.time.LocalDate;

public class Appointment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5459383590567628288L;
	int doctorID;
	int patientID;
	String appointmentDate;
	int appointmentNo;
	
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
	public int getAppointmentNo() {
		return appointmentNo;
	}
	public void setAppointmentNo(int appointmentNo) {
		this.appointmentNo = appointmentNo;
	}
	
	

}
