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

import models.User;
import dummyDatabase.Data;

@Stateless
@Path("user")
public class UserManager {

	// @EJB
	// private UserDAO userDao;

	@Inject
	private UserContext userContext;

	@POST
	@Path("register")
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerUser(User newUser) {
		//User newUser = new User(name, password, facebook, gender);
		Data.users.add(newUser);
		//userContext.setCurrentUser(newUser);
	}
	
	@GET
	@Path("getCurrentUserName")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<User> getUserName() {
		return Data.users;
	}

	@GET
	@Path("allusers")
	@Produces(MediaType.TEXT_HTML)
	public String getAllUsers() {
		return Data.users.get(Data.users.size()-1).getName();
	}
}
