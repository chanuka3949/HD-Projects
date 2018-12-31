package com.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.opensymphony.xwork2.ActionSupport;
import com.persistence.Doctor;
import com.persistence.DoctorManager;

public class DoctorAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String firstName;
	String lastName;
	int mobile;
	int medicalLicense;
	int appointmentCount;
	List<Doctor> doc;
	HashMap<Integer, String> doctorList;
	
	@Override
	public String execute() throws Exception {
		Doctor doctor = new Doctor();
		doctor.setFirstName(firstName);
		doctor.setLastName(lastName);
		doctor.setMedicalLicense(medicalLicense);
		doctor.setMobile(mobile);
		doctor.setAppointmentCount(appointmentCount);
		DoctorManager.addDoctor(doctor);
		return SUCCESS;
	}
	
	public DoctorAction() {
		doctorList = DoctorManager.getDoctorList();
	}
	
	public String doctorDetails() {
		doc = DoctorManager.selectDoctor(id);
		return NONE;
	}
	
	public String autoCompleter() {
		return NONE;
	}
	
	public String editDoctorDetails() {
		Doctor doctor = new Doctor();
		doctor.setId(id);
		doctor.setFirstName(firstName);
		doctor.setLastName(lastName);
		doctor.setMedicalLicense(medicalLicense);
		doctor.setMobile(mobile);
		doctor.setAppointmentCount(appointmentCount);
		boolean result = DoctorManager.updateDoctorDetails(doctor);
		if(result == true)
			return SUCCESS;
		else
			return INPUT;
	}
	
	
	public HashMap<Integer, String> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(HashMap<Integer, String> doctorList) {
		this.doctorList = doctorList;
	}

	public int getAppointmentCount() {
		return appointmentCount;
	}

	public void setAppointmentCount(int appointmentCount) {
		this.appointmentCount = appointmentCount;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public List<Doctor> getDoc() {
		return doc;
	}

	public void setDoc(List<Doctor> doc) {
		this.doc = doc;
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
	
	
}
