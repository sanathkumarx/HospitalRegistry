package com.hospital.registry;

import java.util.Set;

public interface AppointmentDAO {
	public boolean insert(Appointment appointment);
	public void update(Appointment appointment);
    public void delete(Appointment appointment);
	public Set<Appointment> findAppointmentByDocMobile(long docMobile);
	public Set<Appointment> findAppointmentByPatMobile(long patMobile);
	public Set<Appointment> findAppointmentByAppID(int appId);
	
}
