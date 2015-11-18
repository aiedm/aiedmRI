package com.ai.crm.common.businessinteraction.domain.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.ai.common.rootentity.domain.model.EntityVersion;
import com.ai.common.rootentity.domain.model.InstanceEntity;
@Entity
public class BIIRelatedEntity extends InstanceEntity  {
	@Id
	private long id;
	@OneToOne
	private BusinessInteractionItem bii;
	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name="versionTime", column=@Column(name="ASIA_VERSION_TIME")),
        @AttributeOverride(name="versionOperatorId", column=@Column(name="ASIA_VERSION_OPERATOR_ID")),
        @AttributeOverride(name="version", column=@Column(name="ASIA_VERSION"))
    })
	private EntityVersion asIsAfterVersion;
	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name="versionTime", column=@Column(name="TOBE_VERSION_TIME")),
        @AttributeOverride(name="versionOperatorId", column=@Column(name="TOBE_VERSION_OPERATOR_ID")),
        @AttributeOverride(name="version", column=@Column(name="TOBE_VERSION"))
    })
	private EntityVersion toBeVersion;
	@Transient
	private InstanceEntity toBeEntity;
	private long toBeEntityId;
	private int action;
	public BIIRelatedEntity() {
	}

	public BusinessInteractionItem getBusinessInteractionItem() {
		return this.bii;
	}

	public void setBusinessInteractionItem(BusinessInteractionItem bii) {
		this.bii=bii;
	}

	public EntityVersion getAsIsAfterVersion() {
		return this.asIsAfterVersion;
	}

	public void setAsIsAfterVersion(EntityVersion version) {
		this.asIsAfterVersion=version;
	}

	public InstanceEntity getToBeInstanceEntity() {
		return this.toBeEntity;
	}

	public void setToBeInstanceEntity(InstanceEntity entity) {
		this.toBeEntity=entity;
	}

	public EntityVersion getToBeVersion() {
		return this.toBeVersion;
	}

	public void setToBeVersion(EntityVersion version) {
		this.toBeVersion=version;
	}

	public int getAction() {
		return this.action;
	}

	public void setAction(int action) {
		this.action=action;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getToBeEntityId() {
		return toBeEntityId;
	}

	public void setToBeEntityId(long toBeEntityId) {
		this.toBeEntityId = toBeEntityId;
	}

}
