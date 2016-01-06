package com.ai.common.bpmn.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class EventListenerSet {
	private Set<EventListener> eventListeners=new LinkedHashSet<EventListener>();
	private String name;
	private String code;

	public EventListenerSet() {
	}
	
	public  Set<EventListener> getEventListeners(){
		return  this.eventListeners;
	}
	
	public void addEventListener(EventListener eventListener){
		if (null!=eventListener){
			this.eventListeners.add(eventListener);
			eventListener.setEventListenerSet(this);
		}
	}
	
	public String toImportString(){
		StringBuffer sb=new StringBuffer();
		sb.append("import org.springframework.beans.factory.annotation.Autowired;\n")
		.append("import org.springframework.context.event.EventListener;\n")
		.append("import org.springframework.stereotype.Component;\n");
		return sb.toString();
	}
	
	public String toServiceDeclareString(){
		StringBuffer sb=new StringBuffer();
		Set<ServiceTask> serviceTaks=new LinkedHashSet<ServiceTask>();
		for (EventListener eventListener : eventListeners) {
			if (eventListener.getOnEventActivity() instanceof ServiceTask){
				ServiceTask service=(ServiceTask)eventListener.getOnEventActivity();
				serviceTaks.add(service);
			}
		}
		if(serviceTaks.size()>0){
			for (ServiceTask serviceTask : serviceTaks) {
				sb.append("    ").append("@Autowired\n")
				.append("    ").append(serviceTask.getPackageName()).append(".").append(serviceTask.getServiceType())
				.append(" ").append(serviceTask.toLowerCaseServiceName()).append(";").append("\n");
			}
		}
		return sb.toString();
	}
	
	public String toMethodBodyString() throws Exception{
		StringBuffer sb=new StringBuffer();
		for (EventListener eventListener : eventListeners) {
			sb.append(eventListener.toGroovyString())
			.append("\n\n");
		}
		return sb.toString();
	}
	
	public String toClassHeadDeclareString(){
		StringBuffer fileContent=new StringBuffer();
		fileContent.append("class ").append(this.getCode()).append("(){\n")
		.append("    ").append("public ").append(this.getCode()).append("(){}\n");
		return fileContent.toString();
	}
	
	public String toClassFootDeclareString(){
		StringBuffer fileContent=new StringBuffer();
		fileContent.append("}\n");
		return fileContent.toString();
	}	

	public String toGroovyString() throws Exception{
		StringBuffer fileContent=new StringBuffer();
		fileContent.append(this.toImportString())
		.append(this.toClassHeadDeclareString())
		.append(this.toServiceDeclareString())
		.append(this.toMethodBodyString())
		.append(this.toClassFootDeclareString());
		return fileContent.toString();
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
}
