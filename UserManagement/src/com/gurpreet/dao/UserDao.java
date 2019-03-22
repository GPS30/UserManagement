package com.gurpreet.dao;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.gurpreet.model.Customer;
import com.gurpreet.model.User;
import com.gurpreet.model.Users;

public class UserDao {

	public List<User> getAllUsers() {
		List<User> userList = null;
		try {

			System.out.println("This is inside the DAO Object...");
			File file = new File("C:\\Gurpreet\\Gurpreet Personal\\Java\\RESTful\\Customer.xml");
			if (!file.exists()) {
				System.out.println("This is inside IF ------");
				User user = new User(1, "Mahesh", "Teacher");
				userList = new ArrayList<User>();
				userList.add(user);
				saveUserList(userList);
			} else {
				System.out.println("This is indside else...-----");
				// FileInputStream fis = new FileInputStream(file);
				// ObjectInputStream ois = new ObjectInputStream(fis);

				JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
				System.out.println(customer.getAge());
				System.out.println(customer.getName());

				// ois.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	public List<Customer> getAllCustomers() {
		List<Customer> customerList= new ArrayList<Customer>();
		Customer customer = null;
		try {

			System.out.println("This is inside the DAO Object...");

			File file = new File("C:\\Gurpreet\\Gurpreet Personal\\Java\\RESTful\\Customer.xml");

			System.out.println("This is indside else...-----");

			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			customer = (Customer) jaxbUnmarshaller.unmarshal(file);

			customerList.add(customer);
			
			System.out.println(customer.getAge());
			System.out.println(customer.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerList;
	}

	public User getUser(int id) {
		List<User> users = getAllUsers();

		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public int addUser(User pUser) {
		List<User> userList = getAllUsers();
		boolean userExists = false;
		for (User user : userList) {
			if (user.getId() == pUser.getId()) {
				userExists = true;
				break;
			}
		}
		if (!userExists) {
			userList.add(pUser);
			saveUserList(userList);
			return 1;
		}
		return 0;
	}

	public int updateUser(User pUser) {
		List<User> userList = getAllUsers();

		for (User user : userList) {
			if (user.getId() == pUser.getId()) {
				int index = userList.indexOf(user);
				userList.set(index, pUser);
				saveUserList(userList);
				return 1;
			}
		}
		return 0;
	}

	public int deleteUser(int id) {
		List<User> userList = getAllUsers();

		for (User user : userList) {
			if (user.getId() == id) {
				int index = userList.indexOf(user);
				userList.remove(index);
				saveUserList(userList);
				return 1;
			}
		}
		return 0;
	}

	private void saveUserList(List<User> userList) {
		try {
			File file = new File("C:\\Gurpreet\\Gurpreet Personal\\Java\\RESTful\\User.DAT");
			FileOutputStream fos;

			fos = new FileOutputStream(file);

			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(userList);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}