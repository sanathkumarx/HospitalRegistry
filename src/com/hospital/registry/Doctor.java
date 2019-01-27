package com.hospital.registry;


public class Doctor{
	String docName;
	long docMobile;
	String docPassword;
	String docLocation;
	String docSpecialization;
	int docDays;

	public long getdocMobile() {
		return docMobile;
	}
	
	public void setdocMobile(long docMobile) {
		this.docMobile = docMobile;
	}
	
	public String getdocName() {
		return docName;
	}
	
	public void setdocName(String docName) {
		this.docName = docName;
	}

	public String getdocPassword() {
		return docPassword;
	}
	
	public void setdocPassword(String docPassword) {
		this.docPassword = docPassword;
	}
	public String getdocLocation() {
		return docLocation;
	}
	
	public void setdocLocation(String docLocation) {
		this.docLocation = docLocation;
	}
	public String getdocSpecialization() {
		return docSpecialization;
	}
	
	public void setdocSpecialization(String docSpecialization) {
		this.docSpecialization = docSpecialization;
	}
	public int getdocDays() {
		return docDays;
	}
	
	public void setdocDays(int docDays) {
		this.docDays = docDays;
	}
	@Override
	public boolean equals(Object d) {
		Doctor temp = (Doctor)d;
		return temp.getdocMobile() == this.getdocMobile();
	}
	
	@Override
    public int hashCode() {
        return Long.hashCode(docMobile);
    }
	
}