package com.ai.common.bpmn.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class EventListenerSet {
	private Set<EventListener> eventListeners=new LinkedHashSet<EventListener>();
	private String packageName;
	private String name;
	private String code;

	public EventListenerSet() {
	}
	
	public  Set<EventListener> getEventListeners(){
		return  this.eventListeners;
	}
	
	public void addEventListener(EventListener eventListener){
		if (null!=eventListener){
			this.addEventListener(eventListener);
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
		return null;
	}
	
	public String toMethodBodyString(){
		StringBuffer sb=new StringBuffer();
		for (EventListener eventListener : eventListeners) {
			sb.append(eventListener.toGroovyString())
			.append("\n\n");
		}
		return sb.toString();
	}
	
	public String toClassHeadDeclareString(){
		StringBuffer fileContent=new StringBuffer();
		fileContent.append("@Component\n")
		.append("public class ").append(this.getCode()).append("(){\n")
		.append("public ").append(this.getCode()).append("(){}\n");
		return fileContent.toString();
	}
	
	public String toClassFootDeclareString(){
		StringBuffer fileContent=new StringBuffer();
		fileContent.append("}\n");
		return fileContent.toString();
	}	

	public String toGroovyString(){
		StringBuffer fileContent=new StringBuffer();
		fileContent.append(this.getPackageName()).append(";\n")
		.append(this.toImportString())
		.append(this.toClassHeadDeclareString())
		.append(this.toServiceDeclareString())
		.append(this.toMethodBodyString())
		.append(this.toClassFootDeclareString());
		return fileContent.toString();
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
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
