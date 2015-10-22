package com.ai.common.policy.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
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
import com.ai.common.policy.domain.model.impl.PolicyOperatorMethodInvoke;
import com.ai.common.policy.domain.model.impl.PolicyOperatorStringEquals;
import com.ai.common.policy.domain.model.impl.PolicyRule;
import com.ai.common.policy.domain.model.impl.PolicySetInputParameter;
import com.ai.common.policy.domain.model.impl.PolicySetOutputParameter;
import com.ai.common.policy.domain.model.impl.PolicyValue;
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
import com.ai.common.policy.domain.model.interfaces.IPolicyOperatorMethodInvoke;
import com.ai.common.policy.domain.model.interfaces.IPolicyOperatorStringEquals;
import com.ai.common.policy.domain.model.interfaces.IPolicyRule;
import com.ai.common.policy.domain.model.interfaces.IPolicySetInputParameter;
import com.ai.common.policy.domain.model.interfaces.IPolicySetOutputParameter;
import com.ai.common.policy.domain.model.interfaces.IPolicyStatement;
import com.ai.common.policy.domain.model.interfaces.IPolicyValue;
import com.ai.common.policy.domain.model.interfaces.IPolicyVariable;
import com.ai.common.policy.domain.model.interfaces.IPolicyVariableValue;
import com.ai.common.policy.domain.service.impl.GroovyPolicyExecute;
import com.ai.common.policy.domain.service.interfaces.IPolicyExecute;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacteristic;
import com.ai.crm.product.domain.model.impl.OfferInstance;
import com.ai.crm.product.domain.model.impl.Product;
import com.ai.crm.product.domain.model.interfaces.IOfferInstance;
import com.ai.crm.product.domain.model.interfaces.IPricePlanInstance;
import com.ai.crm.product.domain.model.interfaces.IProduct;

public class PolicyTest {
	
	@Before
	public void prepare() throws Exception{
		 
	}

