package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

	private List<Question> questions = Data.data.getQuestions();

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
			List<Answer> currQuestionAnswers = Data.data
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
		// UserContext.currentUser.setResultPoints(currentUserAnswers);
	}
	
//	@GET
//	@Path()

	@GET
	@Path("getresults")
	@Produces("application/json")
	public String printResults() {
		Map<String, Integer> people = getResultList();
		Map<String, String> result = new HashMap<String, String>();
		for (String a : people.keySet()) {
			System.out.println("PEOPLE Key: " + a + " Value: " + people.get(a));
		}
		
		for (String user : people.keySet()) {
			StringBuilder currentUserName = new StringBuilder();
			currentUserName.append(user);
			StringBuilder currentPoints = new StringBuilder();
			currentPoints.append(people.get(user));
			currentPoints.append("_" + Data.data.getFacebookByName(user));
			result.put(currentUserName.toString(), currentPoints.toString());
		}
		//currentUserAnswers.clear();
		Gson gson = new Gson();
		String json = gson.toJson(result);
		System.out.println(json);
		return json;
	}

	public Map<String, Integer> getResultList() {
		List<User> people;
		//System.out.println(currentUserAnswers.toString());
		UserContext.currentUser.setResultPoints(new ArrayList<Integer>());
		//UserContext.currentUser.getResultPoints().clear();
		UserContext.currentUser.getResultPoints().addAll(currentUserAnswers);
		currentUserAnswers.clear();
		for (int i = 0; i < Data.data.getUsers().size(); i++) {
			System.out.println(Data.data.getUsers().get(i).getResultPoints().toString());
		}
		System.out.println("GENDER: " + UserContext.currentUser.getGender());
		if (UserContext.currentUser.getGender().equals("f")) {
			people = Data.data.getUsersByGender("m");
		} else {
			people = Data.data.getUsersByGender("f");
		}
		System.out.println("MUJE/JENI: " + people.toString());
		Map<String, Integer> userPoints = new HashMap<String, Integer>();
		int result = 0;
		for (int user = 0; user < people.size(); user++) {
			for (int i = 0; i < UserContext.currentUser.getResultPoints().size(); i++) {
				result += Math.abs(people.get(user).getResultPoints().get(i)
						- UserContext.currentUser.getResultPoints().get(i));
				
			}
			// tuk stavat procentite
			
			double resultProcent = (1 - ((double) result)/(double) (2*Data.data.getQuestions().size()))*100;
			Double percent = new Double(resultProcent);
			System.out.println("Resultat v procenti: " + percent.intValue());
			userPoints.put(people.get(user).getName(), percent.intValue());
			System.out.println("Result variable: " + result);
			System.out.println("Size of hashmap" + userPoints.size());
			result = 0;
		}
		
		return userPoints;
	}
	
//	public Map<String, Integer> getFirstThree(Map<String, Integer> people) {
//		Map<String, Integer> firstThreePeople = new HashMap<String, Integer>();
//		firstThreePeople.putAll(people);
//		int max = 0;
//		int index = 0;
//		for (String user: people.keySet()) {
//			for (String otherUser : firstThreePeople.keySet()) {
//				if (people.get(user) )
//			}
//			
//		}
//	}

}
