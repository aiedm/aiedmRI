package com.ai.crm.customerorder.application.service.api.dto;

import com.ai.common.basetype.TimePeriod;

public class ToBePricePlanInstanceProductDTO {
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
