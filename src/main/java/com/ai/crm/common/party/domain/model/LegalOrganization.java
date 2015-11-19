package com.ai.crm.common.party.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ORGANIZATION.LEGAL")
public class LegalOrganization extends Organization{	
	private LegalOrganization(){}
	
	public LegalOrganization(String legalName){
		this.setTradingName(legalName);
		super.setLegal(true);
		super.setPartyType("ORGANIZATION.LEGAL");
	}
	
	public List<Department> getDepartments() {
		List<Department> departments=new ArrayList<Department>();
		if(null!=this.getChildOrganizations()){			
			for (Organization org:this.getChildOrganizations()) {
				if (org instanceof Department){
					departments.add((Department)org);
				}
			}	

		}
		return departments;
	}

	public List<LegalOrganization> getChildLegalOrganizations() {
		List<LegalOrganization> childLegalOrganizations=new ArrayList<LegalOrganization>();
		if(null!=this.getChildOrganizations()){
			for (Organization org:this.getChildOrganizations()) {
				if (org instanceof LegalOrganization){
					childLegalOrganizations.add((LegalOrganization)org);
				}
			}	
		}
		return childLegalOrganizations;
	}

	public LegalOrganization getParentLegalOrganization() {
		return (LegalOrganization)this.getParentOrganization();
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

	public void addDepartment(Department department) {
		if (null!=department){
			super.addChildOrganization(department);
			department.setParentOrganization(this);
		}
		
	}

	public void addChildLegalOrganization(LegalOrganization childLegalOrganization) {
		if (null!=childLegalOrganization){
			super.addChildOrganization(childLegalOrganization);
			childLegalOrganization.setParentOrganization(this);
		}
		
	}

	public void setParentLegalOrganization(LegalOrganization parentLegalOrganization) {
		this.setParentOrganization(parentLegalOrganization);		
	}


}
