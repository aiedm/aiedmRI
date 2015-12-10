package com.ai.common.policy.domain.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("STATIC")
public class PolicyStaiticFunction extends PolicyFunction {

	public PolicyStaiticFunction() {
	}

}
