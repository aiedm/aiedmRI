package com.ai.crm.customerorder.test;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.ai.crm.config.RootConfig;
import com.ai.crm.config.WebConfig;
import com.ai.crm.customerorder.application.service.api.JsonRequestOrderTranslater;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/root-context.xml","/spring/appServlet/servlet-context.xml"}) 
@WebAppConfiguration
public class TestRestful {

	@Test
	public void testGetJsonFromOrder() throws Exception{
		JsonRequestOrderTranslater controller=new JsonRequestOrderTranslater(); 
		 MockMvc mockMvc = standaloneSetup(controller).build();
		 mockMvc.perform(get("/order")
				 .accept(MediaType.APPLICATION_JSON))
				 .andExpect(status().isOk())
				 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
				 //.andDo(print())
				 .andExpect(jsonPath("$.customerOrderCode").value("20120012"))
				 ;			
	}

}
