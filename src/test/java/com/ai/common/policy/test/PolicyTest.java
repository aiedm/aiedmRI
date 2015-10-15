package com.ai.common.policy.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.ai.common.policy.domain.model.impl.PolicyActionOperator;
import com.ai.common.policy.domain.model.impl.PolicyActionStatement;
import com.ai.common.policy.domain.model.impl.PolicyAtomicAction;
import com.ai.common.policy.domain.model.impl.PolicyAtomicCondition;
import com.ai.common.policy.domain.model.impl.PolicyCompositeAction;
import com.ai.common.policy.domain.model.impl.PolicyCompositeCondition;
import com.ai.common.policy.domain.model.impl.PolicyCompositeConditionOption;
import com.ai.common.policy.domain.model.impl.PolicyConditionOperator;
import com.ai.common.policy.domain.model.impl.PolicyConditionStatement;
import com.ai.common.policy.domain.model.impl.PolicyConstValue;
import com.ai.common.policy.domain.model.impl.PolicyFunction;
import com.ai.common.policy.domain.model.impl.PolicyFunctionParameter;
import com.ai.common.policy.domain.model.impl.PolicyFunctionValue;
import com.ai.common.policy.domain.model.impl.PolicyFunctionValueParamRel;
import com.ai.common.policy.domain.model.impl.PolicyGroup;
import com.ai.common.policy.domain.model.impl.PolicyRule;
import com.ai.common.policy.domain.model.impl.PolicySetInputParameter;
import com.ai.common.policy.domain.model.impl.PolicySetOutputParameter;
import com.ai.common.policy.domain.model.impl.PolicyVariable;
import com.ai.common.policy.domain.model.impl.PolicyVariableValue;
import com.ai.common.policy.domain.model.interfaces.IPolicyActionStatement;
import com.ai.common.policy.domain.model.interfaces.IPolicyAtomicAction;
import com.ai.common.policy.domain.model.interfaces.IPolicyAtomicCondition;
import com.ai.common.policy.domain.model.interfaces.IPolicyCompositeAction;
import com.ai.common.policy.domain.model.interfaces.IPolicyCompositeCondition;
import com.ai.common.policy.domain.model.interfaces.IPolicyCompositeConditionOption;
import com.ai.common.policy.domain.model.interfaces.IPolicyConditionStatement;
import com.ai.common.policy.domain.model.interfaces.IPolicyConstValue;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunction;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionParameter;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionValue;
import com.ai.common.policy.domain.model.interfaces.IPolicyFunctionValueParamRel;
import com.ai.common.policy.domain.model.interfaces.IPolicyGroup;
import com.ai.common.policy.domain.model.interfaces.IPolicyOperator;
import com.ai.common.policy.domain.model.interfaces.IPolicyRule;
import com.ai.common.policy.domain.model.interfaces.IPolicySetInputParameter;
import com.ai.common.policy.domain.model.interfaces.IPolicySetOutputParameter;
import com.ai.common.policy.domain.model.interfaces.IPolicyVariable;
import com.ai.common.policy.domain.model.interfaces.IPolicyVariableValue;
import com.ai.common.policy.domain.service.impl.GroovyPolicyExecute;
import com.ai.common.policy.domain.service.interfaces.IPolicyExecute;

public class PolicyTest {
	
	@Before
	public void prepare() throws Exception{
		 
	}

