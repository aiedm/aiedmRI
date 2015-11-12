package com.ai.crm.customer.test;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.common.rootentity.domain.service.interfaces.IEventPublisher;
import com.ai.crm.common.party.domain.event.PartyNameChanged;
import com.ai.crm.common.party.domain.model.Individual;
import com.ai.crm.customer.domain.model.IndividualCustomer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/root-context.xml","classpath:spring/appServlet/servlet-context.xml"})
@ActiveProfiles("dev")
public class CustomerTests{
	@Autowired
	private IEventPublisher eventPublisher;
	
	@Test
	@Transactional
	public void custmoerShouldNotBeNull() {
		//assertEquals(1,customerRepository.saveIndividualCustomer(indiCustomer).getId());
		Individual zhanglh=new Individual("zhang","lianhua");
		IndividualCustomer indiCustomer=new IndividualCustomer(zhanglh);
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
