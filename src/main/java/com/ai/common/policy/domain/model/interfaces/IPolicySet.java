package com.ai.common.policy.domain.model.interfaces;

import java.util.Map;
import java.util.Set;

import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntity;

public interface IPolicySet extends IInstanceEntity {
	long getId();
	void setId(long id);
	String getName();
	void setName(String name);
	String getCode();
	void setCode(String code);	
	String toBodyString();
	Set<IPolicySetInputParameter> getInputParameters();
	IPolicySetOutputParameter getOutputParameter();
	void setOutputParameter(IPolicySetOutputParameter param);
	String toPolicyString();
	String getVariableDeclareString();
	void setElseAction(IPolicyAction elseAction);
	IPolicyAction getElseAction();	
	void disableElseAction();
	Map<String,IPolicyVariable> getVariableMap();
}
