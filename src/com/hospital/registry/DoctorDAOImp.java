package com.hospital.registry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

public class DoctorDAOImp implements DoctorDAO {

	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException cnfe){
			System.out.println(cnfe);
		}
	}

	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalregistry", "root", "Kmit123$");
	}

	private void closeConnection(Connection con){
		if(con == null){
			return;
		}
		try{
			con.close();
		} catch(SQLException sqle){
			sqle.printStackTrace();
		}
	}

	@Override
	public boolean insert(Doctor doctor) {
		Connection con = null;
		boolean bool = false;
		try{
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement(
				"insert into doctor values (" + doctor.getdocMobile() +", '" + doctor.getdocName() + "', '" + doctor.getdocPassword() + "', '" + doctor.getdocLocation() + "', '" + doctor.getdocSpecialization() + "', " + doctor.getdocDays()+";");
			int res = stmt.executeUpdate();
			if(res != 0){
				System.out.println("Doctor "+ doctor.getdocName() +" was registerd succesfully.");
				bool = true;
			}
			else {
				bool = false;
			}
		} catch(SQLException sqle){
			System.out.println(sqle);
		} finally {
			closeConnection(con);
		}
		return bool;
	}

	@Override
	public void update(Doctor doctor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Doctor doctor) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean validate(long docMobile, String docPassword) {
		boolean validUser = false;
		Connection con = null;
		try{
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement(
				"Select docPassword from doctor where docMobile = " + docMobile+";");
			System.out.println("Select docPassword from doctor where docMobile = " + docMobile + ";");
			ResultSet rs = stmt.executeQuery();
			String actualPassword = "";
			while(rs.next()) {
				actualPassword = rs.getString("docPassword");
			}
			if(docPassword.equals(actualPassword)){
				validUser = true;
			}else{
				validUser = false;
			}
		} catch(SQLException sqle){
			System.out.println(sqle);
		} finally{
			closeConnection(con);
		}
		return validUser;
	}

	@Override
	public Doctor findDoctor(long docMobile) {
		Connection con = null;
		Doctor resDoctor = new Doctor();
		try{
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement(
				"Select docName,docMobile,docLocation,docSpecialization from doctor where docMobile = " + docMobile);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				resDoctor.setdocName(rs.getString("docName"));
				resDoctor.setdocMobile(rs.getLong("docMobile"));
				resDoctor.setdocLocation((String)rs.getString("docLocation"));
				resDoctor.setdocSpecialization((String)rs.getString("docSpecialization"));
				}
			
		} catch(SQLException sqle){
			System.out.println(sqle);
		} finally{
			closeConnection(con);
		}
		return resDoctor;
	}

	@Override
	public Set<Doctor> findDoctorsByFilters(String location, String availablity, String specialization) {
		Set<Doctor> doctorsByLoc = new LinkedHashSet<>();
		Set<Doctor> doctorsByAvail = new LinkedHashSet<>();
		Set<Doctor> doctorsBySpec= new LinkedHashSet<>();
		Connection con = null;
		String sqlLocation = "Select docName,docMobile,docLocation,docSpecialization,docDays from doctor where docLocation = '" + location + "'";
		String sqlAvailablity = "Select docName,docMobile,docLocation,docSpecialization,docDays from doctor where docAvailablity = '" + availablity + "'";
		String sqlSpecialization = "Select docName,docMobile,docLocation,docSpecialization,docDays from doctor where docSpecialization = '" + specialization + "'";
		
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement(sqlLocation);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
			Doctor tempdoc1 = new Doctor();
			tempdoc1.setdocName(rs.getString("docName"));
			tempdoc1.setdocMobile(rs.getLong("docMobile"));
			tempdoc1.setdocLocation(rs.getString("docLocation"));
			tempdoc1.setdocSpecialization(rs.getString("docSpecialization"));
			tempdoc1.setdocDays(rs.getInt("sdocDays"));
			doctorsByLoc.add(tempdoc1);
			}
			stmt = con.prepareStatement(sqlAvailablity);
			rs = stmt.executeQuery();
			while(rs.next()) {
			Doctor tempdoc2 = new Doctor();
			tempdoc2.setdocName(rs.getString("docName"));
			tempdoc2.setdocMobile(rs.getLong("docMobile"));
			tempdoc2.setdocLocation(rs.getString("docLocation"));
			tempdoc2.setdocSpecialization(rs.getString("docSpecialization"));
			tempdoc2.setdocDays(rs.getInt("sdocDays"));
			doctorsByAvail.add(tempdoc2);
			}
			stmt = con.prepareStatement(sqlSpecialization);
			rs = stmt.executeQuery();
			while(rs.next()) {
			Doctor tempdoc3 = new Doctor();
			tempdoc3.setdocName(rs.getString("docName"));
			tempdoc3.setdocMobile(rs.getLong("docMobile"));
			tempdoc3.setdocLocation(rs.getString("docLocation"));
			tempdoc3.setdocSpecialization(rs.getString("docSpecialization"));
			tempdoc3.setdocDays(rs.getInt("sdocDays"));
			doctorsBySpec.add(tempdoc3);
			}
			
		} catch(SQLException sqle) {
			System.out.println(sqle);
		} finally {
			closeConnection(con);
		}
		Set<Doctor> doctors= new LinkedHashSet<>(doctorsBySpec);
		doctors.retainAll(doctorsByAvail);
		doctors.retainAll(doctorsBySpec);
		return doctors;
	}

}
