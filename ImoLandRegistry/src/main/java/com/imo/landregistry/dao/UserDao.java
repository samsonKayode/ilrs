package com.imo.landregistry.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<DAOUser, Integer> {
	
	public DAOUser findByUsername(String username);
	
	//UserDao getUserData(String username, String password);
}
