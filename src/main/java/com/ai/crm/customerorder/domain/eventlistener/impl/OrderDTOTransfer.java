package com.ai.crm.customerorder.domain.eventlistener.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.common.rootentity.domain.model.impl.InstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.impl.InstanceEntityCharacterValue;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacter;
import com.ai.common.rootentity.domain.model.interfaces.IInstanceEntityCharacterValue;
import com.ai.common.rootentity.domain.model.interfaces.ISpecificationInstanceEntity;
import com.ai.crm.common.businessinteraction.domain.model.impl.BIIRelatedEntity;
import com.ai.crm.common.businessinteraction.domain.model.interfaces.IBIIRelatedEntity;
import com.ai.crm.customerorder.application.service.api.dto.CharacterInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.CharacterValueInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.CustomerOrderDTO;
import com.ai.crm.customerorder.application.service.api.dto.OfferOrderItemDTO;
import com.ai.crm.customerorder.application.service.api.dto.ProductOrderItemDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBeOfferInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBePricePlanInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBeProductDTO;
import com.ai.crm.customerorder.domain.eventlistener.interfaces.IOrderDTOTransfer;
import com.ai.crm.customerorder.domain.model.impl.CustomerOrder;
import com.ai.crm.customerorder.domain.model.impl.OfferOrderItem;
import com.ai.crm.customerorder.domain.model.impl.ProductOrderItem;
import com.ai.crm.customerorder.domain.model.impl.ToBeOfferInstance;
import com.ai.crm.customerorder.domain.model.impl.ToBePricePlanInstance;
import com.ai.crm.customerorder.domain.model.impl.ToBeProduct;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.IOfferOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IProductOrderItem;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeOfferInstance;
import com.ai.crm.customerorder.domain.model.interfaces.IToBePricePlanInstance;
import com.ai.crm.customerorder.domain.model.interfaces.IToBeProduct;
import com.ai.crm.customerorder.repository.interfaces.ICustomerOrderRepository;
import com.ai.crm.product.domain.model.impl.ProductPriceRel;
import com.ai.crm.product.domain.model.interfaces.IOfferInstance;
import com.ai.crm.product.domain.model.interfaces.IPricePlanInstance;
import com.ai.crm.product.domain.model.interfaces.IProduct;
import com.ai.crm.product.domain.model.interfaces.IProductPriceRel;
import com.ai.crm.product.domain.repository.interfaces.IProductRepository;
@Component
public class OrderDTOTransfer implements IOrderDTOTransfer{
	@Autowired
	private ICustomerOrderRepository customerOrderRepository;
	@Autowired
	private IProductRepository productRepository ;
	@Override
	public ICustomerOrder transformNewDTO2Order(CustomerOrderDTO customerOrderDTO) throws Exception{
		ICustomerOrder customerOrder=new CustomerOrder();
		//TODO setVersion++
		customerOrder.setShoppingCartId(customerOrderDTO.getShoppingCartId());
		customerOrder.setBusinessInteractionSpecId(customerOrderDTO.getBusinessInteractionSpecId());
		customerOrder.setCustomerOrderId(customerOrderDTO.getCustomerOrderId());
		customerOrder.setCustomerOrderCode(customerOrderDTO.getCustomerOrderCode());
		this.addCharacter(customerOrderDTO.getCustomerOrderCharacters(), customerOrder);
		this.transferOfferOrderItem(customerOrderDTO.getOfferOrderItems(),customerOrder);	
		//only product realt,none with offer,priceplan
		this.transferProductOrderItem(customerOrderDTO.getProductOrderItems(), customerOrder);
		return customerOrder;
	}
	
