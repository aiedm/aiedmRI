package com.ai.common.policy.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.InstanceEntity;
@Entity
@Table(name="PL_STATEMENT")
public abstract class PolicyStatement extends InstanceEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	private String name;
	private String code;
	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name="panType", column=@Column(name="LEFT_PAN_TYPE")),
        @AttributeOverride(name="policyValue", column=@Column(name="LEFT_VALUE")),
        @AttributeOverride(name="policyVariable", column=@Column(name="LEFT_VARIABLE"))
    })
	private PolicyPan leftPan;
	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name="panType", column=@Column(name="RIGHT_PAN_TYPE")),
        @AttributeOverride(name="policyValue", column=@Column(name="RIGHT_VALUE")),
        @AttributeOverride(name="policyVariable", column=@Column(name="RIGHT_VARIABLE"))
    })
	private PolicyPan rightPan;
	
	public PolicyStatement() {
	}

	
	public String getName() {
		return this.name;
	}

	
	public void setName(String name) {
		this.name=name;
	}

	
	public String getCode() {
		return this.code;
	}

	
	public void setCode(String code) {
		this.code=code;
	}	


	@Column(name="OPERATOR_ID")
	public abstract PolicyOperator getOperator();

	
	public abstract void setOperator(PolicyOperator operator);

	
	public String toBodyString() {
		StringBuffer sb=new StringBuffer();
		String firstParam="";
		String secondParam="";
		if(null!=this.getLeftPan()){
			firstParam=this.getLeftPan().toBodyString();
		}
		if(null!=this.getRightPan()){
			secondParam=this.getRightPan().toBodyString();
			if (null!=secondParam){
				sb.append(this.getOperator().toBodyString(firstParam,secondParam));
			}
		}		
		return sb.toString();
	}
	
	
	public Set<PolicyVariable> getVariables(){
		Set<PolicyVariable> variables=new LinkedHashSet<PolicyVariable>();
		if(null!=this.getLeftPan() && (null!=this.getLeftPan().getVariables())){
			variables.addAll(this.getLeftPan().getVariables());
		}
		if(null!=this.getRightPan() && (null!=this.getRightPan().getVariables())){
			variables.addAll(this.getRightPan().getVariables());
		}
		return variables;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public PolicyPan getLeftPan() {
		return leftPan;
	}


	public void setLeftPan(PolicyPan leftPan) {
		this.leftPan = leftPan;
	}


	public PolicyPan getRightPan() {
		return rightPan;
	}


	public void setRightPan(PolicyPan rightPan) {
		this.rightPan = rightPan;
	}
	

}
