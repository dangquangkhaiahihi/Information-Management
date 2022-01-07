package com.InformationManagement.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class FakeUserPrincipalDaoService implements UserPrincipalDao {
	@Override
	public Optional<UserPrincipal> selectUserPrincipal(String username) {
		return getUserPrincipal().stream()
				.filter(userPrincipal -> username.equals(userPrincipal.getUsername()))
				.findFirst();
	}

	private List<UserPrincipal> getUserPrincipal(){
		List<UserPrincipal> userPrincipals = new ArrayList<>();
		return userPrincipals;
	}
}
