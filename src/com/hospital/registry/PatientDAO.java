package com.hospital.registry;

public interface PatientDAO {
	public void insert(Patient patient);
	public void update(Patient patient);
    public void delete(Patient patient);
    public boolean validate(long patMobile, String patPassword);
	public Patient findPatient(long patMobile);
	
}
