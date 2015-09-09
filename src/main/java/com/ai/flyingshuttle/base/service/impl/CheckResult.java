package com.ai.flyingshuttle.base.service.impl;

public class CheckResult {
	private String errorInfomation="";
	public String getErrorInfomation() {
		return errorInfomation;
	}
	public void setErrorInfomation(String errorInfomation) {
		this.errorInfomation = errorInfomation;
	}
	public String getInformInfomation() {
		return informInfomation;
	}
	public void setInformInfomation(String informInfomation) {
		this.informInfomation = informInfomation;
	}
	private String informInfomation="";
	public CheckResult() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isError(){
		return !errorInfomation.isEmpty();
	}
	
	public boolean isInformed(){
		return !informInfomation.isEmpty();
	}

}
