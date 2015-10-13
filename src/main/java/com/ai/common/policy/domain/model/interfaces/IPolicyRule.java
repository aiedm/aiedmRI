package com.ai.common.policy.domain.model.interfaces;

public interface IPolicyRule extends IPolicySet {
	IPolicyCondition getCondition();
	void setCondition(IPolicyCondition condition);
	IPolicyAction getAction();
	void getAction(IPolicyAction action);
	boolean isElseAction();
	String toPolicyString();
}
