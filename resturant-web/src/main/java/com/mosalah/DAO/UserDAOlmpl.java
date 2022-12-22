package com.mosalah.DAO;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mosalah.models.user;

public class UserDAOlmpl implements UserDAO {

	
	

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	

	public UserDAOlmpl (DataSource dataSourcce ) {
		jdbcTemplate = new JdbcTemplate(dataSourcce);
	}
	
	@Override
	public void register(user user) {
		Object[] UserInfo = {
			user.getUsername(),user.getPassword(),user.getAge(),user.getAddress()
				};
		String sql = "INSERT INTO users(username, password, age, address) VALUES (?,?,?,?)";
		jdbcTemplate.update(sql,UserInfo);
		
		registerRole(user);
		
		System.out.println("inserted successfully !");
		
	}

	
	
	@Override
	public void registerRole(user user) {
		// TODO Auto-generated method stub
		Object[] UserInfo = {
				user.getUsername(),"ROLE_USER"
					};
			String sql = "INSERT INTO `user_role`(`username`, `role`)  VALUES (?,?)";
			jdbcTemplate.update(sql,UserInfo);
			
	}
	
	
	
	
    @Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
	}



}
