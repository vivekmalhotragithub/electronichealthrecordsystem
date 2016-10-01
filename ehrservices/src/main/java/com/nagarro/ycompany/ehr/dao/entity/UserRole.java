/**
 * 
 */
package com.nagarro.ycompany.ehr.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author vivekmalhotra
 *
 */
@Entity
@Table(name = "USER_ROLES")
public class UserRole {
	
	
	private Integer id;
	
	private UserCredential userCredential;
	
	private String role;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROLE_ID", unique = true, nullable = false)
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
	 * @return the userCredential
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERNAME", nullable = false)
	public UserCredential getUserCredential() {
		return userCredential;
	}

	/**
	 * @param userCredential the userCredential to set
	 */
	public void setUserCredential(UserCredential userCredential) {
		this.userCredential = userCredential;
	}

	/**
	 * @return the role
	 */
	@Column(name = "ROLE", nullable = false)
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
