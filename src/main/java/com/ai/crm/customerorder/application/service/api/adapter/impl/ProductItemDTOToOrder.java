package com.ai.crm.customerorder.application.service.api.adapter.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.crm.common.businessinteraction.domain.model.BIICharacter;
import com.ai.crm.customerorder.application.service.api.adapter.interfaces.IProductItemDTOToOrder;
import com.ai.crm.customerorder.application.service.api.dto.CharacterInstanceDTO;
import com.ai.crm.customerorder.application.service.api.dto.ProductOrderItemDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBeProductDTO;
import com.ai.crm.customerorder.application.service.api.util.CharacteristicDTOTransHelper;
import com.ai.crm.customerorder.domain.model.CustomerOrder;
import com.ai.crm.customerorder.domain.model.ProductOrderItem;
import com.ai.crm.customerorder.domain.model.ToBeAccessProduct;
import com.ai.crm.customerorder.domain.model.ToBeAuxiliaryProduct;
import com.ai.crm.customerorder.domain.model.ToBeProduct;
import com.ai.crm.customerorder.domain.model.ToBeProductCharacter;
import com.ai.crm.customerorder.domain.model.ToBeSubscriber;
import com.ai.crm.product.domain.model.AsIsProduct;
import com.ai.crm.product.domain.repository.interfaces.IProductRepository;
import com.ai.upc.productspecification.domian.model.AccessProductSpecification;
import com.ai.upc.productspecification.domian.model.AuxiliaryProductSpecification;
import com.ai.upc.productspecification.domian.model.ProductSpecification;
import com.ai.upc.productspecification.domian.repository.interfaces.IProductSpecificationRepository;
@Component
public class ProductItemDTOToOrder implements IProductItemDTOToOrder{
	@Autowired
	private IProductRepository productRepository;
	@Autowired
	private IProductSpecificationRepository productSpecificationRepository;

	public ProductItemDTOToOrder() {
	}

	@Override
	public ProductOrderItem transDTOToOrder(ProductOrderItemDTO productOrderItemDTO,CustomerOrder customerOrder) throws Exception{
		ProductOrderItem productOrderItem=new ProductOrderItem(customerOrder);
		productOrderItem.setBusinessInteractionItemSpecId(productOrderItemDTO.getBusinessInteractionItemSpecId());
		productOrderItem.setProductOrderId(productOrderItemDTO.getProductOrderItemId());				
		this.addCharacter(productOrderItemDTO, productOrderItem);
		ToBeProduct toBeProduct=this.transferToBeProduct(productOrderItemDTO.getToBeProductDTO());				
		productOrderItem.setToBeProduct(toBeProduct);
		productOrderItem.setAction(productOrderItemDTO.getAction());
		return productOrderItem;
	}

	@Override
	public ToBeProduct transferToBeProduct(ToBeProductDTO toBeProductDTO) throws Exception{
		ToBeProduct toBeProduct=new ToBeProduct();
		
		toBeProduct.setCustomerId(toBeProductDTO.getCustomerId());		
		toBeProduct.setProductSpecificationId(toBeProductDTO.getProductSpecId());
		toBeProduct.setValidPeriod(toBeProductDTO.getValidPeriod());
		//toBeProductDTO.getAction()
		long productId=toBeProductDTO.getProductId();
		if(productId>0){
			AsIsProduct asIsProduct=productRepository.getProductById(productId);
			toBeProduct.setAsIsProduct(asIsProduct);
		}
		this.addToBeProductCharacter(toBeProductDTO, toBeProduct);		
		//TODO add BarReason

		return toBeProduct;
	}
	
	
	private void addToBeProductCharacter(ToBeProductDTO toBeProductDTO,ToBeProduct toBeProduct) throws Exception{
		 Set<CharacterInstanceDTO>  characterInstanceDTOs = toBeProductDTO.getProductCharacteristics();
		 if(characterInstanceDTOs.size()>0){
			for (CharacterInstanceDTO characterInstanceDTO : characterInstanceDTOs) {
				ToBeProductCharacter character=new ToBeProductCharacter();
				CharacteristicDTOTransHelper.transCharacteristic(character,characterInstanceDTO);
				toBeProduct.addProductCharacter(character);
			}				
		 }
	}	
	
	private void addCharacter(ProductOrderItemDTO productOrderItemDTO,ProductOrderItem productOrderItem) throws Exception{
		 Set<CharacterInstanceDTO>  characterInstanceDTOs = productOrderItemDTO.getCharacters();
		 if(characterInstanceDTOs.size()>0){
			for (CharacterInstanceDTO characterInstanceDTO : characterInstanceDTOs) {
				BIICharacter character=new BIICharacter();
				CharacteristicDTOTransHelper.transCharacteristic(character,characterInstanceDTO);
				productOrderItem.addBiiCharacteristic(character);
			}				
		 }
	}	
}
