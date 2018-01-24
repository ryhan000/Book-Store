package com.bookstore.service;

import java.util.Set;

import com.bookstore.domain.User;
import com.bookstore.security.domain.PasswordResetToken;
import com.bookstore.security.domain.UserRole;

public interface UserService {

	PasswordResetToken  getPasswordResetToken(final String token);
	void createPasswordResetTokenForUser(final User user,final String token);
	User findByUsername(String username);
	User findByEmail(String email);
	User createUser(User user,Set<UserRole> userRole)throws Exception;
}
