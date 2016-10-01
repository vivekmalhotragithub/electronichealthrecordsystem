package com.nagarro.ycompany.ehr.dao;

import com.nagarro.ycompany.ehr.dao.entity.UserCredential;

/**
 * 
 * @author vivekmalhotra
 *
 */
public interface IUserAuthenticationDao {
	
	
	public UserCredential getUserByUsername(String username);

}
