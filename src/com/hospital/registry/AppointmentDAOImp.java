package com.hospital.registry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

public class AppointmentDAOImp implements AppointmentDAO {

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException cnfe){
			System.out.println(cnfe);
		}
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalregistry", "root", "Kmit123$");
	}
	
	private void closeConnection(Connection con) {
		if(con == null) {
			return;
		}
		try {
			con.close();
		} catch(SQLException sqle) {
			System.out.println(sqle);
		}
	}

	@Override
	public boolean insert(Appointment appointment) {
		Connection con = null;
		boolean bool = false;
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement("Insert into appointment values (" + "NULL" + ", " + appointment.getpatMobile() + ", " + appointment.getdocMobile() + ", '" + appointment.getappDate() + "', " + appointment.getappStatus() + ");");
			int res = stmt.executeUpdate();
			if(res != 0) {
				bool = true;
			}
			else{
				bool = false;
			}
		} catch(SQLException sqle) {
			System.out.println(sqle);
		} finally {
			closeConnection(con);
		}
		return bool;
	}

	@Override
	public void update(String appID) {
		Connection con = null;
		
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement("Update appointment set appStatus=1 where appID = "+appID+";");
			stmt.executeUpdate();

		} catch(SQLException sqle) {
			System.out.println(sqle);
		} finally {
			closeConnection(con);
		}
	}

	@Override
	public void delete(Appointment appointment) {
	}

	@Override
	public Set<Appointment> findAppointmentByDocMobile(long docMobile) {
		Set<Appointment> appointments = new LinkedHashSet<Appointment>();
		Connection con = null;
		
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from appointment where docMobile = " + docMobile+";");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Appointment appointment = new Appointment();
				appointment.setappDate(rs.getDate("appDate")); 
				appointment.setappId(rs.getInt("appID"));
				appointment.setpatMobile(rs.getLong("patMobile"));
				appointment.setdocMobile(rs.getLong("docMobile"));
				appointment.setappStatus(rs.getInt("appStatus"));
				appointments.add(appointment);
			}
		} catch(SQLException sqle) {
			System.out.println(sqle);
		} finally {
			closeConnection(con);
		}
		
		return appointments;
	}

	@Override
	public Set<Appointment> findAppointmentByPatMobile(long patMobile) {
		Set<Appointment> appointments = new LinkedHashSet<Appointment>();
		Connection con = null;
		
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from appointment where patMobile = " + patMobile+";");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Appointment appointment = new Appointment();
				appointment.setappDate(rs.getDate("appDate")); 
				appointment.setappId(rs.getInt("appID"));
				appointment.setpatMobile(rs.getLong("patMobile"));
				appointment.setdocMobile(rs.getLong("docMobile"));
				appointment.setappStatus(rs.getInt("appStatus"));
				appointments.add(appointment);
			}
		} catch(SQLException sqle) {
			System.out.println(sqle);
		} finally {
			closeConnection(con);
		}
		
		return appointments;
	}

	@Override
	public Set<Appointment> findAppointmentByAppID(int appId) {
		Set<Appointment> appointments = new LinkedHashSet<Appointment>();
		Connection con = null;
		
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from appointment where appID = " + appId +";");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Appointment appointment = new Appointment();
				appointment.setappDate(rs.getDate("appDate")); 
				appointment.setappId(rs.getInt("appID"));
				appointment.setpatMobile(rs.getLong("patMobile"));
				appointment.setdocMobile(rs.getLong("docMobile"));
				appointment.setappStatus(rs.getInt("appStatus"));
				appointments.add(appointment);
			}
		} catch(SQLException sqle) {
			System.out.println(sqle);
		} finally {
			closeConnection(con);
		}
		
		return appointments;
	}

}
