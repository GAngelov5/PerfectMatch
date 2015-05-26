package services;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
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

	// @EJB
	// private UserContext userContext;

	@POST
	@Path("register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void registerUser(@FormParam("username") String name,
			@FormParam("password") String password,
			@FormParam("facebook") String facebook,
			@FormParam("sex") String gender) {
		System.out.println("brr");
		User newUser = new User(name, password, facebook, gender);
		Data.users.add(newUser);
		// userContext.setCurrentUser(newUser);
		//return newUser;
	}

	@GET
	@Path("allusers")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<User> getAllUsers() {
		return Data.users;
	}
}
