package models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "Answer")
public class Answer implements Serializable {

	private static final long serialVersionUID = -615479004370454815L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String content;

	private int points;

	@ManyToOne
	private Question questionId;

	Answer() {
	}
	
	public Answer(int points){
		System.out.println(points);
	}
	
	public Answer(int id, String content, int points, Question questionId) {
		this.id = id;
		this.content = content;
		this.points = points;
		this.questionId = questionId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Question getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Question questionId) {
		this.questionId = questionId;
	}

	
}
