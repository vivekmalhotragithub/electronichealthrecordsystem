/**
 * 
 */
package com.nagarro.ycompany.ehr.service;

import java.util.List;

import com.nagarro.ycompany.ehr.dto.UserCredentialDTO;

/**
 * @author vivekmalhotra
 *
 */
public interface ILoginService {
	
	/**
	 * Service to authenticate a User
	 * @param username
	 * @return
	 */
	public UserCredentialDTO authenticateUser(String username);
	
	/**
	 * Service to list all Doctors
	 * @return
	 */
	public List<String> getAllDoctors();
	
	

}
