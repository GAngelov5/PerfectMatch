package services;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import models.Answer;
import models.LoginUser;
import models.User;
import dummyDatabase.Data;

@Stateless
@Path("user")
public class UserManager {

	// @EJB
	// private UserDAO userDao;

	//private UserContext currentUser;
	
	private Data testData = new Data();
	//private User currentUser;

	@POST
	@Path("register")
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerUser(User newUser) {
		//User newUser = new User(name, password, facebook, gender);
		testData.addNewUser(newUser);
		//currentUser.setCurrentUser(newUser); 
		UserContext.currentUser = newUser;
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
		if (testData.isCorrect(newUser.getName(), newUser.getPassword())) {
			//currentUser.setCurrentUser(newUser);
			UserContext.currentUser = newUser;
		}
		//System.out.println(newUser.getName());
	}
	
	@GET
	@Path("getAllUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<User> getUserName() {
		return testData.getUsers();
	}

	@GET
	@Path("currentUserName")
	@Produces(MediaType.TEXT_HTML)
	public String getCurrentUserName() {
		return UserContext.currentUser.getName();
		// get  from UserContext currentUser and print his name !
	}
	
}
