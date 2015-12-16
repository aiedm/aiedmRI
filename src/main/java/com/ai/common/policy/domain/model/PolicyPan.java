package com.ai.common.policy.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Embeddable
public class PolicyPan {
	@Column(name="PAN_TYPE")
	private String panType;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="VARIABLE_ID")
	private PolicyVariable panVariable;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="VALUE_ID")
	private PolicyValue panValue;
		
	public PolicyPan() {
		
	}
	

	public PolicyVariable getPolicyVariable() {
		return panVariable;
	}

	public void setPolicyVariable(PolicyVariable variable) {
		this.setPanType("VARIABLE");
		this.panVariable = variable;
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
		return panValue;
	}

	public void setPolicyValue(PolicyValue value) {
		this.setPanType("VALUE");
		this.panValue = value;
	}

	public String getPanType() {
		return panType;
	}

	public void setPanType(String panType) {
		this.panType = panType;
	}
}
