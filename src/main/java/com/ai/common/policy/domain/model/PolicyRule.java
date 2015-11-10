package com.ai.common.policy.domain.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class PolicyRule extends PolicySet{
	private PolicyCondition condition;
	private PolicyAction action;
	private Set<PolicySetInputParameter> inputParameters=new LinkedHashSet<PolicySetInputParameter>();

	public PolicyRule() {
	}

	
	public PolicyCondition getCondition() {
		return this.condition;
	}

	
	public void setCondition(PolicyCondition condition) {
		this.condition=condition;
	}

	
	public PolicyAction getAction() {
		return this.action;
	}

	
	public void setAction(PolicyAction action) {
		this.action=action;
	}

	
	public String toBodyString() {
		StringBuffer bf=new StringBuffer();
		bf.append("        ").append("if (").append(this.getCondition().toBodyString()).append("){\n")
		.append(this.getAction().toBodyString())
		.append("            ").append("if (matched==false) {\n")
		.append("            ").append("   ").append("matched=true;\n")
		.append("            ").append("}\n")
		.append("        }\n");	
		return bf.toString();
	}
	
	
	public void addInputParameter(PolicySetInputParameter param) {
		if(null!=param){
			inputParameters.add(param);
		}
	}	


	
	public Set<PolicySetInputParameter> getInputParameters() {
		return this.inputParameters;
	}
	
	
	public Map<String,PolicyVariable> getVariableMap(){
		Set<PolicyVariable> variables=new HashSet<PolicyVariable>();
		PolicyCondition condition=this.getCondition();
		if (null!=condition){
			variables.addAll(condition.getVariables());
		}
		PolicyAction action=this.getAction();
		if(null!=action){
			if (action.getVariables().size()>0){
				variables.addAll(action.getVariables());
			}
		}
		PolicyAction elseAction=this.getElseAction();
		if(null!=elseAction){
			if (elseAction.getVariables().size()>0){
				variables.addAll(elseAction.getVariables());
			}			
		}
		Map<String , PolicyVariable>  map=new HashMap<String, PolicyVariable>();
		for (PolicyVariable PolicyVariable : variables) {
			if(null!=PolicyVariable){
				String code=PolicyVariable.getCode();
				if (!code.isEmpty()&&!map.containsKey(code)){
					map.put(code, PolicyVariable);
				}	
			}
		}
		for (PolicySetInputParameter param : this.getInputParameters()) {
			String varCode=param.getVariable().getCode();
			if (map.containsKey(varCode)){
				map.remove(varCode);
			}
		}
		return map;
	}

}
