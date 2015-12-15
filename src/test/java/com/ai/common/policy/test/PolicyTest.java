package com.ai.common.policy.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
import com.ai.common.policy.domain.model.PolicyRuleInputParameter;
import com.ai.common.policy.domain.model.PolicySetOutputParameter;
import com.ai.common.policy.domain.model.PolicyPan;
import com.ai.common.policy.domain.model.PolicyVariable;
import com.ai.common.policy.domain.repository.interfaces.IPolicyRepository;
import com.ai.common.policy.domain.service.impl.GroovyPolicyExecute;
import com.ai.common.policy.domain.service.interfaces.IPolicyExecute;
import com.ai.common.rootentity.domain.model.CharacteristicSpec;
import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.crm.customerorder.domain.model.ToBeOfferInstance;
import com.ai.crm.customerorder.domain.model.ToBePricePlanInstance;
import com.ai.crm.customerorder.domain.model.ToBeProduct;
import com.ai.crm.customerorder.domain.model.ToBeProductCharacter;
import com.ai.crm.customerorder.domain.model.ToBeProductCharacterValue;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/root-context.xml","classpath:spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
@Transactional
@Commit
public class PolicyTest {
	@Autowired
	IPolicyRepository policyRepository;
	
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
		
		policyRepository.savePolicyFunction(function);
		
		PolicyRule rule1=new PolicyRule();
		rule1.setCode("TestRule");
		PolicyGroup groupRule=new PolicyGroup();
		groupRule.addPolicySet(rule1);		
		groupRule.setCode("TestGroup");
		
		PolicyVariable var1=new PolicyVariable(rule1);
		var1.setCode("a");
		var1.setVariableType("Integer");
		var1.setInitialInputValue("0");
		PolicyVariable var2=new PolicyVariable(rule1);
		var2.setCode("b");
		var2.setVariableType("Integer");
		var2.setInitialInputValue("0");
		PolicyVariable var3=new PolicyVariable(rule1);
		var3.setCode("c");
		var3.setVariableType("Integer");
		var3.setInitialInputValue("0");
		PolicyVariable var4=new PolicyVariable(rule1);
		var4.setCode("returnValue");
		var4.setVariableType("boolean");
		var4.setInitialInputValue("false");
		PolicyConstValue value1=new PolicyConstValue(rule1);
		value1.setType("Integer");
		value1.setValue("100*10");
		
		PolicyPan rightPanA=new PolicyPan();		
		rightPanA.setPolicyVariable(var1);
		
		PolicyPan rightPanB=new PolicyPan();
		rightPanB.setPolicyVariable(var2);		
		
		PolicyFunctionValue value2=new PolicyFunctionValue(rule1);
		value2.setType("Integer");
		//value2.setValue("tested:a>100");
		//value2.setVariable(var3);
		value2.setFunction(function);
		PolicyFunctionValueParamRel funcValueParam1=new PolicyFunctionValueParamRel();
		funcValueParam1.setParameter(funcParam);
		funcValueParam1.setParamValuePan(rightPanA);
		PolicyFunctionValueParamRel funcValueParam2=new PolicyFunctionValueParamRel();
		funcValueParam2.setParameter(funcParam);
		funcValueParam2.setParamValuePan(rightPanB);
		value2.addParam(funcValueParam1);
		value2.addParam(funcValueParam2);
		
		
		PolicyConstValue value3=new PolicyConstValue(rule1);
		value3.setType("Integer");
		value3.setValue("200");
		PolicyConstValue value4=new PolicyConstValue(rule1);
		value4.setType("boolean");
		value4.setValue("true");
		PolicyConstValue value5=new PolicyConstValue(rule1);
		value5.setType("boolean");
		value5.setValue("false");		
		PolicyOperator opertor1=new PolicyConditionOperator();
		opertor1.setCode(">");
		PolicyOperator opertor2=new PolicyActionOperator();
		opertor2.setCode("=");
		PolicyConditionStatement statement1=new PolicyConditionStatement();
		PolicyPan leftPan1=new PolicyPan();		
		leftPan1.setPolicyVariable(var1);		
		statement1.setLeftPan(leftPan1);
		statement1.setOperator(opertor1);
		PolicyPan rightPan1=new PolicyPan();
		rightPan1.setPolicyValue(value1);		
		statement1.setRightPan(rightPan1);
		
