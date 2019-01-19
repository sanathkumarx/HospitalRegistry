package com.hospital.registry;

public class Technician {
	String techName;
	long techMobile;
	String techPassword;
	
	public long gettechMobile() {
		return techMobile;
	}
	public void settechMobile(long techMobile) {
		this.techMobile = techMobile;
	}

	public String gettechName() {
		return techName;
	}
	public void settechName(String techName) {
		this.techName = techName;
	}

	
	public String gettechPassword() {
		return techPassword;
	}
	public void settechPassword(String techPassword) {
		this.techPassword = techPassword;
	}
	
	
}
