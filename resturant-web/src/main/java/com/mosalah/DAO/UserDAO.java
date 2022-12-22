package com.mosalah.DAO;

import javax.sql.DataSource;

import com.mosalah.models.user;

public interface UserDAO {

	
	
	
	void register(user user);  
	void registerRole(user user);  
 public void setDataSource(DataSource dataSource);
	
}
