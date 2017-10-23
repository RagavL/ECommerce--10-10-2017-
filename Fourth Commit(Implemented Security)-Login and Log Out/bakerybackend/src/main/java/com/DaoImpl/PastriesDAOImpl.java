package com.DaoImpl;
import java.util.*;
import java.util.logging.Logger;
import javax.transaction.Transaction;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.Dao.PastriesDAO;

import com.model.Pastries;

@Repository
public class PastriesDAOImpl implements PastriesDAO {
	@Autowired
	SessionFactory sessionFac;
	
	@SuppressWarnings("unchecked")
	public  List<Pastries> getAllPastries() {
		Session session = sessionFac.openSession();
		session.beginTransaction();
		List<Pastries> Pastrieslist = session.createQuery("from Pastries").list();
		session.getTransaction().commit();
		session.close();
		return Pastrieslist;
		
	}
	public Pastries getPastries(int ID) {
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		Pastries p = (Pastries) session.load(Pastries.class,new Integer(ID));
		System.out.println("===================> p =" +p);
		session.getTransaction().commit();
		session.close();
		return p;
		
	}
	
	public Pastries getPastriesName(String Name) {
		String hql = "FROM Pastries p  where p.NAME = :Name";
		Session session=sessionFac.openSession();	
		Query query = session.createQuery(hql);
		query.setParameter("Name",Name);
		session.beginTransaction();
		System.out.println("Hereitis");
		Pastries p = (Pastries) query.uniqueResult();
		System.out.println("Hereitis");
		session.getTransaction().commit();
		session.close();
		return p;
		
	}
	
	public void createPastries(Pastries pastries){

		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.persist(pastries);
		session.getTransaction().commit();
		session.close();
	}
	
	public void deletePastries(Pastries pastries) {
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.delete(pastries);
		session.getTransaction().commit();
		session.close();
		
	}
	public void updatePastries(Pastries pastries) {
		
		System.out.println("-------------------------------->bread details in dao : "+pastries.getID());
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.update(pastries);
		System.out.println("----------------------------> updated------------------------------>");
		session.getTransaction().commit();
		System.out.println("-----------------------------> committed---------------------------->");
		//session.flush();
		System.out.println("---------------------------------> session is closing-------------------->");
		session.close();
		
	}
	public PastriesDAOImpl(SessionFactory sessionFactory)
	{
		super();
		sessionFac=sessionFactory;
		
	}	

}
