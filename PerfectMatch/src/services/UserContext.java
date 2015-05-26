package services;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import models.User;

@SessionScoped
public class UserContext implements Serializable{
	
	private static final long serialVersionUID = -9137745602092002810L;
	
	private User currentUser;
	
	public User getCurrentUser() {
		return currentUser;
	}
	
	public void setCurrentUser(User user) {
		this.currentUser = user;
	}
}
