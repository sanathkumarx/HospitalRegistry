package com.hospital.registry;

public class Reports {
	int repId;
	int appId;
	int techId;
	int repStatus;
	String testName;
	
	public int getrepId() {
		return repId;
	}
	public void setrepId(int repId) {
		this.repId = repId;
	}
	
	public int getappId() {
		return appId;
	}
	public void setappId(int appId) {
		this.appId = appId;
	}
	
	public int gettechId() {
		return techId;
	}
	public void settechId(int techId) {
		this.techId = techId;
	}
	
	public int getrepStatus() {
		return repStatus;
	}
	public void setrepStatus(int repStatus) {
		this.repStatus = repStatus;
	}
	
	public String gettestName() {
		return testName;
	}
	public void settestName(String testName) {
		this.testName = testName;
	}
	
}
