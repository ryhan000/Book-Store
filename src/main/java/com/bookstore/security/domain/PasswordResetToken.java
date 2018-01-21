package com.bookstore.security.domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.bookstore.domain.User;

@Entity
public class PasswordResetToken {

	private static int EXPIRATION = 60*24;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String token;
	
	@OneToOne(targetEntity =User.class,fetch=FetchType.EAGER)
	@JoinColumn(nullable=false,name="user-id")
	private User user;
	
	private Date expiryDate;

	public PasswordResetToken(String token,final User user) {
		super();
		this.token = token;
		this.user = user;
		this.expiryDate=calculateExpiryDate(EXPIRATION);
	}

	private Date calculateExpiryDate(final int expiryDateInMinutes) {
		// TODO Auto-generated method stub
		
		final Calendar cal=Calendar.getInstance();
		cal.setTimeInMillis(new Date().getTime());
		cal.add(Calendar.MINUTE,  expiryDateInMinutes);
		return new Date(cal.getTime().getTime());
	}
	
	
	public void updateToken(final String token) {
		this.token=token;
		this.expiryDate=calculateExpiryDate(EXPIRATION);
	}

	public static int getEXPIRATION() {
		return EXPIRATION;
	}

	public static void setEXPIRATION(int eXPIRATION) {
		EXPIRATION = eXPIRATION;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "PasswordResetToken [id=" + id + ", token=" + token + ", user=" + user + ", expiryDate=" + expiryDate
				+ "]";
	}
	
	
	
	
	
}
