package com.ai.crm.common.party.domain.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ORGANIZATION.DEPARTMENT")
public class Department extends Organization {
	private Department(){}
	
	public Department(LegalOrganization legalOrganization,String departmentName){
		this.setTradingName(departmentName);
		super.setParentOrganization(legalOrganization);
		super.setPartyType("ORGANIZATION.DEPARTMENT");
		legalOrganization.addDepartment(this);
	}
	
	public Department(Department parentDepartment,String departmentName){
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


	public void addChildDepartment(Department childDepartment) {
		if(null!=childDepartment){
			this.addChildOrganization((Organization)childDepartment);
		}
		
	}

}