		PolicyConditionStatement statement3=new PolicyConditionStatement();
		PolicyPan leftPan3=new PolicyPan();		
		leftPan3.setPolicyVariable(var3);
		
		statement3.setLeftPan(leftPan3);
		statement3.setOperator(opertor1);
		
		PolicyPan rightPan3=new PolicyPan();
		rightPan3.setPolicyValue(value3);		
		statement3.setRightPan(rightPan3);		
		
		PolicyActionStatement statement2=new PolicyActionStatement();
		PolicyPan leftPan2=new PolicyPan();		
		leftPan2.setPolicyVariable(var2);
		
		statement2.setLeftPan(leftPan2);
		statement2.setOperator(opertor2);
		PolicyPan rightPan2=new PolicyPan();
		rightPan2.setPolicyValue(value2);		
		statement2.setRightPan(rightPan2);	
		
		PolicyActionStatement statement4=new PolicyActionStatement();
		PolicyPan leftPan4=new PolicyPan();		
		leftPan4.setPolicyVariable(var4);
		statement4.setLeftPan(leftPan4);
		statement4.setOperator(opertor2);
		PolicyPan rightPan4=new PolicyPan();
		rightPan4.setPolicyValue(value4);		
		statement4.setRightPan(rightPan4);	

		PolicyActionStatement statement5=new PolicyActionStatement();
		PolicyPan leftPan5=new PolicyPan();		
		leftPan5.setPolicyVariable(var4);
		statement5.setLeftPan(leftPan5);
		statement5.setOperator(opertor2);
		PolicyPan rightPan5=new PolicyPan();
		rightPan5.setPolicyValue(value5);		
		statement5.setRightPan(rightPan5);	

		
		PolicyAtomicCondition condition1=new PolicyAtomicCondition(rule1);
		condition1.setStatement(statement1);
		condition1.setCode("condition1");
		PolicyAtomicCondition condition2=new PolicyAtomicCondition(rule1);
		condition2.setStatement(statement3);
		condition2.setCode("condition2");
		PolicyCompositeCondition condition3=new PolicyCompositeCondition(rule1);
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
		PolicyAtomicAction action1=new PolicyAtomicAction(rule1);
		action1.setStatement(statement2);				
		PolicyAtomicAction action2=new PolicyAtomicAction(rule1);
		action2.setStatement(statement4);
		PolicyCompositeAction action3=new PolicyCompositeAction(rule1);
		action3.addChild(action1);
		action3.addChild(action2);
		rule1.setAction(action3);
		PolicyAtomicAction action5=new PolicyAtomicAction(rule1);
		action5.setStatement(statement5);	
		rule1.setElseAction(action5);
		PolicySetOutputParameter param=new PolicySetOutputParameter();
		param.setVariable(var4);
		groupRule.setOutputParameter(param);
		PolicyRuleInputParameter param2=new PolicyRuleInputParameter();
		param2.setVariable(var1);
		rule1.addInputParameter(param2);
		PolicyRuleInputParameter param3=new PolicyRuleInputParameter();
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
		PolicyRule rule=new PolicyRule();
		//variable define
		PolicyVariable varOfferInstance=new PolicyVariable(rule);
		varOfferInstance.setCode("toBeOfferInstance");
		varOfferInstance.setVariableType("com.ai.crm.customerorder.domain.model.ToBeOfferInstance");
		
		PolicyVariable varProduct=new PolicyVariable(rule);
		varProduct.setCode("toBeProduct");
		varProduct.setVariableType("com.ai.crm.customerorder.domain.model.ToBeProduct");
	
		PolicyVariable varProductPriceRel=new PolicyVariable(rule);
		varProductPriceRel.setCode("toBeProductPriceRel");
		varProductPriceRel.setVariableType("com.ai.crm.customerorder.domain.model.ToBeProductPriceRel");
		varProductPriceRel.setInitialInputValue("new com.ai.crm.customerorder.domain.model.ToBeProductPriceRel()");

		PolicyVariable varPricePlanInstance=new PolicyVariable(rule);
		varPricePlanInstance.setCode("toBePricePlanInstance");
		varPricePlanInstance.setVariableType("com.ai.crm.customerorder.domain.model.ToBePricePlanInstance");
		varPricePlanInstance.setInitialInputValue("new com.ai.crm.customerorder.domain.model.ToBePricePlanInstance()");
		
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
		
		policyRepository.savePolicyFunction(function8);
		
		//variable define
			
