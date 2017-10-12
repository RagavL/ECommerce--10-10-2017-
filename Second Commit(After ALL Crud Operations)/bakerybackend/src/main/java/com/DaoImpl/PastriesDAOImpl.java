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
import com.Dao.PastriesDAO;
import com.model.Cakes;
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
	
	public PastriesDAOImpl(SessionFactory sessionFactory)
	{
		super();
		sessionFac=sessionFactory;
		
	}	

}
