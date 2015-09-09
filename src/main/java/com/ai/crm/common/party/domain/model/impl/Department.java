package com.ai.crm.common.party.domain.model.impl;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ai.crm.common.party.domain.model.interfaces.IDepartment;
import com.ai.crm.common.party.domain.model.interfaces.ILegalOrganization;
@Entity
@DiscriminatorValue("Organization.Department")
public class Department extends Organization implements IDepartment {
	private Department(){}
	
	public Department(ILegalOrganization legalOrganization,String departmentName){
		this.setTradingName(departmentName);
		super.setParentOrganization(legalOrganization);
		legalOrganization.addDepartment(this);
	}
	
	public Department(IDepartment parentDepartment,String departmentName){
		this.setTradingName(departmentName);
		super.setParentOrganization(parentDepartment);
		parentDepartment.addChildDepartment(this);
	}	

	public boolean isTopDepartment() {
		return !hasChildDepartmens();
	}

	public boolean hasChildDepartmens() {
		return this.getChildOrganizations().size()>0;
	}


	public void addChildDepartment(IDepartment childDepartment) {
		if(null!=childDepartment){
			this.addChildOrganization((Organization)childDepartment);
		}
		
	}

}
