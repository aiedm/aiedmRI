package com.ai.common.rootentity.domain.model;

public class EventListener {
	private BaseEvent event;
	private long id;
	private String name;
	public BaseEvent getEvent() {
		return event;
	}

	public void setEvent(BaseEvent event) {
		this.event = event;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getListenerService() {
		return listenerService;
	}

	public void setListenerService(String listenerService) {
		this.listenerService = listenerService;
	}

	public String getListenerMethod() {
		return listenerMethod;
	}

	public void setListenerMethod(String listenerMethod) {
		this.listenerMethod = listenerMethod;
	}

	private String code;
	private String listenerService;
	private String listenerMethod;
	
	public EventListener() {
		// TODO Auto-generated constructor stub
	}

}
