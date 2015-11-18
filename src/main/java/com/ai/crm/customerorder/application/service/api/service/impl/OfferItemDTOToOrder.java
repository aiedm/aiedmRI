package com.ai.crm.customerorder.application.service.api.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.crm.common.businessinteraction.domain.model.BIICharacter;
import com.ai.crm.common.businessinteraction.domain.model.BIIRelatedEntity;
import com.ai.crm.customerorder.application.service.api.dto.CharacterInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.OfferOrderItemDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBeOfferInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBeOfferInstanceProductDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBePricePlanInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBePricePlanInstanceProductDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBeProductDTO;
import com.ai.crm.customerorder.application.service.api.service.interfaces.IOfferItemDTOToOrder;
import com.ai.crm.customerorder.application.service.api.service.interfaces.IProductItemDTOToOrder;
import com.ai.crm.customerorder.application.service.api.util.CharacteristicDTOTransHelper;
import com.ai.crm.customerorder.domain.model.CustomerOrder;
import com.ai.crm.customerorder.domain.model.OfferOrderItem;
import com.ai.crm.customerorder.domain.model.ToBeOfferInstance;
import com.ai.crm.customerorder.domain.model.ToBePricePlanInstance;
import com.ai.crm.customerorder.domain.model.ToBeProduct;
import com.ai.crm.product.domain.model.OfferInstance;
import com.ai.crm.product.domain.model.OfferInstanceCharacter;
import com.ai.crm.product.domain.model.PricePlanInstance;
import com.ai.crm.product.domain.model.PricePlanInstanceCharacter;
import com.ai.crm.product.domain.repository.interfaces.IProductRepository;
@Component
public class OfferItemDTOToOrder implements IOfferItemDTOToOrder{
	@Autowired
	private IProductRepository productRepository;
	@Autowired
	private IProductItemDTOToOrder productItemDTOToOrder;

	public OfferItemDTOToOrder() {
	}

	@Override
	public OfferOrderItem transDTOToOrder(OfferOrderItemDTO offerOrderItemDTO,CustomerOrder customerOrder) throws Exception{
		OfferOrderItem offerOrderItem=new OfferOrderItem(customerOrder);
		offerOrderItem.setBusinessInteractionItemSpecId(offerOrderItemDTO.getBusinessInteractionItemSpecId());
		offerOrderItem.setOfferOrderId(offerOrderItemDTO.getOfferOrderItemId());
		long replacedOffeRInstanceId=offerOrderItemDTO.getReplacedOfferInstanceId();
		if (replacedOffeRInstanceId>0){
			OfferOrderItem replacedOfferOrderItem=new OfferOrderItem(customerOrder);
			ToBeOfferInstance repalcedToBeOfferInstance=(ToBeOfferInstance)productRepository.getOfferInstanceById(replacedOffeRInstanceId);
			BIIRelatedEntity relatEntity=new BIIRelatedEntity();
			relatEntity.setToBeInstanceEntity(repalcedToBeOfferInstance);
			relatEntity.setAction(2);
			replacedOfferOrderItem.setRelatedEntity(relatEntity);
			offerOrderItem.setReplcedOfferOrderItem(replacedOfferOrderItem);
		}
		this.addOfferItemCharacter(offerOrderItemDTO, offerOrderItem);
		ToBeOfferInstanceDTO toBeOfferInstanceDTO = offerOrderItemDTO.getToBeOfferInstanceTDO();
		ToBeOfferInstance toBeOfferInstance=new ToBeOfferInstance();
		toBeOfferInstance.setCustomerId(toBeOfferInstanceDTO.getCustomerId());
		BIIRelatedEntity relatEntity=new BIIRelatedEntity();
		relatEntity.setToBeInstanceEntity(toBeOfferInstance);
		relatEntity.setAction(offerOrderItemDTO.getAction());
		offerOrderItem.setRelatedEntity(relatEntity);
		toBeOfferInstance.setProductOfferingId(toBeOfferInstanceDTO.getProductOffferingId());
		long offerInstanceId=toBeOfferInstanceDTO.getOfferInstanceId();
		if(offerInstanceId>0){
			OfferInstance asIsOfferInstance=productRepository.getOfferInstanceById(offerInstanceId);
			toBeOfferInstance.setAsIsOfferInstance(asIsOfferInstance);
		}
		this.addToBeOfferInstanceCharacter(toBeOfferInstanceDTO, toBeOfferInstance);
		Set<ToBeOfferInstanceProductDTO> toBeOfferInstanceProductDTOs=toBeOfferInstanceDTO.getProducts();
		Map<ToBeProductDTO,ToBeProduct> toBeProductMap=new HashMap<>();
		if(toBeOfferInstanceProductDTOs.size()>0){
			for (ToBeOfferInstanceProductDTO toBeOfferInstanceProductDTO : toBeOfferInstanceProductDTOs) {
				ToBeProduct toBeProduct=productItemDTOToOrder.transferToBeProduct(toBeOfferInstanceProductDTO.getToBeProductDTO());
				toBeOfferInstance.addProduct(toBeProduct, toBeOfferInstanceProductDTO.getValidPeriod());
				toBeProductMap.put(toBeOfferInstanceProductDTO.getToBeProductDTO(), toBeProduct);
			}
		}
		Set<ToBePricePlanInstanceDTO> toBePricePlanInstanceDTOs = toBeOfferInstanceDTO.getPricePlanInstances();
		if(toBePricePlanInstanceDTOs.size()>0){
			for (ToBePricePlanInstanceDTO toBePricePlanInstanceDTO : toBePricePlanInstanceDTOs) {
				ToBePricePlanInstance toBePricePlanInstance=new ToBePricePlanInstance();
				toBePricePlanInstance.setPricePlanId(toBePricePlanInstanceDTO.getPricePlanId());
				toBePricePlanInstance.setOfferInstance(toBeOfferInstance);
				long asIsPricePlanInstanceId=toBePricePlanInstanceDTO.getPricePlanInstanceId();
				if(asIsPricePlanInstanceId>0){
					PricePlanInstance asIsPricePlanInstance=productRepository.getPricePlanInstanceById(asIsPricePlanInstanceId);
					toBePricePlanInstance.setAsIsPricePlanInstance(asIsPricePlanInstance);
				}
				toBePricePlanInstance.setPriceValue(toBePricePlanInstanceDTO.getInputedValue());
				toBePricePlanInstance.setDiscountReason(toBePricePlanInstanceDTO.getDiscountReason());
				toBePricePlanInstance.setRoleId(toBePricePlanInstanceDTO.getRoleId());
				this.addToBePricePlanInstanceCharacter(toBePricePlanInstanceDTO, toBePricePlanInstance);
				Set<ToBePricePlanInstanceProductDTO> priceplanProducts=toBePricePlanInstanceDTO.getAppliedToProducts();
				if(priceplanProducts.size()>0){
					for (ToBePricePlanInstanceProductDTO toBePricePlanInstanceProductDTO : priceplanProducts) {
						ToBeProduct toBeProduct=(ToBeProduct)toBeProductMap.get(toBePricePlanInstanceProductDTO.getToBeProductDTO());
						toBePricePlanInstance.assignTo(toBeProduct, toBePricePlanInstanceProductDTO.getValidPeriod());
					}
				}
				toBeOfferInstance.addPricePlanInstance(toBePricePlanInstance);
			}
		}
		return offerOrderItem;
	}

