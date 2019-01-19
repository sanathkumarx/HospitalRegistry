package com.hospital.registry;

public class Patient {
	String patName;
	long patMobile;
	String patPassword;
	String patLocation;

	public long getpatMobile() {
		return patMobile;
	}
	public void setpatMobile(long patMobile) {
		this.patMobile = patMobile;
	}
	
	public String getpatName() {
		return patName;
	}
	public void setpatName(String patName) {
		this.patName = patName;
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