	private void transferOfferOrderItem(Set<OfferOrderItemDTO> offerOrderDTOs,ICustomerOrder customerOrder) throws Exception{
		if(offerOrderDTOs.size()>0){
			for (OfferOrderItemDTO offerOrderItemDTO : offerOrderDTOs) {
				IOfferOrderItem offerOrderItem=new OfferOrderItem(customerOrder);
				offerOrderItem.setBusinessInteractionItemSpecId(offerOrderItemDTO.getBusinessInteractionItemSpecId());
				offerOrderItem.setOfferOrderId(offerOrderItemDTO.getOfferOrderItemId());
				long replacedOffeRInstanceId=offerOrderItemDTO.getReplacedOfferInstanceId();
				if (replacedOffeRInstanceId>0){
					IOfferOrderItem replacedOfferOrderItem=new OfferOrderItem(customerOrder);
					IToBeOfferInstance repalcedToBeOfferInstance=(IToBeOfferInstance)productRepository.getOfferInstanceById(replacedOffeRInstanceId);
					IBIIRelatedEntity relatEntity=new BIIRelatedEntity();
					relatEntity.setToBeInstanceEntity(repalcedToBeOfferInstance);
					relatEntity.setAction(2);
					replacedOfferOrderItem.setRelatedEntity(relatEntity);
					offerOrderItem.setReplcedOfferOrderItem(replacedOfferOrderItem);
				}
				this.addCharacter(offerOrderItemDTO.getCharacters(), offerOrderItem);
				ToBeOfferInstanceDTO toBeOfferInstanceDTO = offerOrderItemDTO.getToBeOfferInstanceTDO();
				IToBeOfferInstance toBeOfferInstance=new ToBeOfferInstance();
				toBeOfferInstance.setCustomerId(toBeOfferInstanceDTO.getCustomerId());
				IBIIRelatedEntity relatEntity=new BIIRelatedEntity();
				relatEntity.setToBeInstanceEntity(toBeOfferInstance);
				relatEntity.setAction(offerOrderItemDTO.getAction());
				offerOrderItem.setRelatedEntity(relatEntity);
				toBeOfferInstance.setProductOfferingId(toBeOfferInstanceDTO.getProductOffferingId());
				long offerInstanceId=toBeOfferInstanceDTO.getOfferInstanceId();
				if(offerInstanceId>0){
					IOfferInstance asIsOfferInstance=productRepository.getOfferInstanceById(offerInstanceId);
					toBeOfferInstance.setAsIsOfferInstance(asIsOfferInstance);
				}
				this.addCharacter(toBeOfferInstanceDTO.getOfferInstanceCharacteristics(), toBeOfferInstance);
				Set<ToBePricePlanInstanceDTO> toBePricePlanInstanceDTOs = toBeOfferInstanceDTO.getPricePlanInstances();
				Map<Integer, IToBePricePlanInstance> pricePlanSeqMap=new HashMap<Integer, IToBePricePlanInstance>();
				if(toBePricePlanInstanceDTOs.size()>0){
					for (ToBePricePlanInstanceDTO toBePricePlanInstanceDTO : toBePricePlanInstanceDTOs) {
						IToBePricePlanInstance toBePricePlanInstance=new ToBePricePlanInstance();
						toBePricePlanInstance.setPricePlanId(toBePricePlanInstanceDTO.getPricePlanId());
						toBePricePlanInstance.setOfferInstance(toBeOfferInstance);
						long asIsPricePlanInstanceId=toBePricePlanInstanceDTO.getPricePlanInstanceId();
						if(asIsPricePlanInstanceId>0){
							IPricePlanInstance asIsPricePlanInstance=productRepository.getPricePlanInstanceById(asIsPricePlanInstanceId);
							toBePricePlanInstance.setAsIsPricePlanInstance(asIsPricePlanInstance);
						}
						toBePricePlanInstance.setPriceValue(toBePricePlanInstanceDTO.getInputedValue());
						toBePricePlanInstance.setDiscountReason(toBePricePlanInstanceDTO.getDiscountReason());
						toBePricePlanInstance.setRoleId(toBePricePlanInstanceDTO.getRoleId());
						pricePlanSeqMap.put(new Integer(toBePricePlanInstanceDTO.getTempSeqId()), toBePricePlanInstance);
						toBeOfferInstance.addPricePlanInstance(toBePricePlanInstance);
					}
				}
				Set<ToBeProductDTO> toBeProductDTOs=toBeOfferInstanceDTO.getProducts();
				if(toBeProductDTOs.size()>0){
					for (ToBeProductDTO toBeProductDTO : toBeProductDTOs) {
						this.transferToBeProduct(toBeProductDTO,toBeOfferInstance,pricePlanSeqMap);
					}
				}
				
			}
		}
	}
	
	private void transferProductOrderItem(Set<ProductOrderItemDTO> productOrderDTOs,ICustomerOrder customerOrder) throws Exception{
		if(productOrderDTOs.size()>0){
			for (ProductOrderItemDTO productOrderItemDTO : productOrderDTOs) {
				IProductOrderItem productOrderItem=new ProductOrderItem();
				customerOrder.addProductOrder(productOrderItem);
				productOrderItem.setBusinessInteractionItemSpecId(productOrderItemDTO.getBusinessInteractionItemSpecId());
				productOrderItem.setProductOrderId(productOrderItemDTO.getProductOrderItemId());				
				this.addCharacter(productOrderItemDTO.getCharacters(), productOrderItem);
				IToBeProduct toBeProduct=this.transferToBeProduct(productOrderItemDTO.getToBeProductDTO(),null,null);				
				IBIIRelatedEntity relatEntity=new BIIRelatedEntity();
				relatEntity.setToBeInstanceEntity(toBeProduct);
				relatEntity.setAction(productOrderItemDTO.getAction());
				productOrderItem.setRelatedEntity(relatEntity);
				
			}
		}
	}
	
