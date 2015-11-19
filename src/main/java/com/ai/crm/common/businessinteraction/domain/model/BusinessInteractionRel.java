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
	private BusinessInteraction businessInteractiocA;
	
	@JoinColumn(name="BI_B")
	@ManyToOne
	private BusinessInteraction businessInteractiocB;
	@Column(name="REL_TYPE")
	private String relType;

	public BusinessInteractionRel() {
	}

	public BusinessInteraction getFirstBi() {
		return businessInteractiocA;
	}

	public void setFirstBi(BusinessInteraction firstBi) {
		this.businessInteractiocA = firstBi;
	}

	public BusinessInteraction getSecondBi() {
		return businessInteractiocB;
	}

	public void setSecondBi(BusinessInteraction secondBi) {
		this.businessInteractiocB = secondBi;
	}

	public String getRelType() {
		return relType;
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}

}