		PolicyVariable colorCharCode=new PolicyVariable(rule);
		colorCharCode.setCode("colorCharCode");
		colorCharCode.setVariableType("String");
		
		PolicyVariable colorValueIdx=new PolicyVariable(rule);
		colorValueIdx.setCode("colorValueIdx");
		colorValueIdx.setVariableType("int");
		//colorValueIdx.setInitialValue("0");
		
		//value define
		PolicyConstValue Color = new PolicyConstValue(rule);
		Color.setType("Const");
		Color.setCode("Color");
		Color.setValue("\"Color\"");
		
		PolicyConstValue Gold = new PolicyConstValue(rule);
		Gold.setType("Const");
		Gold.setCode("Gold");
		Gold.setValue("\"Gold\"");
		
		PolicyConstValue firstValue = new PolicyConstValue(rule);
		firstValue.setType("Const");
		firstValue.setCode("firstValue");
		firstValue.setValue("0");
		
		PolicyFunctionValue getProductColorValue=new PolicyFunctionValue(rule);		
		getProductColorValue.setCode("getProductColorValue");
		getProductColorValue.setFunction(function8);
		PolicyFunctionValueParamRel paramRel=new PolicyFunctionValueParamRel();
		paramRel.setFunctionValue(getProductColorValue);
		paramRel.setParameter(characteristicCode);
		
		PolicyPan colorPan=new PolicyPan();
		colorPan.setPolicyValue(Color);		
		paramRel.setParamValuePan(colorPan);
		getProductColorValue.addParam(paramRel);
		
		PolicyFunctionValueParamRel paramRel2=new PolicyFunctionValueParamRel();
		paramRel2.setFunctionValue(getProductColorValue);
		paramRel2.setParameter(characteristicValueIdx);
		PolicyPan firstValuePan=new PolicyPan();
		firstValuePan.setPolicyValue(firstValue);		
		paramRel2.setParamValuePan(firstValuePan);
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
		
		policyRepository.savePolicyFunction(function2);
		
		//value define
		PolicyConstValue monthFeePricePlan = new PolicyConstValue(rule);
		//monthFeePricePlan.setType("Const");
		monthFeePricePlan.setCode("monthFeePricePlan");
		monthFeePricePlan.setValue("10001");
		
				
		PolicyFunctionValueParamRel paramRelPriceId=new PolicyFunctionValueParamRel();
		paramRelPriceId.setParameter(pricePlanId);
		
		PolicyPan monthFeePricePlanPan=new PolicyPan();
		monthFeePricePlanPan.setPolicyValue(monthFeePricePlan);		
		paramRelPriceId.setParamValuePan(monthFeePricePlanPan);
		
		PolicyFunctionValue setPricePlanId=new PolicyFunctionValue(rule);
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
		
		policyRepository.savePolicyFunction(function3);
		
		//value define	
		PolicyConstValue PriceValue = new PolicyConstValue(rule);
		//PriceValue200.setType("Const");
		PriceValue.setCode("PriceValue200");
		PriceValue.setValue("5888");
		
		PolicyFunctionValueParamRel paramRelPriceValue=new PolicyFunctionValueParamRel();
		paramRelPriceValue.setParameter(priceFuncParam);
		PolicyPan PriceValuePan=new PolicyPan();
		PriceValuePan.setPolicyValue(PriceValue);		
		paramRelPriceValue.setParamValuePan(PriceValuePan);
		
		PolicyFunctionValue setPriceValue=new PolicyFunctionValue(rule);
		setPriceValue.setFunction(function3);		
		setPriceValue.addParam(paramRelPriceValue);
		
		PolicyPan toBePricePlanInstancePan=new PolicyPan();
		toBePricePlanInstancePan.setPolicyVariable(varPricePlanInstance);		
		
		//toBeProduct.assignPrice
		//function and param define
		PolicyFunction function6=new PolicyFunction();
		function6.setCode("toBePricePlanInstance.assignTo");
		function6.setClassName("toBePricePlanInstance");
		function6.setMethodName("assignTo");
		PolicyFunctionParameter paramAssignProduct=new PolicyFunctionParameter();
		paramAssignProduct.setFunction(function6);
		paramAssignProduct.setParameterType("com.ai.crm.customerorder.domain.model.ToBeProduct");
		function6.addParameter(paramAssignProduct);
		PolicyFunctionParameter paramAssignPeriod=new PolicyFunctionParameter();
		paramAssignPeriod.setFunction(function6);
		paramAssignPeriod.setParameterType("com.ai.common.basetype.TimePeriod");
		function6.addParameter(paramAssignPeriod);
		
