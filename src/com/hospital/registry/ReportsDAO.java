package com.hospital.registry;

import java.util.List;

public interface ReportsDAO {
	public void insert(Reports report);
	public void update(Reports report);
    public void delete(Reports report);
	public List<Reports> findReportByTechMobile(long techMobile);
	public List<Reports> findReportByAppID(int appId);
	
}
