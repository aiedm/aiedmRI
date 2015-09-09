package com.ai.crm.common.party.eventlistener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ai.crm.common.party.domain.event.PartyNameChanged;
@Component
public class PartyNameChangeEventListener{
	@EventListener
	public void onApplicationEvent(PartyNameChanged event) {
		System.out.println("===============Party firstName changed to:"+event.getNewFirstname());
		System.out.println("===============Party lastName changed to:"+event.getNewLastname());		
	}
}
