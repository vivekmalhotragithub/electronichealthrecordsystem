/**
 * 
 */
package com.nagarro.ycompany.ehr.dao.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author vivekmalhotra
 *
 */
@Entity
@Table(name = "USER_CREDENTIAL")
public class UserCredential {
	
	
    private Integer id;
	
	private InternalUser user;
	
	private String username;
	
	private String password;

	/**
	 * @return the id
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

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
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	@Column(name = "PASSWORD", nullable = false, length = 50)
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
