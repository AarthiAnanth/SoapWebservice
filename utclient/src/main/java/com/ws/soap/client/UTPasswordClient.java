package com.ws.soap.client;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class UTPasswordClient implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		// TODO Auto-generated method stub
		for(int i=0;i< callbacks.length;i++) {
			WSPasswordCallback wpc=(WSPasswordCallback) callbacks[i];
			if(wpc.getIdentifier().equals("cfx")) {
				wpc.setPassword("cfx");
			}
		}

	}

}
