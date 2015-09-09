package com.ai.crm.common.party.domain.model.interfaces;

public interface IDepartment extends IOrganization {
	boolean isTopDepartment();
	boolean hasChildDepartmens();	
	void addChildDepartment(IDepartment childDepartment);
}
