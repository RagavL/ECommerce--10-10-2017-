package com.DaoImpl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.*;
import com.model.*;




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
	
	public User getUserName(String Name) {
		String hql = "FROM User b  where b.username = :Name";
		Session session=sessionFac.openSession();	
		Query query = session.createQuery(hql);
		query.setParameter("Name",Name);
		session.beginTransaction();
		User p = (User) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return p;
		
	}
	
	public void updateuser(User user){
		
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		super();
		sessionFac=sessionFactory;
		
	}
}
