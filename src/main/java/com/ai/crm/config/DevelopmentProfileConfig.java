package com.ai.crm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ai.common.rootentity.domain.service.impl.SpringEventPublisher;
import com.ai.common.rootentity.domain.service.interfaces.IEventPublisher;
import com.ai.crm.common.party.domain.model.Department;
import com.ai.crm.common.party.domain.model.Individual;
import com.ai.crm.common.party.domain.model.LegalOrganization;

import com.ai.crm.common.party.eventlistener.PartyNameChangeEventListener;
import com.ai.crm.common.party.repository.impl.PartyRepository;
import com.ai.crm.common.party.repository.interfaces.IPartyRepository;
import com.ai.crm.customer.domain.model.IndividualCustomer;
import com.ai.crm.customer.domain.model.LegalCustomer;

import com.ai.crm.customer.repository.impl.CustomerRepository;
import com.ai.crm.customer.repository.interfaces.ICustomerRepository;

@Configuration
@EnableTransactionManagement
@Profile("dev")
@ComponentScan(basePackages={"com.ai"})
public class DevelopmentProfileConfig {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Bean
	public PartyNameChangeEventListener partyNameChangeEventListener(){
		return new PartyNameChangeEventListener();
	} 
	
	@Bean
	public IEventPublisher eventPublisher(){
		return new SpringEventPublisher();
	}
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.hsqldb.jdbcDriver");
		ds.setUrl("jdbc:hsqldb:hsql://localhost/mydbname");
		ds.setUsername("sa");
		ds.setPassword("");
		//ds.setInitialSize(5);
		//ds.setMaxIdle(3);
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource) {
		LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
		sfb.setDataSource(dataSource);
		sfb.setPackagesToScan(new String[] { "com.ai"});
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		props.setProperty("hibernate.hbm2ddl.auto", "create");
		props.setProperty("hibernate.show_sql", "true");
		sfb.setHibernateProperties(props);
		return sfb;
	}	

	public BeanPostProcessor persistenceTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}	
	
	@Bean
	public IPartyRepository partyRepository(){
		return new PartyRepository(sessionFactory);
	}
	
	@Bean
	public ICustomerRepository customerRepository(){
		return new CustomerRepository(sessionFactory);
	}

	@Bean
	public Individual individual(){
		return new Individual("Lianhua","Zhang");
	}

	@Bean
	public LegalOrganization legalOrganization(){
		return new LegalOrganization("Asiainfo");
	}
	

	@Bean
	public Department department(LegalOrganization legalOrganization){
		return new Department(legalOrganization,"ADA");
	}	

	
	@Bean
	public IndividualCustomer individualCustomer(Individual individual){
		return new IndividualCustomer(individual);
	}

	@Bean
	public LegalCustomer organizationCustomer(LegalOrganization legalOrganization){
		return new LegalCustomer(legalOrganization);
	}

}
