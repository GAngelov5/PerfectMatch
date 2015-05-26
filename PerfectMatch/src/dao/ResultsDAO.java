package dao;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import models.Answer;
import models.Results;

@Singleton
public class ResultsDAO {

	@PersistenceContext
	private EntityManager em;

	public ResultsDAO(EntityManager em) {
		this.em = em;
	}

	public void addResult (Results res) {
		em.persist(res);
	}
	
	public Collection<Integer> getPointsByUserId(int userId) {
		String text = "SELECT a FROM Answer a WHERE a.id IN"
				+ " ( SELECT r FROM Results r WHERE r.userId =: userId";
		TypedQuery<Answer> query = em.createNamedQuery(text, Answer.class);

		try {
			List<Integer> pointsList = new LinkedList<Integer>();
			for (Answer a : query.getResultList()) {
				pointsList.add(a.getPoints());
			}
			return pointsList;
		} catch (NoResultException e) {
			return null;
		}
	}

}
