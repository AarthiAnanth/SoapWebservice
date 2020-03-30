package com.bharath.ws.soap.dto;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class UTPasswordCallback implements CallbackHandler {

	private Map<String,String> passwords=new HashMap<>();
	
	public void UTPasswordCallback() {
		passwords.put("aarthi","Akan@1604");
		passwords.put("cfx","cfx");
	}
	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		// TODO Auto-generated method stub
		for(Callback callback:callbacks) {
			WSPasswordCallback passwordCallBack=(WSPasswordCallback) callback;
			String password=passwords.get(passwordCallBack.getIdentifier());
			if(password!=null) {
				passwordCallBack.setPassword(password);
				return; 
			}
		}
		

	}

}
