package services;

import java.io.Serializable;

import models.User;

public class UserContext implements Serializable{
	
	private static final long serialVersionUID = -9137745602092002810L;
	
	public static User currentUser;
	
//	public static User getCurrentUser() {
//		return currentUser;
//	}
//	
//	public void setCurrentUser(User user) {
//		this.currentUser = user;
//	}
}
