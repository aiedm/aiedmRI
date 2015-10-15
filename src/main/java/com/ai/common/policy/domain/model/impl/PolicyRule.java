package com.ai.common.policy.domain.model.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyAction;
import com.ai.common.policy.domain.model.interfaces.IPolicyCondition;
import com.ai.common.policy.domain.model.interfaces.IPolicyRule;
import com.ai.common.policy.domain.model.interfaces.IPolicySet;
import com.ai.common.policy.domain.model.interfaces.IPolicySetInputParameter;
import com.ai.common.policy.domain.model.interfaces.IPolicyVariable;

public class PolicyRule extends PolicySet implements IPolicyRule {
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
	public void setAction(IPolicyAction action) {
		this.action=action;
	}

	@Override
	public String toBodyString() {
		StringBuffer bf=new StringBuffer();
		bf.append("if ").append(this.getCondition().toBodyString()).append("{\n")
		.append(this.getAction().toBodyString())
		.append("            ").append("if (matched==false) {\n")
		.append("            ").append("   ").append("matched=true;\n")
		.append("            ").append("}\n")
		.append("        }\n");	
		return bf.toString();
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

	@Override
	public String getVariableDeclareString() {
		StringBuffer sb=new StringBuffer();
		Set<IPolicyVariable> variables=new HashSet<IPolicyVariable>();
		IPolicyCondition condition=this.getCondition();
		if (null!=condition){
			variables.addAll(condition.getVariables());
		}
		IPolicyAction action=this.getAction();
		if(null!=action){
			variables.addAll(action.getVariables());
		}
		IPolicyAction elseAction=this.getElseAction();
		if(null!=elseAction){
			variables.addAll(elseAction.getVariables());		
		}
		Map<String , IPolicyVariable>  map=new HashMap<String, IPolicyVariable>();
		for (IPolicyVariable iPolicyVariable : variables) {
			String code=iPolicyVariable.getCode();
			if (!map.containsKey(code)){
				map.put(code, iPolicyVariable);
			}
		}
		for(Entry<String, IPolicyVariable> entry : map.entrySet()){
			String code = entry.getKey();
			IPolicyVariable variable = entry.getValue();
			sb.append("        ").append(variable.getVariableType()).append(" ").append(code);
			if(null!=variable.getInitialValue()){
				sb.append(variable.getInitialValue());
			}
			sb.append(";\n");
		}
		return sb.toString();
	}

}
