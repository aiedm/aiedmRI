package com.ai.crm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ai.crm.common.party.domain.model.impl.Department;
import com.ai.crm.common.party.domain.model.impl.Individual;
import com.ai.crm.common.party.domain.model.impl.LegalOrganization;
import com.ai.crm.common.party.domain.model.interfaces.IDepartment;
import com.ai.crm.common.party.domain.model.interfaces.IIndividual;
import com.ai.crm.common.party.domain.model.interfaces.ILegalOrganization;
import com.ai.crm.common.party.eventlistener.PartyNameChangeEventListener;
import com.ai.crm.common.party.repository.impl.PartyRepository;
import com.ai.crm.common.party.repository.interfaces.IPartyRepository;
import com.ai.crm.customer.domain.model.impl.IndividualCustomer;
import com.ai.crm.customer.domain.model.impl.LegalCustomer;
import com.ai.crm.customer.domain.model.interfaces.IIndividualCustomer;
import com.ai.crm.customer.domain.model.interfaces.ILegalCustomer;
import com.ai.crm.customer.repository.impl.CustomerRepository;
import com.ai.crm.customer.repository.interfaces.ICustomerRepository;
import com.ai.flyingshuttle.base.service.impl.SpringEventPublisher;
import com.ai.flyingshuttle.base.service.interfaces.IEventPublisher;

@Configuration
@EnableTransactionManagement
@Profile("dev")
@ComponentScan(basePackages={"com.ai.crm", "com.ai.flyingshutter"})
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
		sfb.setPackagesToScan(new String[] { "com.ai.crm.common.party.domain.model.impl",
				"com.ai.crm.customer.domain.model.impl"});
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
	public IIndividual individual(){
		return new Individual("Lianhua","Zhang");
	}

	@Bean
	public ILegalOrganization legalOrganization(){
		return new LegalOrganization("Asiainfo");
	}
	

	@Bean
	public IDepartment department(ILegalOrganization legalOrganization){
		return new Department(legalOrganization,"ADA");
	}	

	
	@Bean
	public IIndividualCustomer individualCustomer(IIndividual individual){
		return new IndividualCustomer(individual);
	}

	@Bean
	public ILegalCustomer organizationCustomer(ILegalOrganization legalOrganization){
		return new LegalCustomer(legalOrganization);
	}

}
