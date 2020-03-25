package com.aarthi.jaxb.jaxbxjc;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.bharatthippireddy.patient.Patient;

public class JaxbDemo {
	public static void main(String[] args) throws JAXBException{
		try{
		JAXBContext context=JAXBContext.newInstance(Patient.class);
		Marshaller marshal=context.createMarshaller();
		
		Patient patient=new Patient();
		patient.setName("Aarthi");
		patient.setAge(45);
		patient.setId(101);
		
		StringWriter writer=new StringWriter();
		marshal.marshal(patient, writer);
		System.out.println(writer.toString());
		
		Unmarshaller unmarshall=context.createUnmarshaller();
		Patient patient1=(Patient) unmarshall.unmarshal(new StringReader(writer.toString()));
		System.out.println(patient1.getName());
		}catch(JAXBException e){
			e.printStackTrace();
		}
	}

}
