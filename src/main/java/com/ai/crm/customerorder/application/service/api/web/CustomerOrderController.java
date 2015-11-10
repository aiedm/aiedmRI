package com.ai.crm.customerorder.application.service.api.web;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ai.common.rootentity.domain.service.impl.SpringEventPublisher;
import com.ai.common.rootentity.domain.service.interfaces.IEventPublisher;
import com.ai.crm.customerorder.application.service.api.dto.CustomerOrderDTO;
import com.ai.crm.customerorder.application.service.api.dto.ShoppingCartDTO;
import com.ai.crm.customerorder.application.service.api.dto.ToBeOfferInstanceDTO;
import com.ai.crm.customerorder.domain.event.createorder.CreateOrderRequested;
import com.ai.crm.customerorder.domain.event.shoppingcart.OfferAddingToCart;
import com.ai.crm.customerorder.domain.model.CustomerOrder;
import com.ai.crm.customerorder.domain.model.OfferOrderItem;
import com.ai.crm.customerorder.domain.model.ProductOrderItem;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/order")
public class CustomerOrderController  {
	@Autowired
	private IEventPublisher eventPublisher;
	public CustomerOrderController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/newOrder",method=RequestMethod.POST,consumes="application/json")
	public CustomerOrderDTO putOrder(@RequestBody CustomerOrderDTO requestedCustomerOrder) throws Exception{
		requestedCustomerOrder.setCustomerOrderId(917);
		requestedCustomerOrder.setCustomerOrderCode("20150917");
		CreateOrderRequested event=new CreateOrderRequested(this);
		event.setCustomerOrderDTO(requestedCustomerOrder);
		eventPublisher.publishEvent(event);		
		return requestedCustomerOrder;
	}
	
	@RequestMapping(value="/shoppingCart/addingOffer",method=RequestMethod.POST,consumes="application/json")
	public CustomerOrderDTO putOfferToCart(@RequestBody ShoppingCartDTO shoppingCart,
			@RequestBody Set<ToBeOfferInstanceDTO> toBeOfferInstances) throws Exception{
		OfferAddingToCart event=new OfferAddingToCart(this);		
		event.setCart(shoppingCart);
		event.setToBeOfferInstances(toBeOfferInstances);
		eventPublisher.publishEvent(event);		
		return shoppingCart;
	}

//	@RequestMapping(value="/queryOrder",method=RequestMethod.GET,produces="application/json")
//	public ResponseEntity<ICustomerOrder> getOrder() throws Exception{
//		customerOrder.setCustomerOrderId(1);
//		customerOrder.setCustomerOrderCode("20120012");
//		offerOrder.setOfferOrderId(101);
//		productOrder.setProductOrderId(202);
//		
//		//IProductOrder productOrder2=new ProductOrder(customerOrder);
//		//productOrder2.setProductOrderId(203);
//		HttpStatus status = customerOrder != null ?
//				HttpStatus.OK : HttpStatus.NOT_FOUND;
//		return new ResponseEntity<ICustomerOrder>(customerOrder, status);
//	}
	


}
