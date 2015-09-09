package com.ai.crm.common.party.domain.model.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ai.crm.common.party.domain.model.interfaces.IDepartment;
import com.ai.crm.common.party.domain.model.interfaces.ILegalOrganization;
@Entity
@DiscriminatorValue("Organization.Legal")
public class LegalOrganization extends Organization implements ILegalOrganization {	
	private LegalOrganization(){}
	
	public LegalOrganization(String legalName){
		this.setTradingName(legalName);
		super.setLegal(true);
		super.setPartyType("Organization.Legal");
	}
	
	public List<IDepartment> getDepartments() {
		List<IDepartment> departments=new ArrayList<IDepartment>();
		if(null!=this.getChildOrganizations()){			
			for (Organization org:this.getChildOrganizations()) {
				if (org instanceof Department){
					departments.add((IDepartment)org);
				}
			}	

		}
		return departments;
	}

	public List<ILegalOrganization> getChildLegalOrganizations() {
		List<ILegalOrganization> childLegalOrganizations=new ArrayList<ILegalOrganization>();
		if(null!=this.getChildOrganizations()){
			for (Organization org:this.getChildOrganizations()) {
				if (org instanceof LegalOrganization){
					childLegalOrganizations.add((ILegalOrganization)org);
				}
			}	
		}
		return childLegalOrganizations;
	}

	public ILegalOrganization getParentLegalOrganization() {
		return (ILegalOrganization)this.getParentOrganization();
	}

	public boolean isTopLegalOrganization() {
		return null==this.getParentLegalOrganization();
	}

	public boolean hasDepartments() {
		return this.getDepartments()!=null&&this.getDepartments().size()>0;
	}

	public boolean hasChildLegalOrganizations() {
		return this.getChildLegalOrganizations()!=null&&this.getChildLegalOrganizations().size()>0;
	}

	public void addDepartment(IDepartment department) {
		if (null!=department){
			super.addChildOrganization((Department)department);
			department.setParentOrganization(this);
		}
		
	}

	public void addChildLegalOrganization(ILegalOrganization childLegalOrganization) {
		if (null!=childLegalOrganization){
			super.addChildOrganization((LegalOrganization)childLegalOrganization);
			childLegalOrganization.setParentOrganization(this);
		}
		
	}

	public void setParentLegalOrganization(ILegalOrganization parentLegalOrganization) {
		this.setParentOrganization(parentLegalOrganization);		
	}


}
