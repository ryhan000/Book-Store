package com.bookstore.serviceImpl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.User;
import com.bookstore.repository.PasswordResetTokenRepository;
import com.bookstore.repository.RoleRepository;
import com.bookstore.repository.UserRepository;
import com.bookstore.security.domain.PasswordResetToken;
import com.bookstore.security.domain.UserRole;
import com.bookstore.service.UserService;

@Service
public class UserServiceImpl  implements UserService{

	private static final Logger LOG=LoggerFactory.getLogger(UserService.class);
	
	
	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;
	
    @Autowired
    private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
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

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public User createUser(User user, Set<UserRole> userRoles) {
		// TODO Auto-generated method stub
		User localUser =userRepository.findByUsername(user.getUsername());
		
		if(localUser !=null) {
			LOG.info("user {} allredy exists.Nothing will be done",user.getUsername());
		}else {
			
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			localUser= userRepository.save(user);
			
		}
		return localUser;
	}

}
