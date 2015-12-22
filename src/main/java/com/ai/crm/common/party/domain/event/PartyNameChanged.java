package com.ai.crm.common.party.domain.event;

import org.springframework.context.ApplicationEvent;

import com.ai.common.bpmn.model.BaseEvent;

public class PartyNameChanged extends BaseEvent{
	private String newFirstname;
	public String getNewFirstname() {
		return newFirstname;
	}

	public String getNewLastname() {
		return newLastname;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String newLastname;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PartyNameChanged(Object source,String newFirstName,String newLastName) {
		super(source);
		this.newFirstname=newFirstName;
		this.newLastname=newLastName;
		System.out.println("event received:"+newFirstName+" "+newLastName);
	}

}
