package com.ai.crm.customerorder.application.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ai.crm.customerorder.domain.model.impl.CustomerOrder;
import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/order")
public class JsonRequestOrderTranslater  {
	@Autowired
	private ICustomerOrder customerOrder=new CustomerOrder();
	
	public JsonRequestOrderTranslater() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<ICustomerOrder> Order() throws Exception{
		customerOrder.setCustomerOrderId(1);
		customerOrder.setCustomerOrderCode("20120012");
		HttpStatus status = customerOrder != null ?
				HttpStatus.OK : HttpStatus.NOT_FOUND;
		ObjectMapper mapper = new ObjectMapper();
		String jsonString=mapper.writeValueAsString(customerOrder);
		System.out.println(jsonString);		
		
		return new ResponseEntity<ICustomerOrder>(customerOrder, status);
	}
	
	

}
