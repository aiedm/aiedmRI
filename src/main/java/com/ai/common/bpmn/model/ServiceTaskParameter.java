package com.ai.common.bpmn.model;

public class ServiceTaskParameter {

	public ServiceTaskParameter(ServiceTask task,BaseEvent fromEvent) {
		this.setServiceTask(task);
	}
	
	private long id;
	private ServiceTask serviceTask;
	private String parameter;
	public ServiceTask getServiceTask() {
		return serviceTask;
	}
	public void setServiceTask(ServiceTask serviceTask) {
		this.serviceTask = serviceTask;
	}

	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
