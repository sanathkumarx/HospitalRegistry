package com.hospital.registry;

public interface TechnicianDAO {
	public void insert(Technician technician);
	public void update(Technician technician);
    public void delete(Technician technician);
    public boolean validate(long techMobile, String techPassword);
	public Technician findTechnician(long patMobile);
	
}
