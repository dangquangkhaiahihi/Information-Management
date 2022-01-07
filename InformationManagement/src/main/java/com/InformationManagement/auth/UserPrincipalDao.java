package com.InformationManagement.auth;

import java.util.Optional;

public interface UserPrincipalDao  {
	Optional<UserPrincipal> selectUserPrincipal(String username);
}
