package com.ai.common.bpmn.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class ServiceTask extends Activity {

	public ServiceTask() {
	}
	private long id;
	private String name;
	private String code;
	private String packageName;
	private String serviceType;
	private String serviceName;
	private Set<ServiceTaskParameter> parameters = new LinkedHashSet<ServiceTaskParameter>(); 
	
	@Override
	public String toGroovyString() {
		StringBuffer sb=new StringBuffer();
		sb.append(this.toLowerCaseServiceName())
		.append(".")
		.append(this.getServiceName())
		.append("(");
		int i=0;
		for (ServiceTaskParameter serviceTaskParameter : parameters) {
			sb.append(" ").append(serviceTaskParameter.getParameter());
			if (i==parameters.size()-1){
				sb.append(")");
			}else{
				sb.append(",");
			}
			i++;
		}
		return sb.toString();
	}
	
	public String toLowerCaseServiceName(){
		String firstChar=this.getServiceType().substring(0);
		String other=this.getServiceType().substring(1,this.getServiceType().length());
		String lowerCaseName=firstChar.toLowerCase()+other;
		return lowerCaseName;
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

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Set<ServiceTaskParameter> getParameters() {
		return parameters;
	}
	
	public void addParameter(ServiceTaskParameter parameter) {
		if (null!=parameter){
			this.parameters.add(parameter);
			parameter.setServiceTask(this);
		}
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

}
