package com.ai.crm.common.businessinteraction.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ai.common.rootentity.domain.model.InstanceEntity;
@Entity
@Table(name="BI_BIZINTERACTION_REL")
public class BusinessInteractionRel extends InstanceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@JoinColumn(name="BI_A")
	@ManyToOne
	private BusinessInteraction businessInteractionA;
	
	@JoinColumn(name="BI_B")
	@ManyToOne
	private BusinessInteraction businessInteractionB;
	@Column(name="REL_TYPE")
	private String relType;

	public BusinessInteractionRel() {
	}

	public BusinessInteraction getFirstBi() {
		return businessInteractionA;
	}

	public void setFirstBi(BusinessInteraction firstBi) {
		this.businessInteractionA = firstBi;
	}

	public BusinessInteraction getSecondBi() {
		return businessInteractionB;
	}

	public void setSecondBi(BusinessInteraction secondBi) {
		this.businessInteractionB = secondBi;
	}

	public String getRelType() {
		return relType;
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}

}
