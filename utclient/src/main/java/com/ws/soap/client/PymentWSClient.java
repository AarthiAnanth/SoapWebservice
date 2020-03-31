package com.ws.soap.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import com.bharath.ws.soap.PaymentProcessor;
import com.bharath.ws.soap.PaymentProcessorImplService;
import com.bharath.ws.soap.PaymentProcessorRequest;
import com.bharath.ws.soap.PaymentProcessorResponse;


public class PymentWSClient {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		PaymentProcessorImplService service=new PaymentProcessorImplService(new URL("http://localhost:8080/javafirstws/services/PaymentProcessorImpl?wsdl"));
		PaymentProcessor port=service.getPaymentProcessorImplPort();
		Client client=ClientProxy.getClient(port);
		Endpoint endpoint=client.getEndpoint();
		
		Map<String, Object>props=new HashMap<String, Object>();
		props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		props.put(WSHandlerConstants.USER, "cfx");
		props.put(WSHandlerConstants.PASSWORD_TYPE,WSConstants.PASSWORD_TEXT);
		props.put(WSHandlerConstants.PW_CALLBACK_CLASS,UTPasswordClient.class.getName());
		WSS4JOutInterceptor wsout=new WSS4JOutInterceptor(props);
		endpoint.getOutInterceptors().add(wsout);
		PaymentProcessorRequest request=new PaymentProcessorRequest();
		PaymentProcessorResponse processPaymentResponse = port.processPayment(request);
		System.out.println(processPaymentResponse.isResult());
	}

}
