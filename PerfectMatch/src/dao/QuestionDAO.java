package dao;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import models.Question;

@Singleton
public class QuestionDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public QuestionDAO(EntityManager em) {
		this.em = em;
	}
	
	public void addQuestion(Question question) {
		em.persist(question);
	}
	
	public String getQuestionById(long id) {
		String text = "SELECT q FROM Questions q WHERE q.id =:id";
		TypedQuery<Question> query = em.createNamedQuery(text,Question.class);
		query.setParameter("id", id);
		try {
			return query.getSingleResult().getContent();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
