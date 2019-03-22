package com.gurpreet.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class ClientClass {

	public static void main(String[] args) {
		
		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
			    .nonPreemptive()
			    .credentials("admin", "admin")
			    .build();

		
		Client client = ClientBuilder.newClient();//.register(feature);
		
		WebTarget webTarget = client.target("http://localhost:8080/UserManagement/rest/UserService/users");
		
		
		System.out.println(webTarget.request(MediaType.APPLICATION_XML_TYPE).get());
		
	}
	
}
