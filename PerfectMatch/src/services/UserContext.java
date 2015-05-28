package services;

import java.io.Serializable;

import models.User;
import dummyDatabase.Data;

public class UserContext implements Serializable{
	
	private static final long serialVersionUID = -9137745602092002810L;
	
	private static Data dataTest = new Data();
	
	public static User currentUser;
	
//	public static User getCurrentUser() {
//		return currentUser;
//	}
//	
//	public void setCurrentUser(User user) {
//		this.currentUser = user;
//	}
}
