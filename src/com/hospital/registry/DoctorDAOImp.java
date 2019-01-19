package com.hospital.registry;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorDAOImp implements DoctorDAO {

	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException enfe){
			System.out.println(enfe);
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
	public void insert(Doctor doctor) {
		Connection con = null;

		try{
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement(
				"insert into doctor values (" + doctor.getdocMobile() +", '" + doctor.getdocName() + "', '" + doctor.getdocPassword() + "', '" + doctor.getdocLocation() + "', '" + doctor.getdocSpecialization() + "', " + doctor.getdocDays()+";");
			int res = stmt.executeUpdate();
			if(res != 0){
				System.out.println("Doctor "+ doctor.getdocName() +" was registerd succesfully.");
			}
		} catch(SQLException sqle){
			System.out.println(sqle);
		} finally {
			closeConnection(con);
		}

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
			System.out.println("Select docPassword from doctor where docMobile = " + docMobile+";");
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
				String name = rs.getString("docName"); 
				resDoctor.setdocName(name);
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
	public List<Doctor> findDoctorsByFilters(String location, String availablity, String specialization) {
		List<Doctor> doctors = new ArrayList<>();
		return doctors;
	}

}
