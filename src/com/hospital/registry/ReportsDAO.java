package com.hospital.registry;

import java.util.Set;

public interface ReportsDAO {
	public boolean insert(Reports report);
	public void update(Reports report);
    public void delete(Reports report);
	public Set<Reports> findReportByTechMobile(long techMobile);
	public Set<Reports> findReportByAppID(int appId);
	
}
