package com.hospital.registry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDAOImp implements PatientDAO {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		}
	}

	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql:/localhost:3306/hospitalregistry", "root", "Kmit123$");
	}
	
	private void closeConnection(Connection con) {
		if(con == null) {
			return;
		}
		try {
			con.close();
		} catch (SQLException sqle){
			System.out.println(sqle);
		}
	}
	
	@Override
	public boolean insert(Patient patient) {
		Connection con = null;
		Boolean bool = false;
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement("Insert into patient values (" + patient.getpatMobile() + ", '" + patient.getpatName() + "', '" + patient.getpatPassword() + "', '" + patient.getpatLocation() + "');");
			int res = stmt.executeUpdate();
			if(res != 0) {
				System.out.println("Patient "+ patient.getpatName() +" was registerd succesfully.");
				bool = true;
			}
			else {
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
	public void update(Patient patient) {
	}

	@Override
	public void delete(Patient patient) {
	}

	@Override
	public boolean validate(long patMobile, String patPassword) {
		Connection con = null;
		boolean validUser = false;
		
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement("Select patPassword from patient where patMobile = " + patMobile + ";");
			ResultSet rs = stmt.executeQuery();
			String actualPassword = "";
			while(rs.next()) {
				actualPassword =  rs.getString("patPassword");
			}
			if(patPassword.equals(actualPassword)) {
				validUser = true;
			}
			else {
				validUser = false;
			}
			
		} catch(SQLException sqle) {
			System.out.println(sqle);
		} finally {
			closeConnection(con);
		}
		return validUser;
	}

	@Override
	public Patient findPatient(long patMobile) {
		Connection con = null;
		Patient resPatient = new Patient();
		
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement("Select patMobile,patName,patLocation from patient where patMobile = " + patMobile);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				resPatient.setpatLocation(rs.getString("patLocation"));
				resPatient.setpatMobile(rs.getLong("patMobile"));
				resPatient.setpatName(rs.getString("patName"));
			}
		} catch(SQLException sqle) {
			System.out.println(sqle);
		} finally {
			closeConnection(con);
		}
		
		return resPatient;
	}

}
