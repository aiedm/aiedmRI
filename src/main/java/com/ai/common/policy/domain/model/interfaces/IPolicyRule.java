package com.ai.common.policy.domain.model.interfaces;

public interface IPolicyRule extends IPolicySet {
	IPolicyCondition getCondition();
	void setCondition(IPolicyCondition condition);
	IPolicyAction getAction();
	void setAction(IPolicyAction action);
	String toBodyString();
	String toPolicyString();
	void addInputParameter(IPolicySetInputParameter param);
}