	@Test
	@Ignore
	public void test() throws Exception{
		IPolicyFunction function=new PolicyFunction();
		function.setCode("com.ai.common.policy.test.TestUtil.add");
		function.setClassName("com.ai.common.policy.test.TestUtil");
		function.setMethodName("add");
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
		var1.setInitialInputValue("0");
		IPolicyVariable var2=new PolicyVariable();
		var2.setCode("b");
		var2.setVariableType("Integer");
		var2.setInitialInputValue("0");
		IPolicyVariable var3=new PolicyVariable();
		var3.setCode("c");
		var3.setVariableType("Integer");
		var3.setInitialInputValue("0");
		IPolicyVariable var4=new PolicyVariable();
		var4.setCode("returnValue");
		var4.setVariableType("boolean");
		var4.setInitialInputValue("false");
		IPolicyConstValue value1=new PolicyConstValue();
		value1.setType("Integer");
		value1.setValue("100*10");
		
		IPolicyVariableValue valueA=new PolicyVariableValue();
		valueA.setVariable(var1);
		
		IPolicyVariableValue valueB=new PolicyVariableValue();
		valueB.setVariable(var2);		
		
		IPolicyFunctionValue value2=new PolicyFunctionValue();
		value2.setType("Integer");
		//value2.setValue("tested:a>100");
		//value2.setVariable(var3);
		value2.setFunction(function);
		IPolicyFunctionValueParamRel funcValueParam1=new PolicyFunctionValueParamRel();
		funcValueParam1.setParameter(funcParam);
		funcValueParam1.setValue(valueA);
		IPolicyFunctionValueParamRel funcValueParam2=new PolicyFunctionValueParamRel();
		funcValueParam2.setParameter(funcParam);
		funcValueParam2.setValue(valueB);
		value2.addParam(funcValueParam1);
		value2.addParam(funcValueParam2);
		
		
		IPolicyConstValue value3=new PolicyConstValue();
		value3.setType("Integer");
		value3.setValue("200");
		IPolicyConstValue value4=new PolicyConstValue();
		value4.setType("boolean");
		value4.setValue("true");
		IPolicyConstValue value5=new PolicyConstValue();
		value5.setType("boolean");
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
	
	@Test
	//@Ignore
	public void  prepareProductPriceRule() throws Exception{
		//variable define
		IPolicyVariable varOfferInstance=new PolicyVariable();
		varOfferInstance.setCode("toBeOfferInstance");
		varOfferInstance.setVariableType("com.ai.crm.customerorder.domain.model.interfaces.IToBeOfferInstance");
		
		IPolicyVariable varProduct=new PolicyVariable();
		varProduct.setCode("toBeProduct");
		varProduct.setVariableType("com.ai.crm.customerorder.domain.model.interfaces.IToBeProduct");
	
		IPolicyVariable varProductPriceRel=new PolicyVariable();
		varProductPriceRel.setCode("toBeProductPriceRel");
		varProductPriceRel.setVariableType("com.ai.crm.customerorder.domain.model.interfaces.IProductPriceRel");
		varProductPriceRel.setInitialInputValue("new ProductPriceRel()");

		IPolicyVariable varPricePlanInstance=new PolicyVariable();
		varPricePlanInstance.setCode("toBePricePlanInstance");
		varPricePlanInstance.setVariableType("com.ai.crm.customerorder.domain.model.interfaces.IToBePricePlanInstance");
		varPricePlanInstance.setInitialInputValue("new PricePlanInstance()");
		
		//getColorValue
		//function and param define
		IPolicyFunction function8=new PolicyFunction();
		function8.setCode("getProductColorValue");
		function8.setClassName("toBeProduct");
		function8.setMethodName("getInstEntityCharValueByCharCode");
		IPolicyFunctionParameter characteristicCode=new PolicyFunctionParameter();
		characteristicCode.setFunction(function8);
		characteristicCode.setParameterType("String");
		function8.addParameter(characteristicCode);
		IPolicyFunctionParameter characteristicValueIdx=new PolicyFunctionParameter();
		characteristicValueIdx.setFunction(function8);
		characteristicValueIdx.setParameterType("int");
		function8.addParameter(characteristicValueIdx);
		
		//variable define
			
		IPolicyVariable colorCharCode=new PolicyVariable();
		colorCharCode.setCode("colorCharCode");
		colorCharCode.setVariableType("String");
		
		IPolicyVariable colorValueIdx=new PolicyVariable();
		colorValueIdx.setCode("colorValueIdx");
		colorValueIdx.setVariableType("int");
		//colorValueIdx.setInitialValue("0");
		
		//value define
		IPolicyConstValue redColor = new PolicyConstValue();
		redColor.setType("Const");
		redColor.setCode("redColor");
		redColor.setValue("'Red'");
		
		IPolicyConstValue firstValue = new PolicyConstValue();
		firstValue.setType("Const");
		firstValue.setCode("firstValue");
		firstValue.setValue("0");
		
		IPolicyFunctionValue getProductColorValue=new PolicyFunctionValue();
		//getProductColorValue.setType("Function");
		getProductColorValue.setFunction(function8);
		IPolicyFunctionValueParamRel paramRel=new PolicyFunctionValueParamRel();
		paramRel.setFunctionValue(getProductColorValue);
		paramRel.setParameter(characteristicCode);
		paramRel.setValue(redColor);
		getProductColorValue.addParam(paramRel);
		
		IPolicyFunctionValueParamRel paramRel2=new PolicyFunctionValueParamRel();
		paramRel2.setFunctionValue(getProductColorValue);
		paramRel2.setParameter(characteristicValueIdx);
		paramRel2.setValue(firstValue);
		getProductColorValue.addParam(paramRel2);		
		
		//toBePricePlanInstance.setPricePlanId
		//function and param define
		IPolicyFunction function2=new PolicyFunction();
		function2.setCode("toBePricePlanInstance.setPricePlanId");
		function2.setClassName("toBePricePlanInstance");
		function2.setMethodName("setPricePlanId");
		IPolicyFunctionParameter pricePlanId=new PolicyFunctionParameter();
		pricePlanId.setFunction(function2);
		pricePlanId.setParameterType("long");
		function2.addParameter(pricePlanId);
		
		//value define
		IPolicyConstValue monthFeePricePlan = new PolicyConstValue();
		//monthFeePricePlan.setType("Const");
		monthFeePricePlan.setCode("monthFeePricePlan");
		monthFeePricePlan.setValue("10001");
		
				
		IPolicyFunctionValueParamRel paramRelPriceId=new PolicyFunctionValueParamRel();
		paramRelPriceId.setParameter(pricePlanId);
		paramRelPriceId.setValue(monthFeePricePlan);
		IPolicyFunctionValue setPricePlanId=new PolicyFunctionValue();
		setPricePlanId.setFunction(function2);		
		setPricePlanId.addParam(paramRelPriceId);
		
		//toBePricePlanInstance.setValue
		//function and param define
		IPolicyFunction function3=new PolicyFunction();
		function3.setCode("toBePricePlanInstance.setValue");
		function3.setClassName("toBePricePlanInstance");
		function3.setMethodName("setValue");
		IPolicyFunctionParameter priceValue=new PolicyFunctionParameter();
		priceValue.setFunction(function3);
		priceValue.setParameterType("String");
		function3.addParameter(priceValue);
		
		//value define	
		IPolicyConstValue PriceValue200 = new PolicyConstValue();
		//PriceValue200.setType("Const");
		PriceValue200.setCode("PriceValue200");
		PriceValue200.setValue("200");
		
		IPolicyFunctionValueParamRel paramRelPriceValue=new PolicyFunctionValueParamRel();
		paramRelPriceValue.setParameter(priceValue);
		paramRelPriceValue.setValue(PriceValue200);
		IPolicyFunctionValue setPriceValue=new PolicyFunctionValue();
		setPriceValue.setFunction(function3);		
		setPriceValue.addParam(paramRelPriceValue);
		
		//toBeProductPriceRel.setProduct
		//function and param define
		IPolicyFunction function4=new PolicyFunction();
		function4.setCode("toBeProductPriceRel.setProduct");
		function4.setClassName("toBeProductPriceRel");
		function4.setMethodName("setProduct");
		IPolicyFunctionParameter paramToBeProduct=new PolicyFunctionParameter();
		paramToBeProduct.setFunction(function4);
		paramToBeProduct.setParameterType("com.ai.crm.customerorder.domain.model.interfaces.IToBeProduct");
		function4.addParameter(paramToBeProduct);		
		
		//value define
		IPolicyVariableValue valToBeProduct = new PolicyVariableValue();
		//toBeProduct.setType("Variable");
		valToBeProduct.setCode("toBeProduct");				
				
		IPolicyFunctionValueParamRel paramRelProduct=new PolicyFunctionValueParamRel();
		paramRelProduct.setParameter(paramToBeProduct);
		paramRelProduct.setValue(valToBeProduct);
		IPolicyFunctionValue setProduct=new PolicyFunctionValue();
		setPricePlanId.setFunction(function4);		
		setPricePlanId.addParam(paramRelProduct);
		
		//toBeProductPriceRel.setPricePlanInstance
		//function and param define
		IPolicyFunction function5=new PolicyFunction();
		function5.setCode("toBeProductPriceRel.setPricePlanInstance");
		function5.setClassName("toBeProductPriceRel");
		function5.setMethodName("setPricePlanInstance");
		IPolicyFunctionParameter paramToBePricePlan=new PolicyFunctionParameter();
		paramToBePricePlan.setFunction(function5);
		paramToBePricePlan.setParameterType("com.ai.crm.customerorder.domain.model.interfaces.ToBePricePlanInstance");
		function5.addParameter(paramToBePricePlan);		
		
		//value define
		IPolicyVariableValue valToBePricePlanInstance = new PolicyVariableValue();
		valToBePricePlanInstance.setCode("toBePricePlanInstance");				
				
		IPolicyFunctionValueParamRel paramRelPricePlanInstance=new PolicyFunctionValueParamRel();
		paramRelPricePlanInstance.setParameter(paramToBePricePlan);
		paramRelPricePlanInstance.setValue(valToBePricePlanInstance);
		IPolicyFunctionValue setPricePlanInstance=new PolicyFunctionValue();
		setPricePlanInstance.setFunction(function5);		
		setPricePlanInstance.addParam(paramRelPricePlanInstance);
		
		//toBeProduct.assignPrice
		//function and param define
		IPolicyFunction function6=new PolicyFunction();
		function6.setCode("toBeProduct.assignPrice");
		function6.setClassName("toBeProduct");
		function6.setMethodName("assignPrice");
		IPolicyFunctionParameter paramAssignPrice=new PolicyFunctionParameter();
		paramAssignPrice.setFunction(function6);
		paramAssignPrice.setParameterType("com.ai.crm.customerorder.domain.model.interfaces.ToBePricePlanInstance");
		function6.addParameter(paramAssignPrice);		
					
				
		IPolicyFunctionValueParamRel paramRelAssignPricePlanInstance=new PolicyFunctionValueParamRel();
		paramRelAssignPricePlanInstance.setParameter(paramAssignPrice);
		paramRelAssignPricePlanInstance.setValue(valToBePricePlanInstance);
		IPolicyFunctionValue assignPrice=new PolicyFunctionValue();
		assignPrice.setFunction(function6);		
		assignPrice.addParam(paramRelAssignPricePlanInstance);
		
		//toBeOfferInstance.addPricePlanInstance
		//function and param define
		IPolicyFunction function7=new PolicyFunction();
		function7.setCode("toBeOfferInstance.addPricePlanInstance");
		function7.setClassName("toBeOfferInstance");
		function7.setMethodName("addPricePlanInstance");
		IPolicyFunctionParameter paramAddPricePlanInstance=new PolicyFunctionParameter();
		paramAddPricePlanInstance.setFunction(function7);
		paramAddPricePlanInstance.setParameterType("com.ai.crm.customerorder.domain.model.interfaces.ToBePricePlanInstance");
		function7.addParameter(paramAddPricePlanInstance);		
					
				
		IPolicyFunctionValueParamRel paramRelAddPricePlanInstance=new PolicyFunctionValueParamRel();
		paramRelAddPricePlanInstance.setParameter(paramAddPricePlanInstance);
		paramRelAddPricePlanInstance.setValue(valToBePricePlanInstance);
		IPolicyFunctionValue addPricePlanInstance=new PolicyFunctionValue();
		addPricePlanInstance.setFunction(function7);		
		addPricePlanInstance.addParam(paramRelAddPricePlanInstance);
		
		
		//expected Red Color value
		IPolicyVariable expectedCharValue=new PolicyVariable();
		expectedCharValue.setCode("expectedCharValue");
		expectedCharValue.setInitialValue(getProductColorValue);
		
		IPolicyOperatorStringEquals stringEqualsOperator=new PolicyOperatorStringEquals();
		
		//Expectedstatement
		IPolicyConditionStatement conditionStatement=new PolicyConditionStatement();
		conditionStatement.setVariable(expectedCharValue);
		conditionStatement.setValue(redColor);
		conditionStatement.setOperator(stringEqualsOperator);
		
		//condition
		IPolicyAtomicCondition condition=new PolicyAtomicCondition();
		condition.setStatement(conditionStatement);
		
		//action,set up the price to be selected
		IPolicyOperatorMethodInvoke methodInvOper=new PolicyOperatorMethodInvoke();
		IPolicyCompositeAction groupAction=new PolicyCompositeAction();
		
		IPolicyActionStatement actionStatement_setPriceId=new PolicyActionStatement();
		actionStatement_setPriceId.setValue(setPricePlanId);
		actionStatement_setPriceId.setOperator(methodInvOper);
		
		IPolicyAtomicAction action1=new PolicyAtomicAction();
		action1.setStatement(actionStatement_setPriceId);
		groupAction.addChild(action1);
		
		IPolicyActionStatement actionStatement_setPriceValue=new PolicyActionStatement();
		actionStatement_setPriceValue.setValue(setPriceValue);
		actionStatement_setPriceValue.setOperator(methodInvOper);
		
		IPolicyAtomicAction action2=new PolicyAtomicAction();
		action2.setStatement(actionStatement_setPriceValue);
		groupAction.addChild(action2);
		
		IPolicyActionStatement actionStatement_setProduct=new PolicyActionStatement();
		actionStatement_setProduct.setValue(setProduct);
		actionStatement_setProduct.setOperator(methodInvOper);
		
		IPolicyAtomicAction action3=new PolicyAtomicAction();
		action3.setStatement(actionStatement_setProduct);
		groupAction.addChild(action3);
		
		IPolicyActionStatement actionStatement_setPricePlanInstance=new PolicyActionStatement();
		actionStatement_setPricePlanInstance.setValue(setPricePlanInstance);
		actionStatement_setPricePlanInstance.setOperator(methodInvOper);
		
		IPolicyAtomicAction action4=new PolicyAtomicAction();
		action4.setStatement(actionStatement_setPricePlanInstance);
		groupAction.addChild(action4);
		
		IPolicyActionStatement actionStatement_assignPrice=new PolicyActionStatement();
		actionStatement_assignPrice.setValue(assignPrice);
		actionStatement_assignPrice.setOperator(methodInvOper);
		
		IPolicyAtomicAction action5=new PolicyAtomicAction();
		action5.setStatement(actionStatement_assignPrice);
		groupAction.addChild(action5);
		
		IPolicyActionStatement actionStatement_addPricePlanInstance=new PolicyActionStatement();
		actionStatement_addPricePlanInstance.setValue(addPricePlanInstance);
		actionStatement_addPricePlanInstance.setOperator(methodInvOper);
		
		IPolicyAtomicAction action6=new PolicyAtomicAction();
		action6.setStatement(actionStatement_addPricePlanInstance);
		groupAction.addChild(action6);
		
		IPolicyRule rule=new PolicyRule();
		rule.setCondition(condition);
		rule.setAction(groupAction);
		
		IPolicySetInputParameter param2=new PolicySetInputParameter();
		param2.setVariable(varProduct);
		rule.addInputParameter(param2);
		IPolicySetInputParameter param3=new PolicySetInputParameter();
		param3.setVariable(varOfferInstance);
		rule.addInputParameter(param3);	
		
		String ss=rule.toPolicyString();
		System.out.println(ss);
		
		IPolicyExecute serv1=new GroovyPolicyExecute();
		Map<String, Object> context=new HashMap<>();
		IProduct product=new Product();
		IOfferInstance offerInstance =new OfferInstance();
		context.put("toBeProduct", product);
		context.put("toBeOfferInstance", offerInstance);
		serv1.execute(rule, context);
		//assertEquals(resu,new Integer(900));
		IPricePlanInstance[] plInsts=(IPricePlanInstance[])offerInstance.getPricePlanInstances().toArray();
		long pricePlanValue=plInsts[0].getPriceValue();
		assertEquals(pricePlanValue,"200");
		
	}
	

}
