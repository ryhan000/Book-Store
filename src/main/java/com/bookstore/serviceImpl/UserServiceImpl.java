package com.bookstore.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.User;
import com.bookstore.repository.PasswordResetTokenRepository;
import com.bookstore.security.domain.PasswordResetToken;
import com.bookstore.service.UserService;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;
	
	
	
	@Override
	public PasswordResetToken getPasswordResetToken(String token) {
		// TODO Auto-generated method stub
		return passwordResetTokenRepository.findByToken(token);
	}

	@Override
	public void createPasswordResetTokenForUser(User user, String token) {
		// TODO Auto-generated method stub  
	   final PasswordResetToken myToken=new PasswordResetToken(token,user);
	   passwordResetTokenRepository.save(myToken);
	}

}
