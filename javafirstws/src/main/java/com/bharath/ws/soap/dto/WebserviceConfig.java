package com.bharath.ws.soap.dto;


import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
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
		Endpoint endpoint=new EndpointImpl(bus,new PaymentProcessorImpl());
		endpoint.publish("/PaymentProcessorImpl");
		return endpoint;
		
	}

}
