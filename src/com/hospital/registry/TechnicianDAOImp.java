package com.hospital.registry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TechnicianDAOImp implements TechnicianDAO {
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException cnfe){
			System.out.println(cnfe);
		}
	}
	
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql:/localhost:3306/hospitalregistry", "root", "Kmit123$");
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

	public TechnicianDAOImp() {
	}

	@Override
	public boolean insert(Technician technician) {
		Connection con = null;
		boolean bool = false;
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement("Insert into technician values (" + technician.gettechMobile() + ", '" + technician.gettechName() + "', '" + technician.gettechPassword() + "');"); 
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
	public void update(Technician technician) {
	}

	@Override
	public void delete(Technician technician) {

	}

	@Override
	public boolean validate(long techMobile, String techPassword) {
		Connection con = null;
		boolean validUser = false;
		
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement("Select techPassword from technician where techMobile = " + techMobile + ";");
			ResultSet rs = stmt.executeQuery();
			String actualPassword = "";
			while(rs.next()) {
				actualPassword =  rs.getString("techPassword");
			}
			if(techPassword.equals(actualPassword)) {
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
	public Technician findTechnician(long techMobile) {
		Connection con = null;
		Technician resTechnician = new Technician();
		
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement("Select techMobile,techName from technician where techMobile = " + techMobile);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				resTechnician.settechMobile(rs.getLong("techMobile"));
				resTechnician.settechName(rs.getString("techName"));
			}
		} catch(SQLException sqle) {
			System.out.println(sqle);
		} finally {
			closeConnection(con);
		}
		
		return resTechnician;
	}

}
