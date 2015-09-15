package com.ai.crm.customer.test;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.crm.common.party.domain.event.PartyNameChanged;
import com.ai.crm.common.party.domain.model.interfaces.IDepartment;
import com.ai.crm.common.party.domain.model.interfaces.ILegalOrganization;
import com.ai.crm.common.party.repository.interfaces.IPartyRepository;
import com.ai.crm.config.DevelopmentProfileConfig;
import com.ai.crm.customer.domain.model.interfaces.IIndividualCustomer;
import com.ai.crm.customer.domain.model.interfaces.ILegalCustomer;
import com.ai.crm.customer.repository.interfaces.ICustomerRepository;
import com.ai.flyingshuttle.base.service.interfaces.IEventPublisher;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DevelopmentProfileConfig.class)
@ActiveProfiles("dev")
public class CustomerTests{
	@Autowired 
	private IIndividualCustomer indiCustomer;
	@Autowired
	private ILegalCustomer legalCustomer;
	@Autowired
	private IDepartment department;
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
