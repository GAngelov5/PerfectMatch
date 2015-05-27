package dummyDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Answer;
import models.Question;
import models.User;

public class Data {
	
	public static List<User> users;
	
	public static List<Question> questions = new ArrayList<Question>();
	
	public static List<Answer> answers = new ArrayList<Answer>();
	
	public Data() {
		users = new ArrayList<User>();
		users.add(new User("Stella", "123456", "www.facebook.com/stela", "f"));
		users.add(new User("Galin", "Test1234", "www.facebook.com/galin", "m"));
		users.add(new User("Kiro", "TestDa", "www.facebook.com/kiro", "m"));
		users.add(new User("Milena","qwerty","www.facebook,com/milencheto","f"));
		
		questions = new ArrayList<Question>();
		questions.add(new Question("About how long do you want your next relationship to last?"));
		questions.add(new Question("Would ou consider sleeping with someone on first date?"));
		questions.add(new Question("Rate your self-confidance:"));
		questions.add(new Question("How important is religion/God in your life?"));
		questions.add(new Question("How often you are open with your feelings?"));
		questions.add(new Question("would you need to sleep with someone before you considered marring them?"));
		questions.add(new Question("If you had to name your greatest motivation in life thus far,what would it be?"));
		
		answers = new ArrayList<Answer>();
		answers.add(new Answer("One night", 2, questions.get(0)));
		answers.add(new Answer("A few months to year",1,questions.get(0)));
		answers.add(new Answer("Several years/rest of my life",0,questions.get(0)));
		
		answers.add(new Answer("Yes", 2, questions.get(1)));
		answers.add(new Answer("Depends on my mood", 1, questions.get(1)));
		answers.add(new Answer("No", 0, questions.get(1)));
		
		answers.add(new Answer("Very high", 2, questions.get(2)));
		answers.add(new Answer("Average", 1, questions.get(2)));
		answers.add(new Answer("Below average", 0, questions.get(2)));
		
		answers.add(new Answer("Extreamly important",2,questions.get(3)));
		answers.add(new Answer("Somewhat",1,questions.get(3)));
		answers.add(new Answer("Not at all",0,questions.get(3)));
		
		answers.add(new Answer("Always",2,questions.get(4)));
		answers.add(new Answer("Usually",1,questions.get(4)));
		answers.add(new Answer("Rarely/Never",0,questions.get(4)));
		
		answers.add(new Answer("Yes",2,questions.get(5)));
		answers.add(new Answer("It depends on my partner",1,questions.get(5)));
		answers.add(new Answer("No",0,questions.get(5)));
		
		answers.add(new Answer("Love",2,questions.get(6)));
		answers.add(new Answer("Knowledge",2,questions.get(6)));
		answers.add(new Answer("Wealth",2,questions.get(6)));
	}
	
	public  void addNewUser(String name,String password,String facebook,String gender) {
		User newUser = new User(name, password, facebook, gender);
		users.add(newUser);
	}
	
	public void addQuestion(String questionContent,String firstAns,String secondAns,String thirdAns) {
		Question question = new Question(questionContent);
		questions.add(question);
		
		Answer fans = new Answer(firstAns,2,question);
		Answer sans = new Answer(secondAns,2,question);
		Answer tans = new Answer(thirdAns,2,question);
		answers.add(fans);
		answers.add(sans);
		answers.add(tans);
	}
}
