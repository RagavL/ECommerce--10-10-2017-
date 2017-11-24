package com.DaoImpl;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Dao.*;
import com.model.*;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	SessionFactory sessionFac;

	@SuppressWarnings("unchecked")
	public  List<Product> getAllProduct() {
		Session session = sessionFac.openSession();
		session.beginTransaction();
		List<Product> prodlist = session.createQuery("from Product").list();
		session.getTransaction().commit();
		session.close();
		return prodlist;
		
	}
	
	public Product getProductbyID(int ID) {
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		Product p = (Product) session.load(Product.class,new Integer(ID));
		System.out.println("===================> p =" +p);
		session.getTransaction().commit();
		session.close();
		return p;
		
	}
	
	public Product getProductbyName(String Name) {
		String hql = "FROM Product p  where p.pname = :Name";
		Session session=sessionFac.openSession();	
		Query query = session.createQuery(hql);
		query.setParameter("Name",Name);
		session.beginTransaction();
		Product p = (Product) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return p;
	}
	
	public void createProduct(Product product){
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.persist(product);
		session.getTransaction().commit();
		session.close();
	}
	
	public void updateProduct(Product product){
		
		System.out.println("-------------------------------->bread details in dao : "+product.getPid());
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.update(product);
		System.out.println("----------------------------> updated------------------------------>");
		session.getTransaction().commit();
		System.out.println("-----------------------------> committed---------------------------->");
		//session.flush();
		System.out.println("---------------------------------> session is closing-------------------->");
		session.close();
	}
	
	public void deleteProduct(Product product){
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.delete(product);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Product> getProductbyCatID(int catid){
		String hql = "FROM Product p  where p.catid = :ID";
		Session session=sessionFac.openSession();	
		Query query = session.createQuery(hql);
		query.setParameter("ID",catid);
		session.beginTransaction();
		List <Product> prodlist =query.list();
		session.getTransaction().commit();
		session.close();
		return prodlist;
		
	}
	
	public Product setData(int pid,String Pname,String Desc,float pprice,float qty){
		Product p = new Product();
		p.setPid(pid);
		p.setPname(Pname);
		p.setDescription(Desc);
		p.setPprice(pprice);
		p.setQuantity(qty);
		return p;
	}
	
	public int getMaxPID()
	{
		String hql = "SELECT max(pid) FROM Product";
		Session session=sessionFac.openSession();	
		Query query = session.createQuery(hql);
		session.beginTransaction();
		List<Integer> n = query.list();
		int no = n.get(0);
		System.out.println(n);
		System.out.println(n);
		session.getTransaction().commit();
		session.close();
		return no;
	}
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		super();
		sessionFac=sessionFactory;
		
	}	
	
}