	private IToBeProduct transferToBeProduct(ToBeProductDTO toBeProductDTO,IToBeOfferInstance toBeOfferInstance,Map<Integer, IToBePricePlanInstance> pricePlanSeqMap) throws Exception{
		IToBeProduct toBeProduct=new ToBeProduct();
		toBeProduct.setCustomerId(toBeProductDTO.getCustomerId());		
		toBeProduct.setProductSpecificationId(toBeProductDTO.getProductSpecId());
		toBeProduct.setSerialNumber(toBeProductDTO.getSerialNo());
		long productId=toBeProductDTO.getProductId();
		if(productId>0){
			IProduct asIsProduct=productRepository.getProductById(productId);
			toBeProduct.setAsIsProduct(asIsProduct);
		}
		this.addCharacter(toBeProductDTO.getProductCharacteristics(), toBeProduct);
		//TODO add BarReason
		if(null!=toBeOfferInstance){
			toBeProduct.addToOfferInstance(toBeOfferInstance);
			Set<Long> assignedPriceSeqs=toBeProductDTO.getAssignedPriceTempSeqs();
			if(assignedPriceSeqs.size()>0){
				for (Long seq : assignedPriceSeqs) {
					IToBePricePlanInstance toBePricePlanInstance = pricePlanSeqMap.get(seq);
					IProductPriceRel productPriceRel=new ProductPriceRel();
					productPriceRel.setPricePlanInstance(toBePricePlanInstance);
					productPriceRel.setProduct(toBeProduct);
					toBeProduct.assignPrice(productPriceRel);
				}
			}
		}
		return toBeProduct;
	}
	
	
	private void addCharacter(Set<CharacterInstanceDTO> characterInstances,ISpecificationInstanceEntity instanceEntity) throws Exception{
		if(characterInstances.size()>0){
			for (CharacterInstanceDTO characterInstanceDTO : characterInstances) {
				IInstanceEntityCharacter character=new InstanceEntityCharacter();
				character.setCharacterInstanceId(characterInstanceDTO.getCharacterInstanceId());
				character.setCharacteristicSpecId(characterInstanceDTO.getCharacteristicSpecId());
				character.setAction(characterInstanceDTO.getAction());
				character.setOwnerInstance(instanceEntity);
				Set<CharacterValueInstanceDTO> characterValues=characterInstanceDTO.getCharacteristicValues();
				if(characterValues.size()>0){
					for (CharacterValueInstanceDTO characterValueInstanceDTO : characterValues) {
						IInstanceEntityCharacterValue characterValue=new InstanceEntityCharacterValue();
						characterValue.setCharacterValueInstanceId(characterValueInstanceDTO.getCharacterValueInstanceId());
						characterValue.setCharacteristicValueId(characterValueInstanceDTO.getCharacteristicSpecValueId());
						characterValue.setInputedValue(characterValueInstanceDTO.getInputedValue());
						characterValue.setAction(characterValueInstanceDTO.getAction());
						character.addCharacteristicInstanceValue(characterValue);
					}
				}
				instanceEntity.addCharacteristic(character);
			}
		}		
	}
	
	

	public ICustomerOrder transformUpdateDTO2Order(CustomerOrderDTO customerOrderDTO) throws Exception{
		if(customerOrderDTO.getCustomerId()<=0){
			throw new Exception("Customer Order Id can not be null!");
		}
		ICustomerOrder customerOrder = customerOrderRepository.getCustomerOrderByID(customerOrderDTO.getCustomerOrderId());
		
		return customerOrder;
	}
	
	public ICustomerOrder transformCancelDTO2Order(CustomerOrderDTO customerOrderDTO) throws Exception{
		if(customerOrderDTO.getCustomerId()<=0){
			throw new Exception("Customer Order Id can not be null!");
		}
		ICustomerOrder customerOrder = customerOrderRepository.getCustomerOrderByID(customerOrderDTO.getCustomerOrderId());

		return customerOrder;
	}
}
