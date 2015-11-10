package com.ai.crm.common.businessinteraction.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.ai.common.rootentity.domain.model.SpecificationInstanceEntity;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="biSpecId",discriminatorType=DiscriminatorType.INTEGER)
public abstract class BusinessInteraction extends SpecificationInstanceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long businessInteractionId;
	@Column
	private int biState;
	private Set<BusinessInteractionItem> businessInteractionItems=new HashSet<BusinessInteractionItem>();
	@Column
	private long biSpecId;
	@Column
	private String code;
	
	public BusinessInteraction(long biSpecId) {
		this.biSpecId=biSpecId;
	}	

	protected long getBusinessInteractionId() {
		return this.businessInteractionId;
	}

	protected void setBusinessInteractionId(long biId) {
		this.businessInteractionId=biId;
	}

	protected int getBiState() {
		return this.biState;
	}

	protected void setBiState(int biState) {
		this.biState=biState;
	}

	public Set<BusinessInteractionItem> getBusinessInteractionItems() {
		return this.businessInteractionItems;
	}

	public void addBusinessInteractionItem(BusinessInteractionItem bii) {
		if (null!=bii){
			businessInteractionItems.add(bii);
			if(null==bii.getBusinessInteraction()){
				bii.setBusinessInteraction(this);
			}			
		}

	}
	
	public long getBusinessInteractionSpecId(){
		return this.biSpecId;
	}

	protected String getCode() {
		return code;
	}

	protected void setCode(String code) {
		this.code = code;
	}

}
