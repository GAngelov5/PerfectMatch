package services;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.AnswerDAO;
import dao.QuestionDAO;
import dummyDatabase.Data;

@Stateless
@Path("test")
public class TestManager {
	
	@Inject
	private AnswerDAO answerDao;
	
	@Inject
	private QuestionDAO questionDao;
	
//	@Produce(MediaType.APPLICATION_JSON)
//	public generateTest() {
//		
//	}
	
	@GET
	@Path("currentUser")
	@Produces(MediaType.TEXT_HTML)
	public String getCurrentUserName() {
		if (Data.users.size() != 0) {
			return Data.users.get(Data.users.size()-1).getName();			
		}
		return "No users";
		// get  from UserContext currentUser and print his name !
	}
	
	
}
