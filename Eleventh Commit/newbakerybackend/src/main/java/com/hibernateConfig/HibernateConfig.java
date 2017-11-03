package com.hibernateConfig;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.Dao.*;
import com.DaoImpl.*;
import com.model.*;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class HibernateConfig {
	@Autowired
	@Bean(name="datasource")
	public DataSource getH2() {
		System.out.println("Hibernate initiated");
		DriverManagerDataSource dt=new DriverManagerDataSource();
		dt.setDriverClassName("org.h2.Driver");
		dt.setUrl("jdbc:h2:tcp://localhost/~/testnew");
		dt.setUsername("sanew");
		dt.setPassword("");
		System.out.println("connection established");
		return dt;
	}
	private Properties getHiberProps(){
		Properties p=new Properties();
		p.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		p.put("hibernate.show_sql","true");
		p.put("hibernate.hbm2ddl.auto","update");
		return p;
	}
		
		
		@Autowired
		@Bean(name="UserDAO")
		public UserDAO getAllUsers(SessionFactory sessionFac) {
			return new UserDAOImpl(sessionFac);
		
		}
		
		@Autowired
		@Bean(name="CartDAO")
		public CartDAO getAllCarts(SessionFactory sessionFac) {
			return new CartDAOImpl(sessionFac);
		
		}
		@Autowired
		@Bean(name="OrderDAO")
		public OrderDAO createDAO(SessionFactory sessionFac) {
			return new OrderDAOImpl(sessionFac);
		
		}
		
		@Autowired
		@Bean(name="ProductDAO")
		public ProductDAO createpDAO(SessionFactory sessionFac) {
			return new ProductDAOImpl(sessionFac);
		
		}
		@Autowired
		@Bean(name="CategoryDAO")
		public CategoryDAO createcDAO(SessionFactory sessionFac) {
			return new CategoryDAOImpl(sessionFac);
		
		}
		
		
		
		@Autowired
		@Bean(name="transactionManager")
		public HibernateTransactionManager getTransaction(SessionFactory sessionFactory) {
			
			HibernateTransactionManager tm=new HibernateTransactionManager(sessionFactory);
			return tm;
		}
		@Autowired
		@Bean(name="sessionFactory")
		public SessionFactory getSession(DataSource datasource) {
			LocalSessionFactoryBuilder lsfb=new LocalSessionFactoryBuilder(datasource);
			lsfb.addProperties(getHiberProps());
			lsfb.addAnnotatedClass(User.class);
			lsfb.addAnnotatedClass(Cart.class);
			lsfb.addAnnotatedClass(OrderDetails.class);
			lsfb.addAnnotatedClass(Product.class);
			lsfb.addAnnotatedClass(Category.class);
			return lsfb.buildSessionFactory();
		}		
		
	}


	

	