	@Test
	public void test() throws Exception{
		IPolicyFunction function=new PolicyFunction();
		function.setCode("com.ai.common.policy.test.TestUtil.add");
		IPolicyFunctionParameter funcParam=new PolicyFunctionParameter();
		funcParam.setFunction(function);
		funcParam.setParameterType("Integer");
		function.addParameter(funcParam);
		IPolicyFunctionParameter funcParam2=new PolicyFunctionParameter();
		funcParam2.setFunction(function);
		funcParam2.setParameterType("Integer");
		function.addParameter(funcParam2);
		
		IPolicyRule rule1=new PolicyRule();
		rule1.setCode("TestRule");
		IPolicyGroup groupRule=new PolicyGroup();
		groupRule.addPolicySet(rule1);		
		groupRule.setCode("TestGroup");
		
		IPolicyVariable var1=new PolicyVariable();
		var1.setCode("a");
		var1.setVariableType("Integer");
		IPolicyVariable var2=new PolicyVariable();
		var2.setCode("b");
		var2.setVariableType("Integer");
		IPolicyVariable var3=new PolicyVariable();
		var3.setCode("c");
		var3.setVariableType("Integer");
		IPolicyVariable var4=new PolicyVariable();
		var4.setCode("returnValue");
		var4.setVariableType("Boolean");
		var4.setInitialValue("false");
		IPolicyConstValue value1=new PolicyConstValue();
		value1.setType("Integer");
		value1.setValue("100*10");
		IPolicyFunctionValue value2=new PolicyFunctionValue();
		value2.setType("Integer");
		//value2.setValue("tested:a>100");
		//value2.setVariable(var3);
		value2.setFunction(function);
		IPolicyFunctionValueParamRel funcValueParam1=new PolicyFunctionValueParamRel();
		funcValueParam1.setParameter(funcParam);
		funcValueParam1.setVaraibleValueRef(var1);
		funcValueParam1.setFunctionValue(value2);
		IPolicyFunctionValueParamRel funcValueParam2=new PolicyFunctionValueParamRel();
		funcValueParam2.setParameter(funcParam);
		funcValueParam2.setVaraibleValueRef(var3);
		funcValueParam2.setFunctionValue(value2);
		value2.addParam(funcValueParam1);
		value2.addParam(funcValueParam2);
		
		
		IPolicyConstValue value3=new PolicyConstValue();
		value3.setType("Integer");
		value3.setValue("200");
		IPolicyConstValue value4=new PolicyConstValue();
		value4.setType("Boolean");
		value4.setValue("true");
		IPolicyConstValue value5=new PolicyConstValue();
		value5.setType("Boolean");
		value5.setValue("false");		
		IPolicyOperator opertor1=new PolicyConditionOperator();
		opertor1.setCode(">");
		IPolicyOperator opertor2=new PolicyActionOperator();
		opertor2.setCode("=");
		IPolicyConditionStatement statement1=new PolicyConditionStatement();
		statement1.setVariable(var1);
		statement1.setOperator(opertor1);
		statement1.setValue(value1);
		IPolicyConditionStatement statement3=new PolicyConditionStatement();
		statement3.setVariable(var3);
		statement3.setOperator(opertor1);
		statement3.setValue(value3);		
		IPolicyActionStatement statement2=new PolicyActionStatement();
		statement2.setVariable(var2);
		statement2.setOperator(opertor2);
		statement2.setValue(value2);
		IPolicyActionStatement statement4=new PolicyActionStatement();
		statement4.setVariable(var4);
		statement4.setOperator(opertor2);
		statement4.setValue(value4);	
		IPolicyActionStatement statement5=new PolicyActionStatement();
		statement5.setVariable(var4);
		statement5.setOperator(opertor2);
		statement5.setValue(value5);		
		IPolicyAtomicCondition condition1=new PolicyAtomicCondition();
		condition1.setStatement(statement1);
		condition1.setCode("condition1");
		IPolicyAtomicCondition condition2=new PolicyAtomicCondition();
		condition2.setStatement(statement3);
		condition2.setCode("condition2");
		IPolicyCompositeCondition condition3=new PolicyCompositeCondition();
		condition3.setAnd();
		condition3.setCode("condition3");
		IPolicyCompositeConditionOption compositeConditionOption=new PolicyCompositeConditionOption();
		compositeConditionOption.setParentCondition(condition3);
		compositeConditionOption.setChildCondition(condition1);
		IPolicyCompositeConditionOption compositeConditionOption2=new PolicyCompositeConditionOption();
		compositeConditionOption2.setParentCondition(condition3);
		compositeConditionOption2.setChildCondition(condition2);
		condition3.addChild(compositeConditionOption);
		condition3.addChild(compositeConditionOption2);	
		rule1.setCondition(condition3);
		IPolicyAtomicAction action1=new PolicyAtomicAction();
		action1.setStatement(statement2);				
		IPolicyAtomicAction action2=new PolicyAtomicAction();
		action2.setStatement(statement4);
		IPolicyCompositeAction action3=new PolicyCompositeAction();
		action3.addChild(action1);
		action3.addChild(action2);
		rule1.setAction(action3);
		IPolicyAtomicAction action5=new PolicyAtomicAction();
		action5.setStatement(statement5);	
		rule1.setElseAction(action5);
		IPolicySetOutputParameter param=new PolicySetOutputParameter();
		param.setVariable(var4);
		groupRule.setOutputParameter(param);
		IPolicySetInputParameter param2=new PolicySetInputParameter();
		param2.setVariable(var1);
		rule1.addInputParameter(param2);
		IPolicySetInputParameter param3=new PolicySetInputParameter();
		param3.setVariable(var3);
		rule1.addInputParameter(param3);	
		
		IPolicyRule rule2=new PolicyRule();
		rule2.setCondition(condition1);
		rule2.setAction(action3);
		rule2.setElseAction(action3);
		groupRule.setElseAction(action1);
		groupRule.addPolicySet(rule2);
		
		String ss=groupRule.toPolicyString();
		System.out.println(ss);
		
		IPolicyExecute serv1=new GroovyPolicyExecute();
		Map<String, Object> context=new HashMap<>();
		context.put("a", 200);
		context.put("b", 200);
		context.put("c", 500);
		Boolean resu=(Boolean)serv1.execute(groupRule, context);
		//assertEquals(resu,new Integer(900));
		assertEquals(resu,false);
	}

}
