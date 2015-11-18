package com.ai.crm.common.businessinteraction.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Id;

import com.ai.common.rootentity.domain.model.InstanceEntity;
@Entity
public class BusinessInteractionItemRel extends InstanceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;	
	@JoinColumn(name="BII_A")
	@ManyToOne
	private BusinessInteractionItem businessInteractionItemA;
	@JoinColumn(name="BII_B")
	@ManyToOne	
	private BusinessInteractionItem businessInteractionItemB;
	@Column(name="REL_TYPE")
	private String relType;
	public BusinessInteractionItemRel() {
	}
	public BusinessInteractionItem getFirstBii() {
		return businessInteractionItemA;
	}
	public void setFirstBii(BusinessInteractionItem firstBii) {
		this.businessInteractionItemA = firstBii;
	}
	public BusinessInteractionItem getSecondBii() {
		return businessInteractionItemB;
	}
	public void setSecondBii(BusinessInteractionItem secondBii) {
		this.businessInteractionItemB = secondBii;
	}
	public String getRelType() {
		return relType;
	}
	public void setRelType(String relType) {
		this.relType = relType;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}

}
