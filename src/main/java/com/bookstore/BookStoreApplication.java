package com.bookstore;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookstore.domain.User;
import com.bookstore.security.domain.Role;
import com.bookstore.security.domain.UserRole;
import com.bookstore.service.UserService;
import com.bookstore.serviceUtility.SecurityUtility;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {
	
	@Autowired
    private UserService userService;


	
	
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user1 = new User();
		user1.setFirstName("Rayhan");
		user1.setLastName("Ahamed");
		user1.setUsername("j");
	    user1.setPassword(SecurityUtility.passwordEncoder().encode("r"));
		user1.setEmail("rayhan3ahamed@gmail.com");
		
		Set<UserRole> userRoles = new HashSet<>();
		
		Role role1= new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");

		userRoles.add(new UserRole(user1, role1));
        userService.createUser(user1, userRoles);


		
	}
}
