package dummyDatabase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import models.Answer;
import models.Question;
import models.User;

public class Data {
	
	public List<User> users;
	
	public List<Question> questions = new ArrayList<Question>();
	
	public List<Answer> answers = new ArrayList<Answer>();
	
	public Data() {
		users = new ArrayList<User>();
		users.add(new User("Stella", "123456", "www.facebook.com/stela", "f"));
		users.add(new User("Galin", "Test1234", "www.facebook.com/galin", "m"));
		users.add(new User("Kiro", "TestDa", "www.facebook.com/kiro", "m"));
		users.add(new User("Milena","qwerty","www.facebook,com/milencheto","f"));
		
		questions = new ArrayList<Question>();
		questions.add(new Question("About how long do you want your next relationship to last?"));
		questions.add(new Question("Would you consider sleeping with someone on first date?"));
		questions.add(new Question("Rate your self-confidance:"));
		questions.add(new Question("How important is religion/God in your life?"));
		questions.add(new Question("How often you are open with your feelings?"));
		questions.add(new Question("Would you need to sleep with someone before you considered marring them?"));
		questions.add(new Question("If you had to name your greatest motivation in life thus far,what would it be?"));
		
		answers = new ArrayList<Answer>();
		answers.add(new Answer(0, "One night", 2, questions.get(0)));
		answers.add(new Answer(1, "A few months to year",1,questions.get(0)));
		answers.add(new Answer(2, "Several years/rest of my life",0,questions.get(0)));
		
		answers.add(new Answer(3, "Yes", 2, questions.get(1)));
		answers.add(new Answer(4, "Depends on my mood", 1, questions.get(1)));
		answers.add(new Answer(5, "No", 0, questions.get(1)));
		
		answers.add(new Answer(6, "Very high", 2, questions.get(2)));
		answers.add(new Answer(7, "Average", 1, questions.get(2)));
		answers.add(new Answer(8, "Below average", 0, questions.get(2)));
		
		answers.add(new Answer(9, "Extreamly important",2,questions.get(3)));
		answers.add(new Answer(10, "Somewhat",1,questions.get(3)));
		answers.add(new Answer(11, "Not at all",0,questions.get(3)));
		
		answers.add(new Answer(12, "Always",2,questions.get(4)));
		answers.add(new Answer(13, "Usually",1,questions.get(4)));
		answers.add(new Answer(14, "Rarely/Never",0,questions.get(4)));
		
		answers.add(new Answer(15, "Yes",2,questions.get(5)));
		answers.add(new Answer(16, "It depends on my partner",1,questions.get(5)));
		answers.add(new Answer(17, "No",0,questions.get(5)));
		
		answers.add(new Answer(18, "Love",2,questions.get(6)));
		answers.add(new Answer(19, "Knowledge",2,questions.get(6)));
		answers.add(new Answer(20, "Wealth",2,questions.get(6)));
	}
	
	public  void addNewUser(String name,String password,String facebook,String gender) {
		User newUser = new User(name, password, facebook, gender);
		users.add(newUser);
	}
	
	public void addNewUser(User user) {
		users.add(user);
	}
	
	public void addQuestion(String questionContent,String firstAns,String secondAns,String thirdAns) {
		Question question = new Question(questionContent);
		questions.add(question);
		int answerId = answers.size()-1;
		Answer fans = new Answer(answerId+1, firstAns,2,question);
		Answer sans = new Answer(answerId+2, secondAns,2,question);
		Answer tans = new Answer(answerId+3, thirdAns,2,question);
		answers.add(fans);
		answers.add(sans);
		answers.add(tans);
	}
	
	public boolean isCorrect(String name,String password) {
		for ( User u : users) {
			if (u.getName().equals(name) && u.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public List<Answer> getAnswersByQuestion(Question q) {
		List<Answer> result = new ArrayList<Answer>();
		if (questions.contains(q)) {
			for (Answer ans : answers) {
				if ( ans.getQuestionId().equals(q)) {
					result.add(ans);
				}
			}
		}
		return result;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
