package com.ai.crm.customer.test;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ai.common.rootentity.domain.service.interfaces.IEventPublisher;
import com.ai.crm.common.party.domain.event.PartyNameChanged;
import com.ai.crm.common.party.domain.model.Individual;
import com.ai.crm.common.party.domain.model.Party;
import com.ai.crm.common.party.repository.interfaces.IPartyRepository;
import com.ai.crm.config.DevelopmentProfileConfig;
import com.ai.crm.customer.domain.model.IndividualCustomer;
import com.ai.crm.customer.repository.interfaces.ICustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=DevelopmentProfileConfig.class)
@ContextConfiguration(locations={"classpath:spring/root-context.xml","classpath:spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
//@ActiveProfiles("dev")
@Transactional
@Commit
public class CustomerTests{
	@Autowired
	private IEventPublisher eventPublisher;
	@Autowired
	private ICustomerRepository customerRepository;
	@Autowired
	private IPartyRepository partyRepository;

	
	@Test
	public void custmoerShouldNotBeNull() throws Exception{
		
		Individual zhanglh=new Individual("zhang","lianhua");
		assertEquals("lianhua",partyRepository.saveIndividual(zhanglh).getLastName());
		zhanglh.setFirstName("IT zhang");
		assertEquals("IT zhang",partyRepository.findIndividualById(1).getFirstName());
		
		IndividualCustomer indiCustomer=new IndividualCustomer(zhanglh);
		assertEquals(1,customerRepository.saveIndividualCustomer(indiCustomer).getId());
		indiCustomer.getIndividual().setFirstName("IT zhang");
		PartyNameChanged partyNameChanged=new PartyNameChanged(this,"IT zhang","zhang");
		assertEquals("IT zhang",customerRepository.findIndividualCustomer(1).getIndividual().getFirstName());
		eventPublisher.publishEvent(partyNameChanged);
		
		/**
		assertEquals(2,customerRepository.saveLegalCustomer(legalCustomer).getId());
		assertEquals("Customer.Individual",customerRepository.findIndividualCustomer(1).getPartyRoleType());
		assertEquals("Customer.Legal",customerRepository.findLegalCustomer(2).getPartyRoleType());
		ILegalOrganization asia=(ILegalOrganization)customerRepository.findLegalCustomer(2).getParty();
		assertEquals("ADA",asia.getDepartments().get(0).getName());
		**/
	}
}
