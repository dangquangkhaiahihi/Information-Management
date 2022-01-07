package com.InformationManagement.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalService implements UserDetailsService {

	
	private final UserPrincipalDao userPrincipalDao;
	@Autowired
	public UserPrincipalService(UserPrincipalDao userPrincipalDao) {
		this.userPrincipalDao = userPrincipalDao;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = repo.findByUsername(username);
//		if (user == null)
//			throw new UsernameNotFoundException("User 404");
//		return new UserPrincipal(user);
		return userPrincipalDao
				.selectUserPrincipal(username)
				.orElseThrow(() -> 
					new UsernameNotFoundException(String.format("Username %s not found",username)));
	}

}
