package com.ai.common.policy.domain.service.impl;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.util.Map;

import com.ai.common.policy.domain.model.interfaces.IPolicySet;
import com.ai.common.policy.domain.service.interfaces.IPolicyExecute;

public class GroovyPolicyExecute implements IPolicyExecute {

	public GroovyPolicyExecute() {
	}

	@Override
	public Object execute(IPolicySet policySet,Map<String, Object> context) throws Exception{
		ClassLoader parent =ClassLoader.getSystemClassLoader();
		GroovyClassLoader loader =new GroovyClassLoader(parent);
		Class<?> clazz = loader.parseClass(policySet.toPolicyString());
		GroovyObject clazzObj =(GroovyObject)clazz.newInstance();
		return clazzObj.invokeMethod("executePolicy",context);
	}

}
