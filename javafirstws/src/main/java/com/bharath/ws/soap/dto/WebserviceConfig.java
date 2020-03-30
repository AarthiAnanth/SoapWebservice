package com.bharath.ws.soap.dto;


import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.dom.WSConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bharath.ws.soap.PaymentProcessorImpl;



@Configuration
public class WebserviceConfig {
	
	@Autowired
	private Bus bus;
	
	@Bean
	@SuppressWarnings("resource")
	public Endpoint endpoint(){
		EndpointImpl endpoint=new EndpointImpl(bus,new PaymentProcessorImpl());
		endpoint.publish("/PaymentProcessorImpl");
		
		Map<String,Object> inprops = new HashMap<>();
		inprops.put(ConfigurationConstants.ACTION, ConfigurationConstants.USERNAME_TOKEN);
		inprops.put(ConfigurationConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		inprops.put(ConfigurationConstants.PW_CALLBACK_CLASS,UTPasswordCallback.class.getName());
		WSS4JInInterceptor wssjn=new WSS4JInInterceptor(inprops);
		endpoint.getInInterceptors().add(wssjn);
		return endpoint;
		
	}

}
