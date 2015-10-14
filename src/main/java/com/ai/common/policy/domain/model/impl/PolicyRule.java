package com.ai.common.policy.domain.model.impl;

import java.util.HashSet;
import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyAction;
import com.ai.common.policy.domain.model.interfaces.IPolicyCondition;
import com.ai.common.policy.domain.model.interfaces.IPolicyRule;
import com.ai.common.policy.domain.model.interfaces.IPolicySetInputParameter;

public class PolicyRule extends PolicySet implements IPolicyRule {
	private boolean isElseAction;
	private IPolicyCondition condition;
	private IPolicyAction action;
	private Set<IPolicySetInputParameter> inputParameters=new HashSet<IPolicySetInputParameter>();

	public PolicyRule() {
	}

	@Override
	public IPolicyCondition getCondition() {
		return this.condition;
	}

	@Override
	public void setCondition(IPolicyCondition condition) {
		this.condition=condition;
	}

	@Override
	public IPolicyAction getAction() {
		return this.action;
	}

	@Override
	public void getAction(IPolicyAction action) {
		this.action=action;
	}

	@Override
	public boolean isElseAction() {
		return this.isElseAction;
	}

	@Override
	public String toBodyString() {
		StringBuffer bf=new StringBuffer();
		if (this.isElseAction()){
			bf.append(this.getAction().toBodyString()).append(";\n");
		}else{
			bf.append("if ").append(this.getCondition().toBodyString()).append("{\n")
			.append("    ").append(this.getAction().toBodyString()).append(";\n")
			.append("}\n");			
		}		
		return bf.toString();
	}

	@Override
	public void setElseAction(boolean isElseAction) {
		this.isElseAction=isElseAction;		
	}
	
	@Override
	public void addInputParameter(IPolicySetInputParameter param) {
		if(null!=param){
			inputParameters.add(param);
		}
	}	


	@Override
	public Set<IPolicySetInputParameter> getInputParameters() {
		return this.inputParameters;
	}

}
