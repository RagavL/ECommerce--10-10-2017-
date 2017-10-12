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
import com.Dao.CakesDAO;
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
	
	public CakesDAOImpl(SessionFactory sessionFactory)
	{
		super();
		sessionFac=sessionFactory;
		
	}	
	

	
}
