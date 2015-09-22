package com.ai.crm.customerorder.application.service.api.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.ai.crm.customerorder.domain.model.interfaces.ICustomerOrder;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class OrderDeserializer extends StdDeserializer{
	private Map<String,Class<?>> registry = new HashMap<String, Class<?>>();
	public OrderDeserializer() {
		super(ICustomerOrder.class);
	}

	@Override
	public Object deserialize(JsonParser jp, DeserializationContext context) throws IOException,
			JsonProcessingException {
	    ObjectMapper mapper = (ObjectMapper) jp.getCodec();
	    ObjectNode root = (ObjectNode) mapper.readTree(jp);
	    Class<?> orderClass = null;
	    Iterator<Entry<String, JsonNode>> elementsIterator = root.fields();
	    while (elementsIterator.hasNext())
	    {
	      Entry<String, JsonNode> element=elementsIterator.next();
	      String name = element.getKey();
	      if (registry.containsKey(name))
	      {
	    	  orderClass = registry.get(name);
	    	  break;
	      }else{
	    	  orderClass= element.getClass();
	      }
	    }
	    if (orderClass == null) return null;
	    return mapper.readValue(jp, orderClass);
	}
	
	 public void registerOrderItem(String uniqueAttribute, Class<?> orderItem){
		    registry.put(uniqueAttribute, orderItem);
	 }	

}
