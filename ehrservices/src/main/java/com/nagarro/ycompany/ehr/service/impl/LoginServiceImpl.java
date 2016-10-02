/**
 * 
 */
package com.nagarro.ycompany.ehr.service.impl;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.ycompany.ehr.dao.IUserAuthenticationDao;
import com.nagarro.ycompany.ehr.dao.entity.UserCredential;
import com.nagarro.ycompany.ehr.dto.UserCredentialDTO;
import com.nagarro.ycompany.ehr.service.ILoginService;

/**
 * @author vivekmalhotra
 *
 */
@Service
public class LoginServiceImpl implements ILoginService {

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	private IUserAuthenticationDao userAuthenticationDao;

	@Autowired
	DozerBeanMapper dozerBeanMapper;

	/**
	 * @param userAuthDao
	 *            the userAuthDao to set
	 */
	public void setUserAuthenticationDao(IUserAuthenticationDao userAuthDao) {
		this.userAuthenticationDao = userAuthDao;
	}

	public UserCredentialDTO authenticateUser(String username) {
		UserCredential userCredential = userAuthenticationDao.getUserByUsername(username);
		UserCredentialDTO userCredDTO = null;
		if (userCredential != null) {
			logger.info("User with username:" + username + " found" + userCredential);
			userCredDTO = dozerBeanMapper.map(userCredential, UserCredentialDTO.class,
					"userCredentialToUserCredentialDTO");
		}
		return userCredDTO;
	}

}
