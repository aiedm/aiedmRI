package com.ai.common.bpmn.model;


public class EventListener {
	private EventListenerSet eventListenerSet;
	private BaseEvent event;
	private long id;
	private String name;
	private String code;
	private Activity onEventActivity;

	
	public EventListener() {
		// TODO Auto-generated constructor stub
	}
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
	public Activity getOnEventActivity() {
		return onEventActivity;
	}
	public void setOnEventActivity(Activity onEventActivity) {
		this.onEventActivity = onEventActivity;
	}
	public EventListenerSet getEventListenerSet() {
		return eventListenerSet;
	}
	public void setEventListenerSet(EventListenerSet eventListenerSet) {
		this.eventListenerSet = eventListenerSet;
	}
	
	public String toGroovyString(){
		StringBuffer sb=new StringBuffer();
		if (this.getOnEventActivity() instanceof ServiceTask){
			ServiceTask service=(ServiceTask)this.getOnEventActivity();
			sb.append("@Autowired\n")
			.append(service.getPackageName()).append(".").append(service.getServiceType())
			.append(" ").append(service.toLowerCaseServiceName()).append(";").append("\n");
		}		
		sb.append("@EventListener")
		.append("public void on")
		.append(this.getEvent().getCode())
		.append("(").append(this.getEvent().getPackageName()).append(".").append(this.getEvent().getCode())
		.append(" event").append("){\n")
		.append(this.getOnEventActivity().toGroovyString())
		.append("}\n");
		return sb.toString();
	}

}
