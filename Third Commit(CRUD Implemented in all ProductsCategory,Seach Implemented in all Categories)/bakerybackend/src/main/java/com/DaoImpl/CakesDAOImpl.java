package com.DaoImpl;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.CakesDAO;
import com.model.Bread;
import com.model.Cakes;

@Repository
public class CakesDAOImpl implements CakesDAO {
	@Autowired
	SessionFactory sessionFac;
	
	
	@SuppressWarnings("unchecked")
	public  List<Cakes> getAllCakes() {
		Session session = sessionFac.openSession();
		session.beginTransaction();
		List<Cakes> cakeslist = session.createQuery("from Cakes").list();
		session.getTransaction().commit();
		session.close();
		return cakeslist;
		
	}
	
	public Cakes getCakes(int ID) {
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		Cakes p = (Cakes) session.load(Cakes.class,new Integer(ID));
		System.out.println("===================> p =" +p);
		session.getTransaction().commit();
		session.close();
		return p;
		
	}
	
	public Cakes getCakesName(String Name) {
		String hql = "FROM Cakes c  where c.NAME = :Name";
		Session session=sessionFac.openSession();	
		Query query = session.createQuery(hql);
		query.setParameter("Name",Name);
		session.beginTransaction();
		System.out.println("Hereitis");
		Cakes p = (Cakes) query.uniqueResult();
		System.out.println("Hereitis");
		
		session.getTransaction().commit();
		session.close();
		return p;
		
	}
	
	public void createCakes(Cakes cakes){

		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.persist(cakes);
		session.getTransaction().commit();
		session.close();
	}
	
	public void deleteCakes(Cakes cakes) {
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.delete(cakes);
		session.getTransaction().commit();
		session.close();
		
	}
	public void updateCakes(Cakes cakes) {
		
		System.out.println("-------------------------------->bread details in dao : "+cakes.getID());
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.update(cakes);
		System.out.println("----------------------------> updated------------------------------>");
		session.getTransaction().commit();
		System.out.println("-----------------------------> committed---------------------------->");
		//session.flush();
		System.out.println("---------------------------------> session is closing-------------------->");
		session.close();
		
	}
	
	public CakesDAOImpl(SessionFactory sessionFactory)
	{
		super();
		sessionFac=sessionFactory;
		
	}	
	

	
}
