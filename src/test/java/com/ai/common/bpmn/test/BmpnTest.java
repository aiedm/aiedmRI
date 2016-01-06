package com.ai.common.bpmn.test;

import static org.junit.Assert.*;

import java.io.File;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ai.common.bpmn.model.BaseEvent;
import com.ai.common.bpmn.model.EventListener;
import com.ai.common.bpmn.model.EventListenerSet;
import com.ai.common.bpmn.model.ServiceTask;
import com.ai.common.bpmn.model.ServiceTaskParameter;
import com.ai.common.bpmn.repository.interfaces.IBpmnRepository;
import com.ai.common.rootentity.domain.service.interfaces.IEventPublisher;
import com.ai.crm.customerorder.application.service.api.dto.CustomerOrderDTO;
import com.ai.crm.customerorder.domain.event.createorder.CreateOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.CheckNewOfferOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.CheckNewOfferOrderPassed;
import com.ai.crm.customerorder.domain.event.createorder.CheckNewOfferOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.CheckNewOfferOrderPassed;
import com.ai.crm.customerorder.domain.event.createorder.CheckOrderCustomerAvalibityPassed;
import com.ai.crm.customerorder.domain.event.createorder.CustomerOrderCreated;
import com.ai.crm.customerorder.domain.event.createorder.NewOfferOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.NewOfferOrderCreated;
import com.ai.crm.customerorder.domain.event.createorder.NewOfferOrderRequested;
import com.ai.crm.customerorder.domain.event.createorder.NewOfferOrderCreated;
import com.ai.crm.customerorder.domain.event.createorder.CreateCustomerOrderFinished;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

import groovy.lang.GroovyClassLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/root-context.xml","classpath:spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
@Transactional
@Commit
public class BmpnTest {
	@Autowired
	private IBpmnRepository bpmnRepository;
	
	@Test
	public void test() throws Exception{
		CreateOrderRequested eventCreateOrderRequested=new CreateOrderRequested(this);
		eventCreateOrderRequested.setCode("com.ai.crm.customerorder.domain.event.createorder.CreateOrderRequested");
		ServiceTask checkCreateOrderRequestActivity=new ServiceTask();
		checkCreateOrderRequestActivity.setPackageName("com.ai.crm.customerorder.domain.service.interfaces");
		checkCreateOrderRequestActivity.setServiceType("ICheckCustomerOrder");
		checkCreateOrderRequestActivity.setServiceName("checkCreateOrderRequest");
		ServiceTaskParameter checkCreateOrderRequestParam=new ServiceTaskParameter(checkCreateOrderRequestActivity);
		checkCreateOrderRequestParam.setParameter("event");
		EventListenerSet createCustomerOrderListener=new EventListenerSet();
		createCustomerOrderListener.setCode("CustomerOrderListenerNew");
		createCustomerOrderListener.setName("Create Customer Order Listener");
		EventListener onCreateOrderRequestedEvent=new EventListener(createCustomerOrderListener);
		onCreateOrderRequestedEvent.setEvent(eventCreateOrderRequested);
		onCreateOrderRequestedEvent.setOnEventActivity(checkCreateOrderRequestActivity);
		String filecontent=createCustomerOrderListener.toGroovyString();		
		System.out.println(filecontent);
		bpmnRepository.saveEventListenerSetToFile(createCustomerOrderListener);
	}

}
