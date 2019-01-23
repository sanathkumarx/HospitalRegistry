package com.hospital.registry;

public class Reports {
	int repId;
	int appId;
	long techMobile;
	int repStatus;
	String testName;
	String path;
	
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
	
	public long gettechMobile() {
		return techMobile;
	}
	public void settechMobile(long techMobile) {
		this.techMobile = techMobile;
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
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
