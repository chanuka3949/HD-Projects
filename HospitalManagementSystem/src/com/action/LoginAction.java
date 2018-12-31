package com.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.persistence.Login;
import com.persistence.LoginManager;

public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String userType;
	private Map<String, Object> session;
	
	public String execute() {
		Login info = new Login();
		info.setUsername(username);
		info.setPassword(password);
		String type = LoginManager.CheckLogin(info);
		if(type.equals("Admin")) {
			session.put("loginType", "Admin");
			session.put("loginStatus", true);
			addActionMessage("Admin");
			return "admin";
		}
		else if(type.equals("Receptionist")) {
			session.put("loginType", "Receptionist");
			session.put("loginStatus", true);
			addActionMessage("Receptionist");
			return "receptionist";
		}
		else {
			addActionError("Incorrect User Credentials");
			return INPUT;
		}		
	}
	
	public String checkLogin() {
		if(session.get("loginStatus").equals(true)) {
			if(session.get("loginType").equals("Admin"))
				return "admin";
			else if(session.get("loginType").equals("Receptionist"))
				return "receptionist";
		}
		return LOGIN;
	}
	
	public String logout() {
		session.remove("loginType");
		session.remove("loginStatus");
		return SUCCESS;
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
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
}
