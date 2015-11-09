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
			@Type(value = ProductOrderItemDTO.class, name = "ProductOrderItemDTO")
})
public class ProductOrderItemDTO {
	private long productOrderItemId;
	private long tempSeqId;
	private ToBeProductDTO toBeProductDTO;
	private long businessInteractionItemSpecId;
	private int action=1;//0 means does not change 
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
	public ProductOrderItemDTO() {
		
	}
	public long getProductOrderItemId() {
		return productOrderItemId;
	}
	public void setProductOrderItemId(long productOrderItemId) {
		this.productOrderItemId = productOrderItemId;
	}
	public long getTempSeqId() {
		return tempSeqId;
	}
	public void setTempSeqId(long tempSeqId) {
		this.tempSeqId = tempSeqId;
	}
	public ToBeProductDTO getToBeProductDTO() {
		return toBeProductDTO;
	}
	public void setToBeProductDTO(ToBeProductDTO toBeProductDTO) {
		this.toBeProductDTO = toBeProductDTO;
	}
	public long getBusinessInteractionItemSpecId() {
		return businessInteractionItemSpecId;
	}
	public void setBusinessInteractionItemSpecId(long businessInteractionItemSpecId) {
		this.businessInteractionItemSpecId = businessInteractionItemSpecId;
	}

}
