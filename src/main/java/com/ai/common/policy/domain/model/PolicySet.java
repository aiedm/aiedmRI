package com.ai.common.policy.domain.model;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.ai.common.rootentity.domain.model.InstanceEntity;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class PolicySet extends InstanceEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	private String name;
	private String code;
	@OneToOne
	private PolicySetOutputParameter outputParam;	
	@OneToOne
	private PolicyAction elseAction;
	boolean isEnableElseAction=true;
	
	@ManyToOne
	private PolicySet parentPolicySet;
	
	public PolicySet() {
	}

	
	public String getName() {
		return this.name;
	}

	
	public void setName(String name) {
		this.name=name;
	}

	
	public String getCode() {
		return this.code;
	}

	
	public void setCode(String code) {
		this.code=code;
	}

	
	
	abstract public Set<PolicyRuleInputParameter> getInputParameters();

	
	public PolicySetOutputParameter getOutputParameter() {
		return this.outputParam;
	}

	
	public void setOutputParameter(PolicySetOutputParameter param) {
		this.outputParam=param;
	}	
	
	
	public PolicyAction getElseAction() {
		return this.elseAction;
	}	

	
	public void setElseAction(PolicyAction elseAction) {
		this.elseAction=elseAction;		
	}
	
	
	public void disableElseAction(){
		this.isEnableElseAction=false;
	}
	
	
	public abstract String toBodyString();
	
	
	public String getVariableDeclareString() {
		StringBuffer sb=new StringBuffer();
		Map<String , PolicyVariable> map=this.getVariableMap();
		for(Entry<String, PolicyVariable> entry : map.entrySet()){
			String code = entry.getKey();
			PolicyVariable variable = entry.getValue();
			sb.append("        ").append(variable.getVariableType()).append(" ").append(code);
			if(null!=variable.getInitialValue()){
				sb.append(" = ").append(variable.getInitialValue().toBodyString());
			}else if (null!=variable.getInitialInputValue()){
				sb.append(" = ").append(variable.getInitialInputValue());
			}
			sb.append(";\n");
		}
		return sb.toString();
	}
	
	
	public abstract Map<String,PolicyVariable> getVariableMap();
	
	
	public String toPolicyString() {
		String returnVar="";
		String returnVarType="";
		if(null!=this.getOutputParameter()){
			returnVar=this.getOutputParameter().getVariable().getCode();
			returnVarType=(String)this.getOutputParameter().getVariable().getVariableType();
		}
		StringBuffer classBody=new StringBuffer();
		String className="aPolicy"+this.getCode();
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
		for (PolicyRuleInputParameter param : this.getInputParameters()) {
			methodDeclare.append("        ")
			.append(param.getVariable().getVariableType()).append(" ")
			.append(param.getVariable().getCode())			
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
		.append(methodDeclare.toString())
		.append(this.getVariableDeclareString())
		.append(this.toBodyString());
		if (null!=this.getElseAction()&&this.isEnableElseAction){
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


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public PolicySet getParentPolicySet() {
		return parentPolicySet;
	}


	public void setParentPolicySet(PolicySet parentPolicySet) {
		this.parentPolicySet = parentPolicySet;
	}

}
