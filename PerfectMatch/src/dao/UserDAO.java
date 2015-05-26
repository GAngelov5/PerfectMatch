package dao;

import java.security.MessageDigest;
import java.util.Collection;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import models.User;

@Singleton
public class UserDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public UserDAO(EntityManager em) {
		this.em = em;
	}
	
	public void addUser(User user) {
		user.setPassword(getHashedPassword(user.getPassword()));
		em.persist(user);
	}
	
	public Collection<User> getAllUsers() {
		
		String text = "SELECT u FROM User u";
		TypedQuery<User> query = em.createNamedQuery(text,User.class);
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Collection<User> getUsersByGender(String gender) {
		String text = "SELECT u from User u WHERE u.gender =:gender";
		TypedQuery<User> query = em.createNamedQuery(text,User.class);
		query.setParameter("gender", gender);
		try {
			return query.getResultList();
		} catch (NoResultException e ) {
			return null;
		}
	}
	
	public String getFacebookByUserId(int userId) {
		String text = "SELECT u from User u WHERE u.id =:userId";
		TypedQuery<User> query = em.createNamedQuery(text,User.class);
		query.setParameter("id", userId);
		try {
			return query.getSingleResult().getFacebook();
		} catch (NoResultException e ) {
			return null;
		}
	}
	
    public User findUserByName(String userName) {
        String txtQuery = "SELECT u FROM User u WHERE u.name = :userName";
        TypedQuery<User> query = em.createQuery(txtQuery, User.class);
        query.setParameter("name", userName);
        return queryUser(query);
    }

    private User queryUser(TypedQuery<User> query) {
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean validateUserCredentials(String userName, String password) {
        String txtQuery = "SELECT u FROM User u WHERE u.name=:userName AND u.password=:password";
        TypedQuery<User> query = em.createQuery(txtQuery, User.class);
        query.setParameter("name", userName);
        query.setParameter("password", getHashedPassword(password));
        return queryUser(query) != null;
    }
    
    private String getHashedPassword(String password) {
        try {
            MessageDigest mda = MessageDigest.getInstance("SHA-512");
            password = new String(mda.digest(password.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }
}
