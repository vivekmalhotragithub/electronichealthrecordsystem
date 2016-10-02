/**
 * 
 */
package com.nagarro.ycompany.ehr.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.ycompany.ehr.dto.UserCredentialDTO;
import com.nagarro.ycompany.ehr.dto.UserRoleDTO;
import com.nagarro.ycompany.ehr.service.impl.LoginServiceImpl;

/**
 * @author vivekmalhotra
 *
 */
@Service
public class UserAuthenticationService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(UserAuthenticationService.class);

	@Autowired
	private LoginServiceImpl loginService;

	@Override	
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserCredentialDTO user = loginService.authenticateUser(username);
		logger.info("User : " + user);
		if (user == null) {
			logger.error("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user));
	}

	// get all roles of a User
	private List<GrantedAuthority> getGrantedAuthorities(UserCredentialDTO user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (UserRoleDTO profileRoles : user.getUserRoles()) {
			logger.info("UserProfile : " + profileRoles.getRole());
			authorities.add(new SimpleGrantedAuthority(profileRoles.getRole()));
		}
		logger.info("authorities :" + authorities);
		return authorities;
	}

}
