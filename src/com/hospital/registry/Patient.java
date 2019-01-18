package com.hospital.registry;

public class Patient {
	int patId;
	String patName;
	long patMobile;
	String patPassword;
	String patLocation;
	
	public int getpatId() {
		return patId;
	}
	public void setpatId(int patId) {
		this.patId = patId;
	}
	
	public String getpatName() {
		return patName;
	}
	public void setpatName(String patName) {
		this.patName = patName;
	}
	
	public long getpatMobile() {
		return patMobile;
	}
	public void setpatMobile(long patMobile) {
		this.patMobile = patMobile;
	}
	
	public String getpatPassword() {
		return patPassword;
	}
	public void setpatPassword(String patPassword) {
		this.patPassword = patPassword;
	}
	
	public String getpatLocation() {
		return patLocation;
	}
	public void setpatLocation(String patLocation) {
		this.patLocation = patLocation;
	}
}

