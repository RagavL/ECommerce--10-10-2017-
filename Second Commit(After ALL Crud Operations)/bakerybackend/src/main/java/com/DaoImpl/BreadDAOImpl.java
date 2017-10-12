package com.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
	public Bread getBread(int ID) {
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		Bread p = (Bread) session.load(Bread.class,new Integer(ID));
		System.out.println("===================> p =" +p);
		session.getTransaction().commit();
		session.close();
		return p;
		
	}
	public void createBread(Bread bread){

		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.persist(bread);
		session.getTransaction().commit();
		session.close();
	}
	
	public void deleteBread(Bread bread) {
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.delete(bread);
		session.getTransaction().commit();
		session.close();
		
	}
	public void updateBread(Bread bread) {
		
		System.out.println("-------------------------------->bread details in dao : "+bread.getID());
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.update(bread);
		System.out.println("----------------------------> updated------------------------------>");
		session.getTransaction().commit();
		System.out.println("-----------------------------> committed---------------------------->");
		//session.flush();
		System.out.println("---------------------------------> session is closing-------------------->");
		session.close();
		
	}
	
	public BreadDAOImpl(SessionFactory sessionFactory)
	{
		super();
		sessionFac=sessionFactory;
		
	}	
	
		 
		
		
		
	

}
