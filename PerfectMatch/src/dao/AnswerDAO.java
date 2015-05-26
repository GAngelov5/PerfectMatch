package dao;

import java.util.Collection;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import models.Answer;

@Singleton
public class AnswerDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void addAnswer(Answer answer) {
		em.persist(answer);
	}
	
	public int getPointsByContentAndQuestionId(String content, int questionId) {
		String text = "SELECT a.points FROM Answer a WHERE a.content =: content AND a.questionId =: questionId";
		TypedQuery<Integer> query = em.createNamedQuery(text, Integer.class);
		query.setParameter("content", content);
		query.setParameter("questionId", questionId);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return 0;
		}
	}
	
	public Collection<String> getAnswersByQuestionId(int questionId) {
		String text = "SELECT a.content FROM Answer a WHERE a.questionId =:questionId";
		TypedQuery<String> query = em.createNamedQuery(text,String.class);
		query.setParameter("questionId", questionId);
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
}
