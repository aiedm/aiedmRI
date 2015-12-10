package com.ai.common.policy.domain.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SERVICE")
public class PolicyServiceFunction extends PolicyFunction{

	public PolicyServiceFunction() {
	}

}
