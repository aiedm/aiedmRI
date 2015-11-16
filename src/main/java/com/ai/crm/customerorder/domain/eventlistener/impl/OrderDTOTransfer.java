package com.ai.crm.customerorder.domain.eventlistener.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.CharacteristicSpec;
import com.ai.common.rootentity.domain.model.CharacteristicSpecValue;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.SpecInstanceEntityCharacterValue;
import com.ai.common.rootentity.domain.model.SpecInstanceEntity;
import com.ai.crm.common.businessinteraction.domain.model.BICharacter;
import com.ai.crm.common.businessinteraction.domain.model.BICharacterValue;
import com.ai.crm.common.businessinteraction.domain.model.BIICharacter;
import com.ai.crm.common.businessinteraction.domain.model.BIICharacterValue;
import com.ai.crm.common.businessinteraction.domain.model.BIIRelatedEntity;
import com.ai.crm.common.businessinteraction.domain.model.BusinessInteraction;
import com.ai.crm.common.businessinteraction.domain.model.BusinessInteractionItem;
import com.ai.crm.customerorder.application.service.api.dto.CharacterInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.CharacterValueInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.CustomerOrderDTO;
import com.ai.crm.customerorder.application.service.api.dto.OfferOrderItemDTO;
import com.ai.crm.customerorder.application.service.api.dto.ProductOrderItemDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBeOfferInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBeOfferInstanceProductDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBePricePlanInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBePricePlanInstanceProductDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBeProductDTO;
import com.ai.crm.customerorder.domain.eventlistener.interfaces.IOrderDTOTransfer;
import com.ai.crm.customerorder.domain.model.CustomerOrder;
import com.ai.crm.customerorder.domain.model.OfferOrderItem;
import com.ai.crm.customerorder.domain.model.ProductOrderItem;
import com.ai.crm.customerorder.domain.model.ToBeOfferInstance;
import com.ai.crm.customerorder.domain.model.ToBePricePlanInstance;
import com.ai.crm.customerorder.domain.model.ToBeProduct;
import com.ai.crm.customerorder.repository.impl.CustomerOrderRepository;
import com.ai.crm.product.domain.model.OfferInstance;
import com.ai.crm.product.domain.model.OfferInstanceCharacter;
import com.ai.crm.product.domain.model.OfferInstanceCharacterValue;
import com.ai.crm.product.domain.model.PricePlanInstance;
import com.ai.crm.product.domain.model.PricePlanInstanceCharacter;
import com.ai.crm.product.domain.model.PricePlanInstanceCharacterValue;
import com.ai.crm.product.domain.model.Product;
import com.ai.crm.product.domain.model.ProductCharacter;
import com.ai.crm.product.domain.model.ProductCharacterValue;
import com.ai.crm.product.domain.repository.interfaces.IProductRepository;
@Component
public class OrderDTOTransfer implements IOrderDTOTransfer{
	@Autowired
	private CustomerOrderRepository customerOrderRepository;
	@Autowired
	private IProductRepository productRepository ;
	@Override
	public CustomerOrder transformNewDTO2Order(CustomerOrderDTO customerOrderDTO) throws Exception{
		CustomerOrder customerOrder=new CustomerOrder(customerOrderDTO.getBusinessInteractionSpecId());
		//TODO setVersion++
		customerOrder.setShoppingCartId(customerOrderDTO.getShoppingCartId());
		customerOrder.setCustomerOrderId(customerOrderDTO.getCustomerOrderId());
		customerOrder.setCustomerOrderCode(customerOrderDTO.getCustomerOrderCode());
		this.addCharacter(customerOrderDTO.getCustomerOrderCharacters(), customerOrder);
		this.transferOfferOrderItem(customerOrderDTO.getOfferOrderItems(),customerOrder);	
		//only product realt,none with offer,priceplan
		this.transferProductOrderItem(customerOrderDTO.getProductOrderItems(), customerOrder);
		return customerOrder;
	}
	
