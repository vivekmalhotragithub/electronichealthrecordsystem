/**
 * 
 */
package com.nagarro.ycompany.ehr.service;

import com.nagarro.ycompany.ehr.dto.UserCredentialDTO;

/**
 * @author vivekmalhotra
 *
 */
public interface ILoginService {
	
	
	public UserCredentialDTO authenticateUser(String username);
	
	

}
