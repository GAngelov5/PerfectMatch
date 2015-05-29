package services;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import models.User;
import dummyDatabase.Data;

@Stateless
@Path("user")
public class UserManager {

	// @EJB
	// private UserDAO userDao;

	//private UserContext currentUser;
	
	//private User currentUser;

	@POST
	@Path("register")
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerUser(User newUser) {
		//User newUser = new User(name, password, facebook, gender);
		UserContext.currentUser = newUser;
		System.out.println("Noviq user: " + UserContext.currentUser.getName());
		System.out.println("Noviq user: " + UserContext.currentUser.getPassword());
		System.out.println("Noviq user: " + UserContext.currentUser.getGender());
		System.out.println("Noviq user: " + UserContext.currentUser.getFacebook());
		Data.data.addNewUser(UserContext.currentUser);
		System.out.println("Bazata danni " + Data.data.getUsers().size());
		//currentUser.setCurrentUser(newUser); 
		//userContext.setCurrentUser(newUser);
	}
	
	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	public void loginUser(User newUser) {
//		--> User user
//		if ( userDao.validateUserCredentials(user.getName(), user.getPassword())) {
//			userContext.setCurrentUser(user);
//		}
		if (Data.data.isCorrect(newUser.getName(), newUser.getPassword())) {
			//currentUser.setCurrentUser(newUser);
			UserContext.currentUser = newUser;
			UserContext.currentUser.setGender(Data.data.getUserGender(newUser));
			UserContext.currentUser.setFacebook(Data.data.getUserFacebook(newUser));
			Data.data.addNewUser(UserContext.currentUser);

		}
		//System.out.println(newUser.getName());
	}
	
	@GET
	@Path("getAllUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<User> getUserName() {
		return Data.data.getUsers();
	}

	@GET
	@Path("currentUserName")
	@Produces(MediaType.TEXT_HTML)
	public String getCurrentUserName() {
		return UserContext.currentUser.getName();
		// get  from UserContext currentUser and print his name !
	}
	

}
