package com.ai.common.policy.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.ai.common.policy.domain.model.PolicyActionOperator;
import com.ai.common.policy.domain.model.PolicyActionStatement;
import com.ai.common.policy.domain.model.PolicyAtomicAction;
import com.ai.common.policy.domain.model.PolicyAtomicCondition;
import com.ai.common.policy.domain.model.PolicyCompositeAction;
import com.ai.common.policy.domain.model.PolicyCompositeCondition;
import com.ai.common.policy.domain.model.PolicyCompositeConditionOption;
import com.ai.common.policy.domain.model.PolicyConditionOperator;
import com.ai.common.policy.domain.model.PolicyConditionStatement;
import com.ai.common.policy.domain.model.PolicyConstValue;
import com.ai.common.policy.domain.model.PolicyFunction;
import com.ai.common.policy.domain.model.PolicyFunctionParameter;
import com.ai.common.policy.domain.model.PolicyFunctionValue;
import com.ai.common.policy.domain.model.PolicyFunctionValueParamRel;
import com.ai.common.policy.domain.model.PolicyGroup;
import com.ai.common.policy.domain.model.PolicyOperator;
import com.ai.common.policy.domain.model.PolicyOperatorMethodInvoke;
import com.ai.common.policy.domain.model.PolicyOperatorStringEquals;
import com.ai.common.policy.domain.model.PolicyRule;
import com.ai.common.policy.domain.model.PolicySetInputParameter;
import com.ai.common.policy.domain.model.PolicySetOutputParameter;
import com.ai.common.policy.domain.model.PolicyVariable;
import com.ai.common.policy.domain.model.PolicyVariableValue;
import com.ai.common.policy.domain.service.impl.GroovyPolicyExecute;
import com.ai.common.policy.domain.service.interfaces.IPolicyExecute;
import com.ai.common.rootentity.domain.model.InstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.InstanceEntityCharacterValue;
import com.ai.crm.customerorder.domain.model.ToBeOfferInstance;
import com.ai.crm.customerorder.domain.model.ToBePricePlanInstance;
import com.ai.crm.customerorder.domain.model.ToBeProduct;

public class PolicyTest {
	
	@Before
	public void prepare() throws Exception{
		 
	}

