package com.gurpreet.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Users {

	List <User> users;

	@XmlElement(name = "user")
	public List<User> getUsers() {
		return users;
	}

	
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
