/**
 * 
 */
package com.nagarro.ycompany.ehr.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.ycompany.ehr.dao.IUserAuthenticationDao;
import com.nagarro.ycompany.ehr.dao.entity.UserCredential;

/**
 * @author vivekmalhotra
 *
 */
@Repository
@Transactional
public class UserAuthenticationDaoImpl implements IUserAuthenticationDao {

	private SessionFactory sessionFactory;

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserCredential getUserByUsername(String username) {
		// get user
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(UserCredential.class);
		criteria.add(Restrictions.eq("username", username));

		return (UserCredential) criteria.uniqueResult();
	}

}
