package com.hospital.registry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

public class ReportsDAOImp implements ReportsDAO {
	
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
	

	
	public ReportsDAOImp() {
	}

	@Override
	public boolean insert(Reports report) {
		Connection con = null;
		boolean bool = false;
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement("Insert into reports values (" + "NULL" + ", " + report.getappId() + ", " + report.gettechMobile() + ", '" + report.gettestName() + "', " + report.getrepStatus() + ", '"+report.getPath()+"');"); 
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
	public void update(Reports report) {
	}

	@Override
	public void delete(Reports report) {
	}

	@Override
	public Set<Reports> findReportByTechMobile(long techMobile) {
		Set<Reports> reports = new LinkedHashSet<Reports>();
		Connection con = null;
		
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from appointment where techMobile = " + techMobile);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Reports report = new Reports();
				report.setrepId(rs.getInt("repId")); 
				report.setappId(rs.getInt("appId"));
				report.settechMobile(rs.getLong("techMobile"));
				report.settestName(rs.getString("testName"));
				report.setrepStatus(rs.getInt("repStatus"));
				reports.add(report);
			}
		} catch(SQLException sqle) {
			System.out.println(sqle);
		} finally {
			closeConnection(con);
		}
		
		return reports;
	}

	@Override
	public Set<Reports> findReportByAppID(int appId) {
		Set<Reports> reports = new LinkedHashSet<Reports>();
		Connection con = null;
		
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from appointment where appID = " + appId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Reports report = new Reports();
				report.setrepId(rs.getInt("repId")); 
				report.setappId(rs.getInt("appId"));
				report.settechMobile(rs.getLong("techMobile"));
				report.settestName(rs.getString("testName"));
				report.setrepStatus(rs.getInt("repStatus"));
				reports.add(report);
			}
		} catch(SQLException sqle) {
			System.out.println(sqle);
		} finally {
			closeConnection(con);
		}
		
		return reports;
	}

}
