package com.hospital.registry;

import java.sql.Date;

public class Appointment {
	int appId;
	long patMobile;
	long docMobile;
	Date appDate;
	int appStatus;
	
	public int getappId() {
		return appId;
	}
	public void setappId(int appId) {
		this.appId = appId;
	}
	
	public long getpatMobile() {
		return patMobile;
	}
	public void setpatMobile(long patMobile) {
		this.patMobile = patMobile;
	}
	
	public long getdocMobile() {
		return docMobile;
	}
	public void setdocMobile(long docMobile) {
		this.docMobile = docMobile;
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
