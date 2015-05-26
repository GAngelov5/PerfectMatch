package services;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import dao.AnswerDAO;
import dao.QuestionDAO;

@Stateless
@Path("user")
public class TestManager {
	
	@Inject
	private AnswerDAO answerDao;
	
	@Inject
	private QuestionDAO questionDao;
	
//	@Produce(MediaType.APPLICATION_JSON)
//	public generateTest() {
//		
//	}
}
