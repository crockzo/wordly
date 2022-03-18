package in.wordly.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"in.wordly"})
@EnableTransactionManagement
public class HibernateConfiguration {

	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/wordly?useSSL=false&serverTimezone=UTC";
	private static final String DATABASE_USER = "root";
	private static final String DATABASE_PASSWORD = "root";
	private static final String DATABASE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";
	
	
	@Bean
	public DataSource getDataSOurce() {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(DATABASE_URL);
		ds.setUsername(DATABASE_USER);
		ds.setPassword(DATABASE_PASSWORD);
		ds.setDriverClassName(DRIVER_NAME);
		
		return ds;
	}
	
	
	@Bean
	public SessionFactory getSessionFactory(DataSource ds) {
		LocalSessionFactoryBuilder sessionfactory = new LocalSessionFactoryBuilder(ds);
		sessionfactory.addProperties(getProperties());
		sessionfactory.scanPackages("in.wordly.model");
		return sessionfactory.buildSessionFactory();
	}
	
	private Properties getProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManage(SessionFactory sessionFactory) {
		HibernateTransactionManager manager = new HibernateTransactionManager(sessionFactory);
		return manager;
	}
	
}
