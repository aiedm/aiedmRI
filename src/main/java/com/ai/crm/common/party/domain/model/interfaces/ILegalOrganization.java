package com.ai.crm.common.party.domain.model.interfaces;

import java.util.List;

public interface ILegalOrganization extends IOrganization {
	List<IDepartment> getDepartments();
	List<ILegalOrganization> getChildLegalOrganizations();
	ILegalOrganization getParentLegalOrganization();
	boolean isTopLegalOrganization();
	boolean hasDepartments();
	boolean hasChildLegalOrganizations();
	void addDepartment(IDepartment department);
	void addChildLegalOrganization(ILegalOrganization childLegalOrganization);
	void setParentLegalOrganization(ILegalOrganization parentLegalOrganization);
}
