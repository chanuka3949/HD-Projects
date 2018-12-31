package com.persistence;

public class Doctor {
	
	int id;
	String firstName;
	String lastName;
	int mobile;
	int medicalLicense;
	int appointmentCount;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public int getMedicalLicense() {
		return medicalLicense;
	}
	public void setMedicalLicense(int medicalLicense) {
		this.medicalLicense = medicalLicense;
	}
	public int getAppointmentCount() {
		return appointmentCount;
	}
	public void setAppointmentCount(int appointmentCount) {
		this.appointmentCount = appointmentCount;
	}
}
