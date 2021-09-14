package com.ibm.training.spring.configuration;




import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.ibm.training.spring.mvc.domain.Student;
import com.ibm.training.spring.mvc.vault.SecretPasswordVault;

@Configuration
public class DataSourceConfig {
	
	@Bean
	public DataSource dataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/training?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword(SecretPasswordVault.getPassword());
		return dataSource;
	}
	
	@Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setAnnotatedClasses(Student.class );
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }
	//transaction manager->session->connection->query
	@Bean
    public PlatformTransactionManager hibernateTransactionManager(DataSource dataSource) {
        HibernateTransactionManager transactionManager
          = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory(dataSource).getObject());
        return transactionManager;
    }
	 
	 private final Properties hibernateProperties() {
	        Properties hibernateProperties = new Properties();
	        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	        hibernateProperties.setProperty("hibernate.show_sql", "true");
	        return hibernateProperties;
	    }

}