	private void transferOfferOrderItem(Set<OfferOrderItemDTO> offerOrderDTOs,CustomerOrder customerOrder) throws Exception{
		if(offerOrderDTOs.size()>0){
			for (OfferOrderItemDTO offerOrderItemDTO : offerOrderDTOs) {
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
				this.addCharacter(offerOrderItemDTO.getCharacters(), offerOrderItem);
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
				this.addCharacter(toBeOfferInstanceDTO.getOfferInstanceCharacteristics(), toBeOfferInstance);
				Set<ToBeOfferInstanceProductDTO> toBeOfferInstanceProductDTOs=toBeOfferInstanceDTO.getProducts();
				Map<ToBeProductDTO,ToBeProduct> toBeProductMap=new HashMap<>();
				if(toBeOfferInstanceProductDTOs.size()>0){
					for (ToBeOfferInstanceProductDTO toBeOfferInstanceProductDTO : toBeOfferInstanceProductDTOs) {
						ToBeProduct toBeProduct=this.transferToBeProduct(toBeOfferInstanceProductDTO.getToBeProductDTO());
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

				
			}
		}
	}
	
	private void transferProductOrderItem(Set<ProductOrderItemDTO> productOrderDTOs,CustomerOrder customerOrder) throws Exception{
		if(productOrderDTOs.size()>0){
			for (ProductOrderItemDTO productOrderItemDTO : productOrderDTOs) {
				ProductOrderItem productOrderItem=new ProductOrderItem();
				customerOrder.addProductOrder(productOrderItem);
				productOrderItem.setBusinessInteractionItemSpecId(productOrderItemDTO.getBusinessInteractionItemSpecId());
				productOrderItem.setProductOrderId(productOrderItemDTO.getProductOrderItemId());				
				this.addCharacter(productOrderItemDTO.getCharacters(), productOrderItem);
				ToBeProduct toBeProduct=this.transferToBeProduct(productOrderItemDTO.getToBeProductDTO());				
				BIIRelatedEntity relatEntity=new BIIRelatedEntity();
				relatEntity.setToBeInstanceEntity(toBeProduct);
				relatEntity.setAction(productOrderItemDTO.getAction());
				productOrderItem.setRelatedEntity(relatEntity);
				
			}
		}
	}
	
	private ToBeProduct transferToBeProduct(ToBeProductDTO toBeProductDTO) throws Exception{
		ToBeProduct toBeProduct=new ToBeProduct();
		toBeProduct.setCustomerId(toBeProductDTO.getCustomerId());		
		toBeProduct.setProductSpecificationId(toBeProductDTO.getProductSpecId());
		toBeProduct.setSerialNumber(toBeProductDTO.getSerialNo());
		toBeProduct.setValidPeriod(toBeProductDTO.getValidPeriod());
		//toBeProductDTO.getAction()
		long productId=toBeProductDTO.getProductId();
		if(productId>0){
			Product asIsProduct=productRepository.getProductById(productId);
			toBeProduct.setAsIsProduct(asIsProduct);
		}
		this.addCharacter(toBeProductDTO.getProductCharacteristics(), toBeProduct);		
		//TODO add BarReason

		return toBeProduct;
	}
	
	
	private void addCharacter(Set<CharacterInstanceDTO> characterInstances,SpecInstanceEntity instanceEntity) throws Exception{
		if(characterInstances.size()>0){
			for (CharacterInstanceDTO characterInstanceDTO : characterInstances) {
				SpecInstanceEntityCharacter character=null;
				if(instanceEntity instanceof BusinessInteraction){
					character=new BICharacter();
				}else if (instanceEntity instanceof BusinessInteractionItem){
					character=new BIICharacter();
				}else if (instanceEntity instanceof BusinessInteractionItem){
					character=new OfferInstanceCharacter();
				}else if (instanceEntity instanceof BusinessInteractionItem){
					character=new ProductCharacter();
				}else if (instanceEntity instanceof BusinessInteractionItem){
					character=new PricePlanInstanceCharacter();
				}
				character.setId(characterInstanceDTO.getCharacterInstanceId());
				CharacteristicSpec characterSpec=new CharacteristicSpec();
				characterSpec.setId(characterInstanceDTO.getCharacteristicSpecId());
				character.setCharacteristicSpec(characterSpec);
				character.setAction(characterInstanceDTO.getAction());
				character.setOwnerInstance(instanceEntity);
				Set<CharacterValueInstanceDTO> characterValues=characterInstanceDTO.getCharacteristicValues();
				if(characterValues.size()>0){
					for (CharacterValueInstanceDTO characterValueInstanceDTO : characterValues) {						
						SpecInstanceEntityCharacterValue characterValue=null;
						if(instanceEntity instanceof BusinessInteraction){
							characterValue=new BICharacterValue();
						}else if (instanceEntity instanceof BusinessInteractionItem){
							characterValue=new BIICharacterValue();
						}else if (instanceEntity instanceof BusinessInteractionItem){
							characterValue=new OfferInstanceCharacterValue();
						}else if (instanceEntity instanceof BusinessInteractionItem){
							characterValue=new ProductCharacterValue();
						}else if (instanceEntity instanceof BusinessInteractionItem){
							characterValue=new PricePlanInstanceCharacterValue();
						}
						characterValue.setCharacterValueInstanceId(characterValueInstanceDTO.getCharacterValueInstanceId());
						CharacteristicSpecValue characterSpecValue=new CharacteristicSpecValue();
						characterSpecValue.setId(characterValueInstanceDTO.getCharacteristicSpecValueId());
						characterValue.setCharacteristicValue(characterSpecValue);
						characterValue.setInputedValue(characterValueInstanceDTO.getInputedValue());
						characterValue.setAction(characterValueInstanceDTO.getAction());
						character.addCharacteristicInstanceValue(characterValue);
					}
				}
				instanceEntity.addCharacteristic(character);
			}
		}		
	}
	
	

	public CustomerOrder transformUpdateDTO2Order(CustomerOrderDTO customerOrderDTO) throws Exception{
		if(customerOrderDTO.getCustomerId()<=0){
			throw new Exception("Customer Order Id can not be null!");
		}
		CustomerOrder customerOrder = customerOrderRepository.getCustomerOrderByID(customerOrderDTO.getCustomerOrderId());
		
		return customerOrder;
	}
	
	public CustomerOrder transformCancelDTO2Order(CustomerOrderDTO customerOrderDTO) throws Exception{
		if(customerOrderDTO.getCustomerId()<=0){
			throw new Exception("Customer Order Id can not be null!");
		}
		CustomerOrder customerOrder = customerOrderRepository.getCustomerOrderByID(customerOrderDTO.getCustomerOrderId());

		return customerOrder;
	}
}
