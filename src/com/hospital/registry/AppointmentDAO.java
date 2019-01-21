package com.hospital.registry;

import java.util.Set;

public interface AppointmentDAO {
	public boolean insert(Appointment appointment);
	public void update(String appID);
    public void delete(Appointment appointment);
	public Set<Appointment> findAppointmentByDocMobile(long docMobile);
	public Set<Appointment> findAppointmentByPatMobile(long patMobile);
	public Set<Appointment> findAppointmentByAppID(int appId);
	
}
