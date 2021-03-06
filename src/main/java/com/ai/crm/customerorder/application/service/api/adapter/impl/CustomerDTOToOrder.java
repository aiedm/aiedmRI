package com.ai.crm.customerorder.application.service.api.adapter.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.crm.common.businessinteraction.domain.model.BICharacter;
import com.ai.crm.customerorder.application.service.api.adapter.interfaces.ICustomerDTOToOrder;
import com.ai.crm.customerorder.application.service.api.adapter.interfaces.IOfferItemDTOToOrder;
import com.ai.crm.customerorder.application.service.api.adapter.interfaces.IProductItemDTOToOrder;
import com.ai.crm.customerorder.application.service.api.dto.CharacterInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.CustomerOrderDTO;
import com.ai.crm.customerorder.application.service.api.dto.OfferOrderItemDTO;
import com.ai.crm.customerorder.application.service.api.dto.ProductOrderItemDTO;
import com.ai.crm.customerorder.application.service.api.util.CharacteristicDTOTransHelper;
import com.ai.crm.customerorder.domain.model.CustomerOrder;
import com.ai.crm.customerorder.domain.model.ShoppingCart;
import com.ai.crm.customerorder.repository.interfaces.IShoppingCartRepository;
@Component
public class CustomerDTOToOrder implements ICustomerDTOToOrder{
	@Autowired
	private IOfferItemDTOToOrder offerItemDTOToOrder;
	@Autowired
	private IProductItemDTOToOrder productItemDTOToOrder;
	@Autowired
	private IShoppingCartRepository shoppingCartRepository;
	
	public CustomerDTOToOrder() {
	}
	
	public CustomerOrder transDTOToOrder(CustomerOrderDTO customerOrderDTO,CustomerOrder customerOrder) throws Exception{		
		//TODO setVersion++
		if(customerOrderDTO.getShoppingCartId()>0){
			ShoppingCart shoppingCart= shoppingCartRepository.getShoppingCartByID(customerOrderDTO.getShoppingCartId());
			if(null!=shoppingCart){
				customerOrder.setShoppingCart(shoppingCart);
			}
		}
		
		addCharacter(customerOrderDTO,customerOrder);
		Set<OfferOrderItemDTO> offerOrderItemDTOs=customerOrderDTO.getOfferOrderItems();
		if(offerOrderItemDTOs.size()>0){
			for (OfferOrderItemDTO offerOrderItemDTO : offerOrderItemDTOs) {				
				offerItemDTOToOrder.transDTOToOrder(offerOrderItemDTO,customerOrder);
			}
		}
		Set<ProductOrderItemDTO> productOrderItemDTOs=customerOrderDTO.getProductOrderItems();
		if(productOrderItemDTOs.size()>0){
			for (ProductOrderItemDTO productOrderItemDTO : productOrderItemDTOs) {				
				productItemDTOToOrder.transDTOToOrder(productOrderItemDTO,customerOrder);
			}
		}
		
		return customerOrder;
	}
	
	private void addCharacter(CustomerOrderDTO customerOrderDTO,CustomerOrder customerOrder)  throws Exception{
		 Set<CharacterInstanceDTO>  characterInstanceDTOs = customerOrderDTO.getCustomerOrderCharacters();
		 if(characterInstanceDTOs.size()>0){
			for (CharacterInstanceDTO characterInstanceDTO : characterInstanceDTOs) {
				BICharacter character=new BICharacter();
				CharacteristicDTOTransHelper.transCharacteristic(character,characterInstanceDTO);
				customerOrder.addBICharacteristic(character);
			}				
		 }
	}
	
}