		policyRepository.savePolicyFunction(function6);
		
		PolicyFunctionValueParamRel paramRelAssignProduct=new PolicyFunctionValueParamRel();
		paramRelAssignProduct.setParameter(paramAssignProduct);
		PolicyPan toBeAssignProductPan=new PolicyPan();
		toBeAssignProductPan.setPolicyVariable(varProduct);		
		paramRelAssignProduct.setParamValuePan(toBeAssignProductPan);
		
		PolicyFunctionValueParamRel paramRelAssignPeriod=new PolicyFunctionValueParamRel();
		paramRelAssignPeriod.setParameter(paramAssignProduct);
		PolicyPan toBeAssignProductPeriodPan=new PolicyPan();
		PolicyConstValue periodValue=new PolicyConstValue(rule);
		periodValue.setValue("null");
		toBeAssignProductPeriodPan.setPolicyValue(periodValue);	
		paramRelAssignPeriod.setParamValuePan(toBeAssignProductPeriodPan);
		
		PolicyFunctionValue assignPrice=new PolicyFunctionValue(rule);		
		assignPrice.setFunction(function6);		
		assignPrice.addParam(paramRelAssignProduct);
		assignPrice.addParam(paramRelAssignPeriod);
		
		
		//toBeOfferInstance.addPricePlanInstance
		//function and param define
		PolicyFunction function7=new PolicyFunction();
		function7.setCode("toBeOfferInstance.addPricePlanInstance");
		function7.setClassName("toBeOfferInstance");
		function7.setMethodName("addPricePlanInstance");
		PolicyFunctionParameter paramAddPricePlanInstance=new PolicyFunctionParameter();
		paramAddPricePlanInstance.setFunction(function7);
		paramAddPricePlanInstance.setParameterType("com.ai.crm.customerorder.domain.model.ToBePricePlanInstance");
		function7.addParameter(paramAddPricePlanInstance);		
		
		policyRepository.savePolicyFunction(function7);
				
		PolicyFunctionValueParamRel paramRelAddPricePlanInstance=new PolicyFunctionValueParamRel();
		paramRelAddPricePlanInstance.setParameter(paramAddPricePlanInstance);
		paramRelAddPricePlanInstance.setParamValuePan(toBePricePlanInstancePan);
		PolicyFunctionValue addPricePlanInstance=new PolicyFunctionValue(rule);
		addPricePlanInstance.setFunction(function7);		
		addPricePlanInstance.addParam(paramRelAddPricePlanInstance);
		
		
		//expected Gold Color value
		PolicyVariable expectedCharValue=new PolicyVariable(rule);
		expectedCharValue.setCode("expectedCharValue");
		expectedCharValue.setInitialValue(getProductColorValue);
		expectedCharValue.setVariableType("String");
		
		PolicyOperatorStringEquals stringEqualsOperator=new PolicyOperatorStringEquals();
		stringEqualsOperator.setCode("equalsIgnoreCase");
		
		policyRepository.savePolicyOperator(stringEqualsOperator);
		
		//Expectedstatement
		PolicyConditionStatement conditionStatement=new PolicyConditionStatement();
		conditionStatement.setCode("conditionStatement");
		PolicyPan leftPan=new PolicyPan();
		leftPan.setPolicyVariable(expectedCharValue);
		conditionStatement.setLeftPan(leftPan);
		PolicyPan rightPan=new PolicyPan();
		rightPan.setPolicyValue(Gold);
		conditionStatement.setRightPan(rightPan);
		conditionStatement.setOperator(stringEqualsOperator);
		
		//condition
		PolicyAtomicCondition condition=new PolicyAtomicCondition(rule);
		condition.setStatement(conditionStatement);
		
		//action,set up the price to be selected
		PolicyOperatorMethodInvoke methodInvOper=new PolicyOperatorMethodInvoke();
		policyRepository.savePolicyOperator(methodInvOper);
		
		PolicyCompositeAction groupAction=new PolicyCompositeAction(rule);
		groupAction.setCode("groupAction");
		
