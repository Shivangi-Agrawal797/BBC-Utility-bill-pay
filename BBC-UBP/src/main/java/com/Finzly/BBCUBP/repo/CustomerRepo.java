package com.Finzly.BBCUBP.repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Finzly.BBCUBP.Entity.Customer;

@Repository
public class CustomerRepo {

	@Autowired
	private SessionFactory factory;

	public Customer getCustomerById(Integer customerId) {

		Session session = factory.openSession();
		Customer customer = session.get(Customer.class, customerId);
		session.close();
		return customer;
	}

	public String updateCustomerData(Customer customer) {
		Session session = factory.openSession();
		session.saveOrUpdate(customer);
		session.beginTransaction().commit();
		session.close();
		return " customer updated successfully!";
	}

	public String updatecustomerContact(Customer customerById) {
		Session session = factory.openSession();
		session.saveOrUpdate(customerById);
		session.beginTransaction().commit();
		session.close();
		return " customer Contact updated successfully!";
	}

	public Customer getCustomerById(String customerName) {
		Session session = factory.openSession();
		Customer customer = session.get(Customer.class, customerName);
		session.close();
		return customer;
	}

	public String updateCustomerName(Customer customer) {
		Session session = factory.openSession();
		session.saveOrUpdate(customer);
		session.beginTransaction().commit();
		session.close();
		return " customer Name updated successfully!";
	}

	public String updatecustomerAddress(Customer customerById) {
		Session session = factory.openSession();
		session.saveOrUpdate(customerById);
		session.beginTransaction().commit();
		session.close();
		return " customer Address updated successfully!";
	}

	public String updateCustomerEmail(Customer customer) {
		Session session = factory.openSession();
		System.err.println("inside method ");
		session.saveOrUpdate(customer);
		session.beginTransaction().commit();
		session.close();
		return " customer Email updated successfully!";
	}

}
