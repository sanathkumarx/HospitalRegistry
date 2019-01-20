package com.hospital.registry;

public interface PatientDAO {
	public boolean insert(Patient patient);
	public void update(Patient patient);
    public void delete(Patient patient);
    public boolean validate(long patMobile, String patPassword);
	public Patient findPatient(long patMobile);
	
}
