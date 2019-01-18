package com.hospital.registry;

import java.sql.Date;

public class Appointment {
	int appId;
	int patId;
	int docId;
	Date appDate;
	int appStatus;
	
	public int getappId() {
		return appId;
	}
	public void setappId(int appId) {
		this.appId = appId;
	}
	
	public int getpatId() {
		return patId;
	}
	public void setpatId(int patId) {
		this.patId = patId;
	}
	
	public int getdocId() {
		return docId;
	}
	public void setdocId(int docId) {
		this.docId = docId;
	}
	
	public Date getappDate() {
		return appDate;
	}
	public void setappDate(Date appDate) {
		this.appDate = appDate;
	}
	
	public int getappStatus() {
		return appStatus;
	}
	public void setappStatus(int appStatus) {
		this.appStatus = appStatus;
	}
	
	
}
