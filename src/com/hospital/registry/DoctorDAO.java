package com.hospital.registry;

import java.util.List;


public interface DoctorDAO {
	public void insert(Doctor doctor);
	public void update(Doctor doctor);
	public void delete(Doctor doctor);
	public boolean validate(long docMobile, String docPassword);
	public Doctor findDoctor(long docMobile);
	public List<Doctor> findDoctorsByFilters(String location, String availablity,String specialization);
	
}
