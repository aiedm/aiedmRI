package com.ai.crm.customerorder.test;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/root-context.xml","classpath:spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
public class TestRestful {	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	String order="";
	MockMvc mockMvc = null;
	
	@Before
	public void prepare() throws Exception{
		File file = new File("D:\\workspace\\springTest\\aiedmRI\\src\\test\\resource\\Order.json");
		FileInputStream in=new FileInputStream(file);
		int size=in.available();
        byte[] buffer=new byte[size];
        in.read(buffer);
        in.close();
        order=new String(buffer);
		mockMvc = webAppContextSetup(webApplicationContext).build();        
	}

	@Test
	@Ignore
	public void testGetJsonFromOrder() throws Exception{
		 mockMvc.perform(
				 get("/order/queryOrder")
				 .accept(MediaType.APPLICATION_JSON)
				 )
				 .andExpect(status().isOk())
				 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
				 .andExpect(jsonPath("$.customerOrderCode").value("20120012"))
				 ;			
	}
	

	@Test
	//@Ignore
	public void testPutJsonOrder() throws Exception{
		mockMvc.perform(
				 post("/order/newOrder")
				 .content(order.getBytes())
				 .contentType(MediaType.APPLICATION_JSON)
				 .accept(MediaType.APPLICATION_JSON)
				 )
				 .andExpect(status().isOk())
				 //.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				 .andExpect(jsonPath("$.customerOrderId").value(1))
				 ;			
	}	


}
