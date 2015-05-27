package dummyDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Answer;
import models.Question;
import models.User;

public class Data {
	
	public  List<User> users;
	
	public  List<Question> questions = new ArrayList<Question>();
	
	public  List<Answer> answers = new ArrayList<Answer>();
	
	public Data() {
		users = new ArrayList<User>();
		users.add(new User("Stella", "123456", "www.facebook.com/stela", "f"));
		users.add(new User("Galin", "Test1234", "www.facebook.com/galin", "m"));
		users.add(new User("Kiro", "TestDa", "www.facebook.com/kiro", "m"));
		
		questions = new ArrayList<Question>();
		questions.add();
		questions.add();
		questions.add();
		
		answers = new ArrayList<Answer>();
		answers.add(e);
		answers.add(e);
		answers.add(e);
		answers.add(e);
		answers.add(e);
		answers.add(e);
		answers.add(e);
		answers.add(e);
	}
	
}
