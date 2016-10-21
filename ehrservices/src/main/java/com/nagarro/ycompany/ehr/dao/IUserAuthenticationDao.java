package com.nagarro.ycompany.ehr.dao;

import java.util.List;

import com.nagarro.ycompany.ehr.dao.entity.UserCredential;

/**
 * 
 * @author vivekmalhotra
 *
 */
public interface IUserAuthenticationDao {
	
	
	public UserCredential getUserByUsername(String username);
	
	public List<UserCredential> getAllUsers();

}
