package com.ai.common.bpmn.model;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Activity {

	public Activity() {
	}
	private Gateway outputGateway;
	private Set<BaseEvent> outputEvents=new LinkedHashSet<BaseEvent>();
	
	
	public Set<BaseEvent> getOutputEvents(){
		return this.outputEvents;
	}	
	
	
	public void addOutputEvent(BaseEvent outputEvent){
		if (null!=outputEvent){
			this.outputEvents.add(outputEvent);
		}
	}
	
	public Gateway getOutputGateway() {
		return outputGateway;
	}
	public void setOutputGateway(Gateway outputGateway) {
		this.outputGateway = outputGateway;
	}
	
	protected abstract String toGroovyString();	

}
