package com.ai.crm.customerorder.application.service.api.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
@JsonSubTypes({
			@Type(value = OfferOrderItemDTO.class, name = "OfferOrderItemDTO")
})
public class OfferOrderItemDTO {
	private long offerOrderItemId;
	private long replacedOfferInstanceId;
	private ToBeOfferInstanceDTO toBeOfferInstanceDTO;
	private long businessInteractionItemSpecId;
	private int action=1;
	private Set<CharacterInstanceDTO>  characters=new LinkedHashSet<CharacterInstanceDTO>();
	
	public Set<CharacterInstanceDTO>  getCharacters(){
		return this.characters;
	}
	
	public void addCharacter(CharacterInstanceDTO characteristicInstanceDTO){
		if (null!=characteristicInstanceDTO){
			characters.add(characteristicInstanceDTO);
		}
	}
	
	public int getAction() {
		return action;
	}


	public void setAction(int action) {
		this.action = action;
	}	
	public OfferOrderItemDTO() {
		
	}
	public long getOfferOrderItemId() {
		return offerOrderItemId;
	}
	public void setOfferOrdeItemrId(long offerOrderItemId) {
		this.offerOrderItemId = offerOrderItemId;
	}
	public ToBeOfferInstanceDTO getToBeOfferInstanceTDO() {
		return toBeOfferInstanceDTO;
	}
	public void setToBeOfferInstanceTDO(ToBeOfferInstanceDTO toBeOfferInstanceTDO) {
		this.toBeOfferInstanceDTO = toBeOfferInstanceTDO;
	}
	public long getBusinessInteractionItemSpecId() {
		return businessInteractionItemSpecId;
	}
	public void setBusinessInteractionItemSpecId(long businessInteractionItemSpecId) {
		this.businessInteractionItemSpecId = businessInteractionItemSpecId;
	}
	public long getReplacedOfferInstanceId() {
		return replacedOfferInstanceId;
	}
	public void setReplacedOfferInstanceId(long replacedOfferInstanceId) {
		this.replacedOfferInstanceId = replacedOfferInstanceId;
	}

}
