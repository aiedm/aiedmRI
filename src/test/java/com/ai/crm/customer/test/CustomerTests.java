package com.ai.crm.customer.test;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.common.rootentity.domain.service.interfaces.IEventPublisher;
import com.ai.crm.common.party.domain.event.PartyNameChanged;
import com.ai.crm.common.party.domain.model.Department;
import com.ai.crm.common.party.repository.interfaces.IPartyRepository;
import com.ai.crm.customer.domain.model.IndividualCustomer;
import com.ai.crm.customer.domain.model.LegalCustomer;
import com.ai.crm.customer.repository.interfaces.ICustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/root-context.xml","classpath:spring/appServlet/servlet-context.xml"})
@ActiveProfiles("dev")
public class CustomerTests{
	@Autowired 
	private IndividualCustomer indiCustomer;
	@Autowired
	private LegalCustomer legalCustomer;
	@Autowired
	private Department department;
	@Autowired
	private IPartyRepository partyRepository;
	@Autowired
	private ICustomerRepository customerRepository;	
	@Autowired
	private IEventPublisher eventPublisher;
	
	@Test
	@Transactional
	public void custmoerShouldNotBeNull() {
		//assertEquals(1,customerRepository.saveIndividualCustomer(indiCustomer).getId());
		indiCustomer.getIndividual().setFirstName("IT zhang");
		PartyNameChanged partyNameChanged=new PartyNameChanged(this,"IT zhang","zhang");
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
