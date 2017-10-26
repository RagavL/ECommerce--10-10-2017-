package com.DaoImpl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.*;
import com.Dao.*;

@Repository
public class OrderDAOImpl implements OrderDAO {
	@Autowired
	SessionFactory sessionFac;
	
	public void insertOrder(OrderDetails order)
	{
		sessionFac.getCurrentSession().saveOrUpdate(order);
		
	}
	public List<OrderDetails> retrieveOrders(String username)
	{
		Query q=sessionFac.getCurrentSession().createQuery("from OrderDetails where username");
				q.setParameter("uname", username);
		List<OrderDetails> list=q.list();
		return list;
	}
		public OrderDetails getOrderDetails()
		{
			Session session=sessionFac.openSession();
			Query q=session.createQuery("from OrderDetails order by orderid");
			List<OrderDetails> list=q.list();
			if(list.size()>0)
			{
				return list.get(0);
			}
			else {
				return list.get(1);
			}
			}
		
		public OrderDAOImpl(SessionFactory sessionFactory)
		{
			super();
			sessionFac=sessionFactory;
			
		}	

}
