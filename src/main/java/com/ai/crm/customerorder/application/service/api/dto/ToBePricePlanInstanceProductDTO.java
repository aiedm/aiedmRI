package com.ai.crm.customerorder.application.service.api.dto;

import com.ai.common.basetype.TimePeriod;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
@JsonSubTypes({
			@Type(value = ToBePricePlanInstanceProductDTO.class, name = "ToBePricePlanInstanceProductDTO")
})
public class ToBePricePlanInstanceProductDTO {
	@JsonIgnore
	private ToBePricePlanInstanceDTO toBePricePlanInstanceDTO;
	private ToBeProductDTO toBeProductDTO;
	private TimePeriod validPeriod;
	public ToBePricePlanInstanceProductDTO() {
	}
	public ToBePricePlanInstanceDTO getToBePricePlanInstanceDTO() {
		return toBePricePlanInstanceDTO;
	}
	public void setToBePricePlanInstanceDTO(ToBePricePlanInstanceDTO toBePricePlanInstanceDTO) {
		this.toBePricePlanInstanceDTO = toBePricePlanInstanceDTO;
	}
	public ToBeProductDTO getToBeProductDTO() {
		return toBeProductDTO;
	}
	public void setToBeProductDTO(ToBeProductDTO toBeProductDTO) {
		this.toBeProductDTO = toBeProductDTO;
	}
	public TimePeriod getValidPeriod() {
		return validPeriod;
	}
	public void setValidPeriod(TimePeriod validPeriod) {
		this.validPeriod = validPeriod;
	}

}
