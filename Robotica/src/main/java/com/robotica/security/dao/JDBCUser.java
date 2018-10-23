package com.robotica.security.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.robotica.security.models.User;

@Repository
public class JDBCUser {
	
	@Autowired
	JdbcTemplate jdbc;
	
	public boolean create(User user) throws DataAccessException {
		
		jdbc.update("INSERT INTO usuarios (username, email, password, role) VALUES "
				+ "(?,?,?,'USER')", user.getUsername(), user.getEmail(), user.getPassword());
		
		return false;
		
	}
	
	public boolean emailExist(String email) throws DataAccessException {
		
		int exist = jdbc.queryForObject("SELECT count(*) FROM usuarios WHERE email = ?", Integer.class, email);
		
		if (exist == 0) {
			return false;
		}
		
		return true;
		
	}
	
	public boolean usernameExist(String username) throws DataAccessException {
		
		int exist = jdbc.queryForObject("SELECT count(*) FROM usuarios WHERE username = ?", Integer.class, username);
		
		if (exist == 0) {
			return false;
		}
		
		return true;
	}
	
	public User findByUsername(String username) throws DataAccessException {
		
		return jdbc.queryForObject("SELECT * FROM usuarios WHERE username = ?", new UserRM(), username);
		
	}
	
	public User findByEmail(String email) throws DataAccessException {
		
		return jdbc.queryForObject("SELECT * FROM usuarios WHERE email = ?", new UserRM(), email);
		
	}
	
	public User findByUsernameOrEmail(String usernameOrEmail) throws DataAccessException {
		
		return jdbc.queryForObject("SELECT * FROM usuarios WHERE username = ? OR email = ?", 
				new UserRM(), usernameOrEmail, usernameOrEmail);
		
	}
	
	public User findById(int id) throws DataAccessException {
		
		return jdbc.queryForObject("SELECT * FROM usuarios WHERE id = ?", new UserRM(), id);
		
	}

}
