package com.hospital.registry;

import java.util.Set;


public interface DoctorDAO {
	public boolean insert(Doctor doctor);
	public void update(Doctor doctor);
	public void delete(Doctor doctor);
	public boolean validate(long docMobile, String docPassword);
	public Doctor findDoctor(long docMobile);
	public Set<Doctor> findDoctorsByFilters(String location, String availablity,String specialization);
	
}
