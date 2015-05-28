package models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "Questions")
public class Question implements Serializable {

	private static final long serialVersionUID = -6481077227033717089L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String content;
	
	public Question() {
		
	}
	
	public Question(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContest(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
