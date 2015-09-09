package com.ai.crm.common.party.domain.model.interfaces;

public interface IOrganization extends IParty {
	String getTradingName();
	void setTradingName(String tradingName);
	boolean isLegal() ;
	public void setLegal(boolean isLegal);
	void setParentOrganization(IOrganization parentOrganization);	
	IOrganization getParentOrganization();
}
