package com.nagarro.ycompany.ehr.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.ycompany.ehr.dao.InternalUserDao;
import com.nagarro.ycompany.ehr.dao.entity.InternalUser;

/**
 * 
 * @author vivekmalhotra
 *
 */
@Repository
@Transactional
public class InternalUserDaoImpl implements InternalUserDao {
	
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	public List<InternalUser> getAllUsers() {
		// 
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(InternalUser.class);
		List<InternalUser> userList = criteria.list();
		return userList;
	}
	
}
