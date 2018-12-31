package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.persistence.Login;
import com.persistence.LoginManager;

public class AdminAction extends ActionSupport {
	
	String username;
	String password;
	String cpassword;
	
	
	@Override
	public String execute() throws Exception {
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);
		login.setUserType("Receptionist");
		LoginManager.addEmployee(login);
		return SUCCESS;
	}
	@Override
	public void validate() {
		if(username.trim().length()==0)
			addFieldError("username", "Username cannot be empty");
		if(password.trim().length()==0)
			addFieldError("username", "Username cannot only contain spaces");
		
		if(!password.equals(cpassword))
			addFieldError("cpassword", "Password does not match");
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	
	
}
