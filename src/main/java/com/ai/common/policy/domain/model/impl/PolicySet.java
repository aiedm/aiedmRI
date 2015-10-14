package com.ai.common.policy.domain.model.impl;

import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicySet;
import com.ai.common.policy.domain.model.interfaces.IPolicySetInputParameter;
import com.ai.common.policy.domain.model.interfaces.IPolicySetOutputParameter;
import com.ai.common.rootentity.domain.model.impl.InstanceEntity;

public abstract class PolicySet extends InstanceEntity implements IPolicySet {
	private long id;
	private String name;
	private String code;
	private IPolicySetOutputParameter outputParam;	
	public PolicySet() {
	}

	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public void setId(long id) {
		this.id=id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public void setCode(String code) {
		this.code=code;
	}

	@Override
	public boolean hasCharacteristic() {
		return false;
	}
	
	@Override
	abstract public Set<IPolicySetInputParameter> getInputParameters();

	@Override
	public IPolicySetOutputParameter getOutputParameter() {
		return this.outputParam;
	}

	@Override
	public void setOutputParameter(IPolicySetOutputParameter param) {
		this.outputParam=param;
	}	

	@Override
	public abstract String toBodyString();
	
	@Override
	public String toPolicyString() {
		StringBuffer constructorParam=new StringBuffer();
		StringBuffer constructorContentParam=new StringBuffer();
		StringBuffer declare=new StringBuffer();
		StringBuffer classBody=new StringBuffer();
		String className="aiPolicy"+this.getCode();
		StringBuffer classHead= new StringBuffer();
		StringBuffer constructor= new StringBuffer();
		String classEnd="}\n";
		String methodEnd="}\n";
		String constructorEnd="}\n";
		classHead.append("package com.ai.policy;\n")
		.append("Public class ")
		.append(className)
		.append("{\n");
		constructor.append("Public ").append(className).append("(");
		for (IPolicySetInputParameter param : this.getInputParameters()) {
			declare.append("private ")
			.append(param.getParameterType())
			.append(" ").append(param.getCode()).append(";\n");
			constructorParam.append(param.getParameterType())
			.append(" ").append(param.getCode()).append(",");
			constructorContentParam.append("this.").append(param.getCode())
			.append("=").append(param.getCode()).append(";\n");
		}
		constructorParam.delete(constructorParam.length()-1,constructorParam.length()-1);
		constructor.append(constructorParam.toString()).append(")\n")
		.append(constructorContentParam.toString())
		.append(constructorEnd);
		StringBuffer method= new StringBuffer();
		method.append("public ")
		.append(this.getOutputParameter().getParameterType())
		.append(" ").append("executePolicy() throws Exception {\n")
		.append(this.toBodyString())
		.append(methodEnd);
		classBody.append(classHead.toString())
		.append(declare.toString())
		.append(constructor.toString())
		.append(method.toString())
		.append(classEnd);
		return classBody.toString();
	}

}
