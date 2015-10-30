package com.ai.common.rootentity.domain.model.impl;

import java.util.LinkedHashSet;
import java.util.Set;

public class CheckResult {
	private Set<String> errorInfomations=new LinkedHashSet<String>();
	private Set<String> informInfomations=new LinkedHashSet<String>();
	
	public Set<String> getErrorInfomations() {
		return errorInfomations;
	}
	public void addErrorInfomation(String errorInfomation) {
		if(!errorInfomation.isEmpty()){
			errorInfomations.add(errorInfomation);
		}
	}
	public Set<String> getInformInfomations() {
		return informInfomations;
	}
	public void addInformInfomation(String informInfomation) {
		if(!informInfomation.isEmpty()){
			informInfomations.add(informInfomation);
		}
	}
	
	public CheckResult() {
	}
	
	public boolean isError(){
		return errorInfomations.size()>0;
	}
	
	public boolean isInformed(){
		return informInfomations.size()>0;
	}

}