	private void addOfferItemCharacter(OfferOrderItemDTO offerOrderItemDTO,OfferOrderItem offerOrderItem) throws Exception{
		 Set<CharacterInstanceDTO>  characterInstanceDTOs = offerOrderItemDTO.getCharacters();
		 if(characterInstanceDTOs.size()>0){
			for (CharacterInstanceDTO characterInstanceDTO : characterInstanceDTOs) {
				BIICharacter character=new BIICharacter();
				CharacteristicDTOTransHelper.transCharacteristic(character,characterInstanceDTO);
				offerOrderItem.addBiiCharacteristic(character);
			}				
		 }
	}
	
	private void addToBeOfferInstanceCharacter(ToBeOfferInstanceDTO toBeOfferInstanceDTO,ToBeOfferInstance toBeOfferInstance) throws Exception{
		 Set<CharacterInstanceDTO>  characterInstanceDTOs = toBeOfferInstanceDTO.getOfferInstanceCharacteristics();
		 if(characterInstanceDTOs.size()>0){
			for (CharacterInstanceDTO characterInstanceDTO : characterInstanceDTOs) {
				OfferInstanceCharacter character=new OfferInstanceCharacter();
				CharacteristicDTOTransHelper.transCharacteristic(character,characterInstanceDTO);
				toBeOfferInstance.addOfferInstanceCharacter(character);
			}				
		 }
	}
	
	private void addToBePricePlanInstanceCharacter(ToBePricePlanInstanceDTO toBePricePlanInstanceDTO,ToBePricePlanInstance toBePricePlanInstance) throws Exception{
		 Set<CharacterInstanceDTO>  characterInstanceDTOs = toBePricePlanInstanceDTO.getPricePlanInstanceCharacteristics();
		 if(characterInstanceDTOs.size()>0){
			for (CharacterInstanceDTO characterInstanceDTO : characterInstanceDTOs) {
				PricePlanInstanceCharacter character=new PricePlanInstanceCharacter();
				CharacteristicDTOTransHelper.transCharacteristic(character,characterInstanceDTO);
				toBePricePlanInstance.addPricePlanInstanceCharacter(character);
			}				
		 }
	}
}
