package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import models.Answer;
import models.Question;
import models.User;

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

	private List<Integer> currentUserAnswers = new ArrayList<Integer>();

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
	@Consumes("text/plain")
	public void getAnswerPoints(String a) {
		currentUserAnswers.add(Integer.parseInt(a));
		UserContext.currentUser.setResultPoints(currentUserAnswers);
	}

	@GET
	@Path("getresults")
	@Produces("application/json")
	public String printResults() {
		Map<String, String> people = getResultList();
		Map<String, String> result = new HashMap<String, String>();
		int count = 0;
		for (String user : people.keySet()) {
			if (count == 3) {
				break;
			}
			StringBuilder currentUserName = new StringBuilder();
			currentUserName.append(user);
			StringBuilder currentPoints = new StringBuilder();
			currentPoints.append(people.get(user));
			result.put(currentUserName.toString(), currentPoints.toString());
			count++;
		}

		Gson gson = new Gson();
		String json = gson.toJson(result);

		return json;
	}

	public Map<String, String> getResultList() {
		List<User> people;
		if (UserContext.currentUser.getGender().equals("f")) {
			people = testData.getUsersByGender("m");
		} else {
			people = testData.getUsersByGender("f");
		}
		Map<String, String> userPoints = new HashMap<String, String>();
		//ValueComparator bvc = new ValueComparator(userPoints);
		int result = 0;
		for (int user = 0; user < people.size(); user++) {
			for (int i = 0; i < UserContext.currentUser.getResultPoints().size(); i++) {
				result += Math.abs(people.get(user).getResultPoints().get(i)
						- UserContext.currentUser.getResultPoints().get(i));
			}
			userPoints.put(people.get(user).getName(), Integer.toString(result));
			result = 0;
		}
		return userPoints;
	}

}
