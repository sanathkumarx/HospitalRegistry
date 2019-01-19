package com.hospital.registry;

import java.util.List;

public interface AppointmentDAO {
	public void insert(Appointment appointment);
	public void update(Appointment appointment);
    public void delete(Appointment appointment);
	public List<Appointment> findAppointmentByDocMobile(long docMobile);
	public List<Appointment> findAppointmentByPatMobile(long patMobile);
	public List<Appointment> findAppointmentByAppID(int appId);
	
}
