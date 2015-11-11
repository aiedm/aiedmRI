package com.ai.crm.common.party.domain.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

@Entity
@SecondaryTable(
	    name = "ORGANIZATION",
	    pkJoinColumns = @PrimaryKeyJoinColumn(name = "ORG_ID")
	)
@DiscriminatorValue("Organization")
public abstract class Organization extends Party {
	public Organization(){}
	
	@Basic
	@Column(table="ORGANIZATION")
	private boolean isLegal;

	public boolean isLegal() {
		return isLegal;
	}

	public void setLegal(boolean isLegal) {
		this.isLegal = isLegal;
	}
	@Basic
	@Column(table="ORGANIZATION")
	private String tradingName;

	public String getTradingName() {
		return tradingName;
	}

	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
	}
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(table="ORGANIZATION",name="PARENT_ORG_ID")
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