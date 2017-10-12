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
import com.DaoImpl.BreadDAOImpl;
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
		dt.setUrl("jdbc:h2:tcp://localhost/~/test");
		dt.setUsername("sa");
		dt.setPassword("");
		System.out.println("conncection es");
		return dt;
	}
	private Properties getHiberProps(){
		Properties p=new Properties();
		p.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		p.put("hibernate.show_sql","true");
		p.put("hibernate.hbm2dml.auto", "select");
		return p;
	}
		@Autowired
		@Bean(name="BreadDAO")
		public BreadDAO getAllBread (SessionFactory sessionFac) {
			return new BreadDAOImpl(sessionFac);
			
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
			lsfb.addAnnotatedClass(Bread.class);
			return lsfb.buildSessionFactory();
		}		
		
	}


	
	/* @Autowired
	 * @Bean("name=CakesDAO")
	public CakesDAO getCakesDAO(SessionFactory sessionFactory)
	{
		System.out.println("CakesDAO object creation");
		return new CakesDAO(sessionFactory);
	}
	@Autowired
	@Bean("name=PastriesDAO")
	public PastriesDAO getPastriesDAO(SessionFactory sessionFactory)
	{
		System.out.println("PastriesDAO object creation");
		return new PastriesDAO(sessionFactory);
	}
	@Autowired
	@Bean("name=PiesDAO")
	public PiesDAO getPiesDAO(SessionFactory sessionFactory)
	{
		System.out.println("PiesDAO object creation");
		return new PiesDAO(sessionFactory);
	}

	@Bean("name=RegisterDAO")
	public RegisterDAO getRegisterDAO(SessionFactory sessionFactory)
	{
		System.out.println("cartDAO object creation");
		return new RegisterDAO(sessionFactory);
	}
*/

	


