package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.Answer;
import models.Question;

import com.google.gson.Gson;

import dummyDatabase.Data;

@Stateless
@Path("test")
public class TestManager {

	// @Inject
	// private AnswerDAO answerDao;
	//
	// @Inject
	// private QuestionDAO questionDao;

	private Data testData = new Data();

	private List<Question> questions = testData.getQuestions();

	private static int i = 0;

	@GET
	@Path("/generateTest")
	@Produces(MediaType.APPLICATION_JSON)
	public String generateTest() {
		if (i == questions.size()) {
			i = 0;
			return "{}";
		} else {
			Question currentQuestion = questions.get(i);
			List<Answer> currQuestionAnswers = testData
					.getAnswersByQuestion(currentQuestion);
			GenerateQuestion generator = new GenerateQuestion(currentQuestion,
					currQuestionAnswers);
			Gson gson = new Gson();
			
			// convert java object to JSON format
			String json = gson.toJson(generator);
			i++;
			return json;
		}
	}
	
	@POST
	@Path("getanswer")
	@Consumes(MediaType.APPLICATION_JSON)	
	public void getAnswerPoints(String a) {
		System.out.println(a);
	}

}
