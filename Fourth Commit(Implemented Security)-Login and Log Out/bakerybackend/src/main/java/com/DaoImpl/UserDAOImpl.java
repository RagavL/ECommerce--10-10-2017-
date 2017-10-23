package com.DaoImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.UserDAO;
import com.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFac;
	
	
	@SuppressWarnings("unchecked")
	public  List<User> getAllUser() {
		Session session = sessionFac.openSession();
		session.beginTransaction();
		List<User> userlist = session.createQuery("from User").list();
		session.getTransaction().commit();
		session.close();
		return userlist;
		
	}
	
	public void insertUpdateUser(User user)
	{
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
		session.close();
	}
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		super();
		sessionFac=sessionFactory;
		
	}
}
