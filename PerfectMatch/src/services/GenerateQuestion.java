package services;

import java.util.List;

import models.Answer;
import models.Question;

public class GenerateQuestion {

	//String
	private Question question;
	
	private List<Answer> possibleAnswers;
	
	public GenerateQuestion(Question question, List<Answer> possibleAnswers) {
		this.setQuestion(question);
		this.setPossibleAnswers(possibleAnswers);
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<Answer> getPossibleAnswers() {
		return possibleAnswers;
	}

	public void setPossibleAnswers(List<Answer> possibleAnswers) {
		this.possibleAnswers = possibleAnswers;
	}
	
	
}
