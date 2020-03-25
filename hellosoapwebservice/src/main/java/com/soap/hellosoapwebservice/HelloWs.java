package com.soap.hellosoapwebservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWs {

	@WebMethod
	public String hello(){
		return "Hello world";
	}
}
