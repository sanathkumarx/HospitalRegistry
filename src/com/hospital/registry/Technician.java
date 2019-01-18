package com.hospital.registry;

public class Technician {
	int techId;
	String techName;
	long techMobile;
	String techPassword;
	
	public int gettechId() {
		return techId;
	}
	public void settechId(int techId) {
		this.techId = techId;
	}
	
	public String gettechName() {
		return techName;
	}
	public void settechName(String techName) {
		this.techName = techName;
	}
	
	public long gettechMobile() {
		return techMobile;
	}
	public void settechMobile(long techMobile) {
		this.techMobile = techMobile;
	}
	
	public String gettechPassword() {
		return techPassword;
	}
	public void settechPassword(String techPassword) {
		this.techPassword = techPassword;
	}
	
	
}
