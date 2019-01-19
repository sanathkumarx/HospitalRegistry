package com.hospital.registry;

import java.util.List;

public interface PatientDAO {
	public void insert(Patient patient);
	public void update(Patient patient);
    public void delete(Patient patient);
    public boolean validate(long patMobile, String patPassword);
	List<Patient> findPatient(long patMobile);
	
}
