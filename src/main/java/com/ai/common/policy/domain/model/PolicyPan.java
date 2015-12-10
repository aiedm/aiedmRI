package com.ai.common.policy.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Embeddable
public class PolicyPan {
	@Column(name="PAN_TYPE")
	private String panType;
	@OneToOne
	@JoinColumn(name="POLICY_VARIABLE_ID",insertable=false,updatable=false)
	private PolicyVariable policyVariable;
	@OneToOne
	@JoinColumn(name="POLICY_VALUE_ID",insertable=false,updatable=false)
	private PolicyValue policyValue;
		
	public PolicyPan() {
		
	}
	

	public PolicyVariable getPolicyVariable() {
		return policyVariable;
	}

	public void setPolicyVariable(PolicyVariable variable) {
		this.setPanType("VARIABLE");
		this.policyVariable = variable;
	}
	
	public String toBodyString(){
		String str=null;
		if(null!=this.getPolicyVariable()){
			str=this.getPolicyVariable().toBodyString();
		}else{
			str=this.getPolicyValue().toBodyString();
		}
		return str;
	}
		
	public Set<PolicyVariable> getVariables(){
		Set<PolicyVariable> variables=new LinkedHashSet<PolicyVariable>();
		if(null!=this.getPolicyVariable()){
			variables.add(this.getPolicyVariable());
		}else{
			if (null!=this.getPolicyValue().getVariables()){
				variables.addAll(this.getPolicyValue().getVariables());
			}	
		}
		return variables;
	}	

	public PolicyValue getPolicyValue() {
		return policyValue;
	}

	public void setPolicyValue(PolicyValue value) {
		this.setPanType("VALUE");
		this.policyValue = value;
	}

	public String getPanType() {
		return panType;
	}

	public void setPanType(String panType) {
		this.panType = panType;
	}
}
