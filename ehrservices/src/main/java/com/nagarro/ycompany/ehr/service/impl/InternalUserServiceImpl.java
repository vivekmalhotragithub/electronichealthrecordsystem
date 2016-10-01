/**
 * 
 */
package com.nagarro.ycompany.ehr.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.ycompany.ehr.dao.IInternalUserDao;
import com.nagarro.ycompany.ehr.dao.entity.InternalUser;
import com.nagarro.ycompany.ehr.service.IInternalUserService;

/**
 * @author vivekmalhotra
 *
 */
@Service
public class InternalUserServiceImpl implements IInternalUserService {
	
	/**
	 * 
	 */
	private IInternalUserDao internalUserDao;

	
	public void setInternalUserDao(IInternalUserDao internalUserDao) {
		this.internalUserDao = internalUserDao;
	}
	
	/* (non-Javadoc)
	 * @see com.nagarro.ycompany.ehr.service.IListUsers#getAllUsers()
	 */
	public String getAllUsers() {
		// TODO Auto-generated method stub
		List<InternalUser> userlist = internalUserDao.getAllUsers();
		return userlist.toString();
	}


}
