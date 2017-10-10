package com.DaoImpl;
import java.util.*;
import java.util.logging.Logger;

import javax.transaction.Transaction;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Dao.BreadDAO;
import com.model.Bread;

@Repository
public class BreadDAOImpl implements BreadDAO {
	@Autowired
	SessionFactory sessionFac;
	//List<Bread> breads;
	
	
	@SuppressWarnings("unchecked")
	public  List<Bread> getAllBread() {
		Session session = sessionFac.openSession();
		session.beginTransaction();
		List<Bread> breadlist = session.createQuery("from Bread").list();
		session.getTransaction().commit();
		session.close();
		return breadlist;
		
	}
	
	public BreadDAOImpl(SessionFactory sessionFactory)
	{
		super();
		sessionFac=sessionFactory;
		
	}	
	
		 
		
		
		
	

}
