package com.ai.crm.customerorder.application.service.api.dto;

import com.ai.common.basetype.TimePeriod;

public class ToBeOfferInstanceProductDTO {
	private ToBeOfferInstanceDTO toBeOfferInstanceDTO;
	private ToBeProductDTO toBeProductDTO;
	private TimePeriod validPeriod;

	public ToBeOfferInstanceProductDTO() {
		
	}

	public ToBeOfferInstanceDTO getToBeOfferInstanceDTO() {
		return toBeOfferInstanceDTO;
	}

	public void setToBeOfferInstanceDTO(ToBeOfferInstanceDTO toBeOfferInstanceDTO) {
		this.toBeOfferInstanceDTO = toBeOfferInstanceDTO;
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
