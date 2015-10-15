package com.ai.common.policy.domain.model.impl;

import java.util.Set;

import com.ai.common.policy.domain.model.interfaces.IPolicyAction;
import com.ai.common.policy.domain.model.interfaces.IPolicySet;
import com.ai.common.policy.domain.model.interfaces.IPolicySetInputParameter;
import com.ai.common.policy.domain.model.interfaces.IPolicySetOutputParameter;
import com.ai.common.rootentity.domain.model.impl.InstanceEntity;

public abstract class PolicySet extends InstanceEntity implements IPolicySet {
	private long id;
	private String name;
	private String code;
	private IPolicySetOutputParameter outputParam;	
	private IPolicyAction elseAction;
	
	public PolicySet() {
	}

	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public void setId(long id) {
		this.id=id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public void setCode(String code) {
		this.code=code;
	}

	@Override
	public boolean hasCharacteristic() {
		return false;
	}
	
	@Override
	abstract public Set<IPolicySetInputParameter> getInputParameters();

	@Override
	public IPolicySetOutputParameter getOutputParameter() {
		return this.outputParam;
	}

	@Override
	public void setOutputParameter(IPolicySetOutputParameter param) {
		this.outputParam=param;
	}	
	
	@Override
	public IPolicyAction getElseAction() {
		return this.elseAction;
	}	

	@Override
	public void setElseAction(IPolicyAction elseAction) {
		this.elseAction=elseAction;		
	}
	
	@Override
	public abstract String toBodyString();
	
	@Override
	public abstract String getVariableDeclareString();
	
	@Override
	public String toPolicyString() {
		String returnVar="";
		String returnVarType="";
		if(null!=this.getOutputParameter()){
			returnVar=this.getOutputParameter().getVariable().getCode();
			returnVarType=(String)this.getOutputParameter().getVariable().getVariableType();
		}
		StringBuffer classBody=new StringBuffer();
		String className="aiPolicy"+this.getCode();
		StringBuffer classHead= new StringBuffer();
		StringBuffer constructor= new StringBuffer();
		StringBuffer methodDeclare= new StringBuffer();
		String classEnd="}\n";
		String methodEnd="    }\n";
		classHead.append("package com.ai.policy;\n")
		.append("import java.util.Map;\n")
		.append("public class ")
		.append(className)
		.append("{\n");
		constructor.append("    public ").append(className).append("(){\n    }\n");
		methodDeclare.append("        ").append("boolean matched=false;\n");
		for (IPolicySetInputParameter param : this.getInputParameters()) {
			methodDeclare.append("        ").append(param.getVariable().getCode())			
			.append(" = ")
			.append("(").append(param.getVariable().getVariableType()).append(")")
			.append("context.get(\"").append(param.getVariable().getCode()).append("\")")
			.append(";\n");
		}
		StringBuffer method= new StringBuffer();
		method.append("    public ");
		if(null!=this.getOutputParameter()){
			method.append(returnVarType);
		}else{
			method.append("void");
		}
		
		method.append(" ").append("executePolicy(").append("Map<String, Object> context").append(") throws Exception {\n")
		.append(this.getVariableDeclareString())
		.append(methodDeclare.toString())
		.append("        ").append(this.toBodyString());
		if (null!=this.getElseAction()){
			method.append("        ").append("if (matched==false) {\n")
			.append("        ").append("    ").append(this.getElseAction().toBodyString())
			.append("        ").append("}\n");
		}
		if(null!=this.getOutputParameter()){
			method.append("        ").append("return ").append(returnVar).append(";\n");
		}		
		method.append(methodEnd);
		classBody.append(classHead.toString())
		.append(constructor.toString())
		.append(method.toString())
		.append(classEnd);
		return classBody.toString();
	}

}