	@Test
	@Ignore
	public void test() throws Exception{
		PolicyFunction function=new PolicyFunction();
		function.setCode("com.ai.common.policy.test.TestUtil.add");
		function.setClassName("com.ai.common.policy.test.TestUtil");
		function.setMethodName("add");
		PolicyFunctionParameter funcParam=new PolicyFunctionParameter();
		funcParam.setFunction(function);
		funcParam.setParameterType("Integer");
		function.addParameter(funcParam);
		PolicyFunctionParameter funcParam2=new PolicyFunctionParameter();
		funcParam2.setFunction(function);
		funcParam2.setParameterType("Integer");
		function.addParameter(funcParam2);
		
		PolicyRule rule1=new PolicyRule();
		rule1.setCode("TestRule");
		PolicyGroup groupRule=new PolicyGroup();
		groupRule.addPolicySet(rule1);		
		groupRule.setCode("TestGroup");
		
		PolicyVariable var1=new PolicyVariable();
		var1.setCode("a");
		var1.setVariableType("Integer");
		var1.setInitialInputValue("0");
		PolicyVariable var2=new PolicyVariable();
		var2.setCode("b");
		var2.setVariableType("Integer");
		var2.setInitialInputValue("0");
		PolicyVariable var3=new PolicyVariable();
		var3.setCode("c");
		var3.setVariableType("Integer");
		var3.setInitialInputValue("0");
		PolicyVariable var4=new PolicyVariable();
		var4.setCode("returnValue");
		var4.setVariableType("boolean");
		var4.setInitialInputValue("false");
		PolicyConstValue value1=new PolicyConstValue();
		value1.setType("Integer");
		value1.setValue("100*10");
		
		PolicyVariableValue valueA=new PolicyVariableValue();
		valueA.setVariable(var1);
		
		PolicyVariableValue valueB=new PolicyVariableValue();
		valueB.setVariable(var2);		
		
		PolicyFunctionValue value2=new PolicyFunctionValue();
		value2.setType("Integer");
		//value2.setValue("tested:a>100");
		//value2.setVariable(var3);
		value2.setFunction(function);
		PolicyFunctionValueParamRel funcValueParam1=new PolicyFunctionValueParamRel();
		funcValueParam1.setParameter(funcParam);
		funcValueParam1.setValue(valueA);
		PolicyFunctionValueParamRel funcValueParam2=new PolicyFunctionValueParamRel();
		funcValueParam2.setParameter(funcParam);
		funcValueParam2.setValue(valueB);
		value2.addParam(funcValueParam1);
		value2.addParam(funcValueParam2);
		
		
		PolicyConstValue value3=new PolicyConstValue();
		value3.setType("Integer");
		value3.setValue("200");
		PolicyConstValue value4=new PolicyConstValue();
		value4.setType("boolean");
		value4.setValue("true");
		PolicyConstValue value5=new PolicyConstValue();
		value5.setType("boolean");
		value5.setValue("false");		
		PolicyOperator opertor1=new PolicyConditionOperator();
		opertor1.setCode(">");
		PolicyOperator opertor2=new PolicyActionOperator();
		opertor2.setCode("=");
		PolicyConditionStatement statement1=new PolicyConditionStatement();
		statement1.setVariable(var1);
		statement1.setOperator(opertor1);
		statement1.setValue(value1);
		PolicyConditionStatement statement3=new PolicyConditionStatement();
		statement3.setVariable(var3);
		statement3.setOperator(opertor1);
		statement3.setValue(value3);		
		PolicyActionStatement statement2=new PolicyActionStatement();
		statement2.setVariable(var2);
		statement2.setOperator(opertor2);
		statement2.setValue(value2);
		PolicyActionStatement statement4=new PolicyActionStatement();
		statement4.setVariable(var4);
		statement4.setOperator(opertor2);
		statement4.setValue(value4);	
		PolicyActionStatement statement5=new PolicyActionStatement();
		statement5.setVariable(var4);
		statement5.setOperator(opertor2);
		statement5.setValue(value5);		
		PolicyAtomicCondition condition1=new PolicyAtomicCondition();
		condition1.setStatement(statement1);
		condition1.setCode("condition1");
		PolicyAtomicCondition condition2=new PolicyAtomicCondition();
		condition2.setStatement(statement3);
		condition2.setCode("condition2");
		PolicyCompositeCondition condition3=new PolicyCompositeCondition();
		condition3.setAnd();
		condition3.setCode("condition3");
		PolicyCompositeConditionOption compositeConditionOption=new PolicyCompositeConditionOption();
		compositeConditionOption.setParentCondition(condition3);
		compositeConditionOption.setChildCondition(condition1);
		PolicyCompositeConditionOption compositeConditionOption2=new PolicyCompositeConditionOption();
		compositeConditionOption2.setParentCondition(condition3);
		compositeConditionOption2.setChildCondition(condition2);
		condition3.addChild(compositeConditionOption);
		condition3.addChild(compositeConditionOption2);	
		rule1.setCondition(condition3);
		PolicyAtomicAction action1=new PolicyAtomicAction();
		action1.setStatement(statement2);				
		PolicyAtomicAction action2=new PolicyAtomicAction();
		action2.setStatement(statement4);
		PolicyCompositeAction action3=new PolicyCompositeAction();
		action3.addChild(action1);
		action3.addChild(action2);
		rule1.setAction(action3);
		PolicyAtomicAction action5=new PolicyAtomicAction();
		action5.setStatement(statement5);	
		rule1.setElseAction(action5);
		PolicySetOutputParameter param=new PolicySetOutputParameter();
		param.setVariable(var4);
		groupRule.setOutputParameter(param);
		PolicySetInputParameter param2=new PolicySetInputParameter();
		param2.setVariable(var1);
		rule1.addInputParameter(param2);
		PolicySetInputParameter param3=new PolicySetInputParameter();
		param3.setVariable(var3);
		rule1.addInputParameter(param3);	
		
		PolicyRule rule2=new PolicyRule();
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
		PolicyVariable varOfferInstance=new PolicyVariable();
		varOfferInstance.setCode("toBeOfferInstance");
		varOfferInstance.setVariableType("com.ai.crm.customerorder.domain.model.interfaces.ToBeOfferInstance");
		
		PolicyVariable varProduct=new PolicyVariable();
		varProduct.setCode("toBeProduct");
		varProduct.setVariableType("com.ai.crm.customerorder.domain.model.interfaces.ToBeProduct");
	
		PolicyVariable varProductPriceRel=new PolicyVariable();
		varProductPriceRel.setCode("toBeProductPriceRel");
		varProductPriceRel.setVariableType("com.ai.crm.customerorder.domain.model.interfaces.ToBeProductPriceRel");
		varProductPriceRel.setInitialInputValue("new com.ai.crm.customerorder.domain.model.impl.ToBeProductPriceRel()");

		PolicyVariable varPricePlanInstance=new PolicyVariable();
		varPricePlanInstance.setCode("toBePricePlanInstance");
		varPricePlanInstance.setVariableType("com.ai.crm.customerorder.domain.model.interfaces.ToBePricePlanInstance");
		varPricePlanInstance.setInitialInputValue("new com.ai.crm.customerorder.domain.model.impl.ToBePricePlanInstance()");
		
		//getColorValue
		//function and param define
		PolicyFunction function8=new PolicyFunction();
		function8.setCode("getProductColorValue");
		function8.setClassName("toBeProduct");
		function8.setMethodName("getInstEntityCharValueByCharCode");
		PolicyFunctionParameter characteristicCode=new PolicyFunctionParameter();
		characteristicCode.setCode("characteristicCode");
		characteristicCode.setFunction(function8);
		characteristicCode.setParameterType("String");
		function8.addParameter(characteristicCode);
		PolicyFunctionParameter characteristicValueIdx=new PolicyFunctionParameter();
		characteristicValueIdx.setCode("characteristicValueIdx");
		characteristicValueIdx.setFunction(function8);
		characteristicValueIdx.setParameterType("int");
		function8.addParameter(characteristicValueIdx);
		
		//variable define
			
		PolicyVariable colorCharCode=new PolicyVariable();
		colorCharCode.setCode("colorCharCode");
		colorCharCode.setVariableType("String");
		
		PolicyVariable colorValueIdx=new PolicyVariable();
		colorValueIdx.setCode("colorValueIdx");
		colorValueIdx.setVariableType("int");
		//colorValueIdx.setInitialValue("0");
		
		//value define
		PolicyConstValue Color = new PolicyConstValue();
		Color.setType("Const");
		Color.setCode("Color");
		Color.setValue("\"Color\"");
		
		PolicyConstValue Gold = new PolicyConstValue();
		Gold.setType("Const");
		Gold.setCode("Gold");
		Gold.setValue("\"Gold\"");
		
		PolicyConstValue firstValue = new PolicyConstValue();
		firstValue.setType("Const");
		firstValue.setCode("firstValue");
		firstValue.setValue("0");
		
		PolicyFunctionValue getProductColorValue=new PolicyFunctionValue();		
		getProductColorValue.setCode("getProductColorValue");
		getProductColorValue.setFunction(function8);
		PolicyFunctionValueParamRel paramRel=new PolicyFunctionValueParamRel();
		paramRel.setFunctionValue(getProductColorValue);
		paramRel.setParameter(characteristicCode);
		paramRel.setValue(Color);
		getProductColorValue.addParam(paramRel);
		
		PolicyFunctionValueParamRel paramRel2=new PolicyFunctionValueParamRel();
		paramRel2.setFunctionValue(getProductColorValue);
		paramRel2.setParameter(characteristicValueIdx);
		paramRel2.setValue(firstValue);
		getProductColorValue.addParam(paramRel2);		
		
		//toBePricePlanInstance.setPricePlanId
		//function and param define
		PolicyFunction function2=new PolicyFunction();
		function2.setCode("toBePricePlanInstance.setPricePlanId");
		function2.setClassName("toBePricePlanInstance");
		function2.setMethodName("setPricePlanId");
		PolicyFunctionParameter pricePlanId=new PolicyFunctionParameter();
		pricePlanId.setFunction(function2);
		pricePlanId.setParameterType("long");
		function2.addParameter(pricePlanId);
		
		//value define
		PolicyConstValue monthFeePricePlan = new PolicyConstValue();
		//monthFeePricePlan.setType("Const");
		monthFeePricePlan.setCode("monthFeePricePlan");
		monthFeePricePlan.setValue("10001");
		
				
		PolicyFunctionValueParamRel paramRelPriceId=new PolicyFunctionValueParamRel();
		paramRelPriceId.setParameter(pricePlanId);
		paramRelPriceId.setValue(monthFeePricePlan);
		PolicyFunctionValue setPricePlanId=new PolicyFunctionValue();
		setPricePlanId.setFunction(function2);		
		setPricePlanId.addParam(paramRelPriceId);
		
		//toBePricePlanInstance.setValue
		//function and param define
		PolicyFunction function3=new PolicyFunction();
		function3.setCode("toBePricePlanInstance.setPriceValue");
		function3.setClassName("toBePricePlanInstance");
		function3.setMethodName("setPriceValue");
		PolicyFunctionParameter priceFuncParam=new PolicyFunctionParameter();
		priceFuncParam.setFunction(function3);
		priceFuncParam.setParameterType("long");
		function3.addParameter(priceFuncParam);
		
		//value define	
		PolicyConstValue PriceValue = new PolicyConstValue();
		//PriceValue200.setType("Const");
		PriceValue.setCode("PriceValue200");
		PriceValue.setValue("5888");
		
		PolicyFunctionValueParamRel paramRelPriceValue=new PolicyFunctionValueParamRel();
		paramRelPriceValue.setParameter(priceFuncParam);
		paramRelPriceValue.setValue(PriceValue);
		PolicyFunctionValue setPriceValue=new PolicyFunctionValue();
		setPriceValue.setFunction(function3);		
		setPriceValue.addParam(paramRelPriceValue);
		
		//toBeProductPriceRel.setProduct
		//function and param define
		PolicyFunction function4=new PolicyFunction();
		function4.setCode("toBeProductPriceRel.setProduct");
		function4.setClassName("toBeProductPriceRel");
		function4.setMethodName("setProduct");
		PolicyFunctionParameter paramToBeProduct=new PolicyFunctionParameter();
		paramToBeProduct.setFunction(function4);
		paramToBeProduct.setParameterType("com.ai.crm.customerorder.domain.model.interfaces.ToBeProduct");
		function4.addParameter(paramToBeProduct);		
		
		//value define
		PolicyVariableValue toBeProduct = new PolicyVariableValue();
		toBeProduct.setCode("toBeProduct");	
		toBeProduct.setVariable(varProduct);
				
		PolicyFunctionValueParamRel paramRelProduct=new PolicyFunctionValueParamRel();
		paramRelProduct.setParameter(paramToBeProduct);
		paramRelProduct.setValue(toBeProduct);
		PolicyFunctionValue setProduct=new PolicyFunctionValue();
		setProduct.setFunction(function4);		
		setProduct.addParam(paramRelProduct);
		
		//toBeProductPriceRel.setPricePlanInstance
		//function and param define
		PolicyFunction function5=new PolicyFunction();
		function5.setCode("toBeProductPriceRel.setPricePlanInstance");
		function5.setClassName("toBeProductPriceRel");
		function5.setMethodName("setPricePlanInstance");
		PolicyFunctionParameter paramToBePricePlan=new PolicyFunctionParameter();
		paramToBePricePlan.setFunction(function5);
		paramToBePricePlan.setParameterType("com.ai.crm.customerorder.domain.model.interfaces.ToBePricePlanInstance");
		function5.addParameter(paramToBePricePlan);		
		
		//value define
		PolicyVariableValue toBePricePlanInstance = new PolicyVariableValue();
		toBePricePlanInstance.setCode("toBePricePlanInstance");	
		toBePricePlanInstance.setVariable(varPricePlanInstance);
				
		PolicyFunctionValueParamRel paramRelPricePlanInstance=new PolicyFunctionValueParamRel();
		paramRelPricePlanInstance.setParameter(paramToBePricePlan);
		paramRelPricePlanInstance.setValue(toBePricePlanInstance);
		PolicyFunctionValue setPricePlanInstance=new PolicyFunctionValue();
		setPricePlanInstance.setFunction(function5);		
		setPricePlanInstance.addParam(paramRelPricePlanInstance);
		
		//toBeProduct.assignPrice
		//function and param define
		PolicyFunction function6=new PolicyFunction();
		function6.setCode("toBeProduct.assignPrice");
		function6.setClassName("toBeProduct");
		function6.setMethodName("assignPrice");
		PolicyFunctionParameter paramAssignPrice=new PolicyFunctionParameter();
		paramAssignPrice.setFunction(function6);
		paramAssignPrice.setParameterType("com.ai.crm.customerorder.domain.model.interfaces.IProductPriceRel");
		function6.addParameter(paramAssignPrice);		
		
		//value define
		PolicyVariableValue toBeProductPriceRel = new PolicyVariableValue();
		toBeProductPriceRel.setCode("toBeProductPriceRel");	
		toBeProductPriceRel.setVariable(varProductPriceRel);
		
		PolicyFunctionValueParamRel paramRelAssignPricePlanInstance=new PolicyFunctionValueParamRel();
		paramRelAssignPricePlanInstance.setParameter(paramAssignPrice);
		paramRelAssignPricePlanInstance.setValue(toBeProductPriceRel);
		PolicyFunctionValue assignPrice=new PolicyFunctionValue();		
		assignPrice.setFunction(function6);		
		assignPrice.addParam(paramRelAssignPricePlanInstance);
		
		
		//toBeOfferInstance.addPricePlanInstance
		//function and param define
		PolicyFunction function7=new PolicyFunction();
		function7.setCode("toBeOfferInstance.addPricePlanInstance");
		function7.setClassName("toBeOfferInstance");
		function7.setMethodName("addPricePlanInstance");
		PolicyFunctionParameter paramAddPricePlanInstance=new PolicyFunctionParameter();
		paramAddPricePlanInstance.setFunction(function7);
		paramAddPricePlanInstance.setParameterType("com.ai.crm.customerorder.domain.model.interfaces.ToBePricePlanInstance");
		function7.addParameter(paramAddPricePlanInstance);		
					
				
		PolicyFunctionValueParamRel paramRelAddPricePlanInstance=new PolicyFunctionValueParamRel();
		paramRelAddPricePlanInstance.setParameter(paramAddPricePlanInstance);
		paramRelAddPricePlanInstance.setValue(toBePricePlanInstance);
		PolicyFunctionValue addPricePlanInstance=new PolicyFunctionValue();
		addPricePlanInstance.setFunction(function7);		
		addPricePlanInstance.addParam(paramRelAddPricePlanInstance);
		
		
		//expected Gold Color value
		PolicyVariable expectedCharValue=new PolicyVariable();
		expectedCharValue.setCode("expectedCharValue");
		expectedCharValue.setInitialValue(getProductColorValue);
		expectedCharValue.setVariableType("String");
		
		PolicyOperatorStringEquals stringEqualsOperator=new PolicyOperatorStringEquals();
		stringEqualsOperator.setCode("equalsIgnoreCase");
		
		//Expectedstatement
		PolicyConditionStatement conditionStatement=new PolicyConditionStatement();
		conditionStatement.setVariable(expectedCharValue);
		conditionStatement.setValue(Gold);
		conditionStatement.setOperator(stringEqualsOperator);
		
		//condition
		PolicyAtomicCondition condition=new PolicyAtomicCondition();
		condition.setStatement(conditionStatement);
		
		//action,set up the price to be selected
		PolicyOperatorMethodInvoke methodInvOper=new PolicyOperatorMethodInvoke();
		PolicyCompositeAction groupAction=new PolicyCompositeAction();
		
		PolicyActionStatement actionStatement_setPriceId=new PolicyActionStatement();
		actionStatement_setPriceId.setValue(setPricePlanId);
		actionStatement_setPriceId.setOperator(methodInvOper);
		
		PolicyAtomicAction action1=new PolicyAtomicAction();
		action1.setStatement(actionStatement_setPriceId);
		groupAction.addChild(action1);
		
		PolicyActionStatement actionStatement_setPriceValue=new PolicyActionStatement();
		actionStatement_setPriceValue.setValue(setPriceValue);
		actionStatement_setPriceValue.setOperator(methodInvOper);
		
		PolicyAtomicAction action2=new PolicyAtomicAction();
		action2.setStatement(actionStatement_setPriceValue);
		groupAction.addChild(action2);
		
		PolicyActionStatement actionStatement_setProduct=new PolicyActionStatement();
		actionStatement_setProduct.setValue(setProduct);
		actionStatement_setProduct.setOperator(methodInvOper);
		
		PolicyAtomicAction action3=new PolicyAtomicAction();
		action3.setStatement(actionStatement_setProduct);
		groupAction.addChild(action3);
		
		PolicyActionStatement actionStatement_setPricePlanInstance=new PolicyActionStatement();
		actionStatement_setPricePlanInstance.setValue(setPricePlanInstance);
		actionStatement_setPricePlanInstance.setOperator(methodInvOper);
		
		PolicyAtomicAction action4=new PolicyAtomicAction();
		action4.setStatement(actionStatement_setPricePlanInstance);
		groupAction.addChild(action4);
		
		PolicyActionStatement actionStatement_assignPrice=new PolicyActionStatement();
		actionStatement_assignPrice.setValue(assignPrice);
		actionStatement_assignPrice.setOperator(methodInvOper);
		
		PolicyAtomicAction action5=new PolicyAtomicAction();
		action5.setStatement(actionStatement_assignPrice);
		groupAction.addChild(action5);
		
		PolicyActionStatement actionStatement_addPricePlanInstance=new PolicyActionStatement();
		actionStatement_addPricePlanInstance.setValue(addPricePlanInstance);
		actionStatement_addPricePlanInstance.setOperator(methodInvOper);
		
		PolicyAtomicAction action6=new PolicyAtomicAction();
		action6.setStatement(actionStatement_addPricePlanInstance);
		groupAction.addChild(action6);
		
		PolicyRule rule=new PolicyRule();
		rule.setCondition(condition);
		rule.setAction(groupAction);
		rule.setCode("SelectPriceFromProductAttr");
		
		PolicySetInputParameter param2=new PolicySetInputParameter();
		param2.setVariable(varProduct);
		rule.addInputParameter(param2);
		PolicySetInputParameter param3=new PolicySetInputParameter();
		param3.setVariable(varOfferInstance);
		rule.addInputParameter(param3);	
		
		String ss=rule.toPolicyString();
		System.out.println(ss);
		
		IPolicyExecute serv1=new GroovyPolicyExecute();
		Map<String, Object> context=new HashMap<>();
		ToBeProduct product=new ToBeProduct();
		InstanceEntityCharacter instChar=new InstanceEntityCharacter();				
		instChar.setCharacteristicSpecId(1);
		product.addCharacteristic(instChar);
		InstanceEntityCharacterValue instCharValue=new InstanceEntityCharacterValue();		
		instCharValue.setCharacteristicValueId(2);
		instChar.addCharacteristicInstanceValue(instCharValue);
		ToBeOfferInstance offerInstance =new ToBeOfferInstance();
		context.put("toBeProduct", product);
		context.put("toBeOfferInstance", offerInstance);
		serv1.execute(rule, context);
		ToBePricePlanInstance[] plInsts=(ToBePricePlanInstance[])offerInstance.getPricePlanInstances().toArray(new ToBePricePlanInstance[0]);
		long pricePlanValue=plInsts[0].getPriceValue();
		assertEquals(pricePlanValue,200);
		
	}
	

}
