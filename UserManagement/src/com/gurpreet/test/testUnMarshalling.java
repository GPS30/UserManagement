package com.gurpreet.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.gurpreet.model.Customer;
import com.gurpreet.model.User;
import com.gurpreet.model.Users;

public class testUnMarshalling {

	public static void main(String[] args) throws IOException {

		URLConnection connection = null;
		JAXBContext jc;
		try {

			//String userPassword = "admin" + ":" + "admin";
			//String encoding = org.glassfish.jersey.internal.util.Base64.encodeAsString(userPassword.getBytes());
			//URL add = new URL("http://localhost:8080/UserManagement/rest/UserService/users");
			//connection = add.openConnection();
			//connection.setRequestProperty("Authorization", "Basic " + encoding);
			//connection.connect();

			File file = new File("C:\\Gurpreet\\Gurpreet Personal\\Java\\RESTful\\Customer.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
			System.out.println(customer.getAge());
			System.out.println(customer.getName());


		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
