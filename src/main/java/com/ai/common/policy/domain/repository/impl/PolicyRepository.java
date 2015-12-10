package com.ai.common.policy.domain.repository.impl;

import java.io.Serializable;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.common.policy.domain.model.PolicyFunction;
import com.ai.common.policy.domain.model.PolicyOperator;
import com.ai.common.policy.domain.model.PolicySet;
import com.ai.common.policy.domain.repository.interfaces.IPolicyRepository;
import com.ai.common.rootentity.domain.model.EventSubscriber;
@Component
public class PolicyRepository implements IPolicyRepository {
	@Autowired
	SessionFactory sessionFactory;

	public PolicyRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	public PolicyRepository() {
	}
	
	@Override
	public Set<EventSubscriber> getEventRegistePolicies(String  eventCode, long specificationEntityId) throws Exception {
		
		return null;
	}

	@Override
	public PolicySet savePolicySet(PolicySet policySet) throws Exception {
		Serializable id = currentSession().save(policySet);
		policySet.setId((Long)id);
		return policySet;
	}

	@Override
	public PolicyOperator savePolicyOperator(PolicyOperator operator) throws Exception {
		Serializable id = currentSession().save(operator);
		operator.setId((Long)id);
		return operator;
	}

	@Override
	public PolicyFunction savePolicyFunction(PolicyFunction function) throws Exception {
		Serializable id = currentSession().save(function);
		function.setId((Long)id);
		return function;
	}


}
