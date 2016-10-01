/**
 * 
 */
package com.nagarro.ycompany.ehr.dao.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author vivekmalhotra
 *
 */
@Entity
@Table(name = "USER_CREDENTIAL")
public class UserCredential {
	
	
	private InternalUser user;
	
	private String username;
	
	private String password;
	
	private List<UserRole> userRoles;


	/**
	 * @return the userId
	 */
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	public InternalUser getUser() {
		return user;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUser(InternalUser user) {
		this.user = user;
	}

	/**
	 * @return the username
	 */
	@Id
	@Column(name = "USERNAME", nullable = false, length = 20)
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	@Column(name = "PASSWORD", nullable = false, length = 50)
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userRoles
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userCredential")
	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	/**
	 * @param userRoles the userRoles to set
	 */
	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	

}
