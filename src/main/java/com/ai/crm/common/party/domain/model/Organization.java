package com.ai.crm.common.party.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Organization")
public abstract class Organization extends Party {
	public Organization(){}
	
	private boolean isLegal;

	public boolean isLegal() {
		return isLegal;
	}

	public void setLegal(boolean isLegal) {
		this.isLegal = isLegal;
	}

	private String tradingName;

	public String getTradingName() {
		return tradingName;
	}

	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
	}
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Organization parentOrganization;

	public Organization getParentOrganization() {
		return parentOrganization;
	}

	public void setParentOrganization(Organization parentOrganization) {
		this.parentOrganization = parentOrganization;
	}
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="parentOrganization")
	private Set<Organization> childOrganizations=new LinkedHashSet<Organization>(); 
	
	public Set<Organization> getChildOrganizations() {
		return childOrganizations;
	}
	public void addChildOrganization(Organization childOrganization) {
		this.childOrganizations.add(childOrganization);
	}

	@Override
	public String getName() {
		return this.getTradingName();
	}
}
