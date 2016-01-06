package com.ai.crm.customerorder.application.service.api.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
@JsonSubTypes({
			@Type(value = NewSubscriberDTO.class, name = "NewSubscriberDTO")
})
public class NewSubscriberDTO {
	private long productLineId;
	private String accessNumber;
	
	public NewSubscriberDTO() {
	}

	public String getAccessNumber() {
		return accessNumber;
	}
	

	public void setAccessNumber(String accessNumber) {
		this.accessNumber = accessNumber;
	}

	public long getProductLineId() {
		return productLineId;
	}
	

	public void setProductLineId(long productLineId) {
		this.productLineId = productLineId;
	}
	
	

}