		PolicyActionStatement actionStatement_setPriceId=new PolicyActionStatement();
		actionStatement_setPriceId.setCode("actionStatement_setPriceId");
		PolicyPan setPricePlanIdPan=new PolicyPan();
		setPricePlanIdPan.setPolicyValue(setPricePlanId);
		actionStatement_setPriceId.setRightPan(setPricePlanIdPan);
		actionStatement_setPriceId.setOperator(methodInvOper);
		
		PolicyAtomicAction action1=new PolicyAtomicAction(rule);
		action1.setCode("action1");
		action1.setStatement(actionStatement_setPriceId);
		groupAction.addChild(action1);
		
		PolicyActionStatement actionStatement_setPriceValue=new PolicyActionStatement();
		actionStatement_setPriceValue.setCode("actionStatement_setPriceValue");
		PolicyPan setPriceValuePan=new PolicyPan();
		setPriceValuePan.setPolicyValue(setPriceValue);
		actionStatement_setPriceValue.setRightPan(setPriceValuePan);
		actionStatement_setPriceValue.setOperator(methodInvOper);
		
		PolicyAtomicAction action2=new PolicyAtomicAction(rule);
		action2.setCode("action2");
		action2.setStatement(actionStatement_setPriceValue);
		groupAction.addChild(action2);		
				
		PolicyActionStatement actionStatement_assignPrice=new PolicyActionStatement();
		actionStatement_assignPrice.setCode("actionStatement_assignPrice");
		
		PolicyPan assignPricePan=new PolicyPan();
		assignPricePan.setPolicyValue(assignPrice);
		actionStatement_assignPrice.setRightPan(assignPricePan);
		actionStatement_assignPrice.setOperator(methodInvOper);
		
		PolicyAtomicAction action5=new PolicyAtomicAction(rule);
		action5.setCode("action5");
		action5.setStatement(actionStatement_assignPrice);
		groupAction.addChild(action5);
		
		PolicyActionStatement actionStatement_addPricePlanInstance=new PolicyActionStatement();
		PolicyPan addPricePlanInstancePan=new PolicyPan();
		addPricePlanInstancePan.setPolicyValue(addPricePlanInstance);
		actionStatement_addPricePlanInstance.setRightPan(addPricePlanInstancePan);
		actionStatement_addPricePlanInstance.setOperator(methodInvOper);
		
		PolicyAtomicAction action6=new PolicyAtomicAction(rule);
		action6.setCode("action6");
		action6.setStatement(actionStatement_addPricePlanInstance);
		groupAction.addChild(action6);
		
		rule.setCondition(condition);
		rule.setAction(groupAction);
		rule.setCode("SelectPriceFromProductAttr");
		
		PolicyRuleInputParameter param2=new PolicyRuleInputParameter();
		param2.setVariable(varProduct);
		rule.addInputParameter(param2);
		PolicyRuleInputParameter param3=new PolicyRuleInputParameter();
		param3.setVariable(varOfferInstance);
		rule.addInputParameter(param3);	
		
		policyRepository.savePolicySet(rule);
		
		String ss=rule.toPolicyString();
		System.out.println(ss);
		
		IPolicyExecute serv1=new GroovyPolicyExecute();
		Map<String, Object> context=new HashMap<>();
		ToBeProduct product=new ToBeProduct();
		ToBeProductCharacter instChar=new ToBeProductCharacter();		
		CharacteristicSpec character=new CharacteristicSpec();
		character.setCode("Color");
		character.setId(1);
		instChar.setCharacteristicSpec(character);
		product.addProductCharacter(instChar);
		ToBeProductCharacterValue instCharValue=new ToBeProductCharacterValue();	
		CharacteristicSpecValue characterValue=new CharacteristicSpecValue();
		characterValue.setCode("Gold");
		characterValue.setId(2);
		characterValue.setValue("Gold");
		instCharValue.setCharacteristicValue(characterValue);
		instChar.addCharacteristicInstanceValue(instCharValue);
		ToBeOfferInstance offerInstance =new ToBeOfferInstance();
		context.put("toBeProduct", product);
		context.put("toBeOfferInstance", offerInstance);
		serv1.execute(rule, context);
		ToBePricePlanInstance[] plInsts=(ToBePricePlanInstance[])offerInstance.getPricePlanInstances().toArray(new ToBePricePlanInstance[0]);
		long pricePlanValue=0;
		if (plInsts.length>0){
			pricePlanValue=plInsts[0].getPriceValue();
		}		
		assertEquals(pricePlanValue,5888);
		
	}
	

}
