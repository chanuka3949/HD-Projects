package com.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.persistence.Patient;
import com.persistence.PatientManager;

public class PatientAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String firstName;
	String lastName;
	Date dob;
	String gender;
	String address;
	int telephone;
	String bloodGroup;
	List<String> bloodType;
	HashMap<Integer, String> patientList;
	List<Patient> p;
	
	public PatientAction() {
		bloodType = new ArrayList<String>();
		bloodType.add("A Positive");
		bloodType.add("A Negative");
		bloodType.add("AB Positive");
		bloodType.add("AB Negative");
		bloodType.add("O Positive");
		bloodType.add("O Negative");
		bloodType.add("B Positive");
		bloodType.add("B Negative");
		patientList = PatientManager.getPatientList();
	}
	
	@Override
	public String execute() throws Exception {
		Patient patient = new Patient();
		patient.setFirstName(firstName);
		patient.setLastName(lastName);
		patient.setGender(gender);
		patient.setDob(dob);
		patient.setAddress(address);
		patient.setTelephone(telephone);
		patient.setBloodGroup(bloodGroup);
		PatientManager.addPatient(patient);
		return SUCCESS;
	}

	public String patientDetails() {
		p = PatientManager.selectPatient(id);
		return NONE;
	}
	
	public String editPatientDetails() {
		Patient patient = new Patient();
		patient.setId(id);
		patient.setFirstName(firstName);
		patient.setLastName(lastName);
		patient.setGender(gender);
		patient.setAddress(address);
		patient.setTelephone(telephone);
		patient.setBloodGroup(bloodGroup);
		boolean result = PatientManager.updatePatientDetails(patient);
		if(result == true)
			return SUCCESS;
		else return INPUT;
	}
	
	public String autoCompleter() {
		return NONE;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HashMap<Integer, String> getPatientList() {
		return patientList;
	}

	public void setPatientList(HashMap<Integer, String> patientList) {
		this.patientList = patientList;
	}

	public List<Patient> getP() {
		return p;
	}

	public void setP(List<Patient> p) {
		this.p = p;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public List<String> getBloodType() {
		return bloodType;
	}

	public void setBloodType(List<String> bloodType) {
		this.bloodType = bloodType;
	}
	
}
