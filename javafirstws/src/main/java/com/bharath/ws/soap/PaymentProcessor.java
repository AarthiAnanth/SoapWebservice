package com.bharath.ws.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlRootElement;

import com.bharath.ws.soap.dto.PaymentProcessorRequest;
import com.bharath.ws.soap.dto.PaymentProcessorResponse;
@XmlRootElement(name="PaymentProcessor")
@WebService(name="PaymentProcessor")
public interface PaymentProcessor {

	@WebMethod
	public @WebResult(name="response")PaymentProcessorResponse processPayment(@WebParam(name="paymentProcessorRequest")PaymentProcessorRequest paymentProcessorRequest);
}
