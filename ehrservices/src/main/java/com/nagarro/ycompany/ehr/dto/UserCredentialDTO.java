package com.nagarro.ycompany.ehr.dto;

import java.util.List;

/**
 * 
 * @author vivekmalhotra
 *
 */
public class UserCredentialDTO {

	private String username;

	private String password;

	private List<UserRoleDTO> userRoles;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
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
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the roles
	 */
	public List<UserRoleDTO> getUserRoles() {
		return userRoles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setUserRoles(List<UserRoleDTO> roles) {
		this.userRoles = roles;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserCredentialDTO [username=" + username + ", roles=" + userRoles + ", password=" + password + "]";
	}

}
