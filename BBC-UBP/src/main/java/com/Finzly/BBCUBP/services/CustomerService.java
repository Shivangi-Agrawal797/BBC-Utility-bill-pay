package com.Finzly.BBCUBP.services;

import com.Finzly.BBCUBP.Entity.Customer;

// service related to customer 
public interface CustomerService {

	public String updatecustomerContact(Customer customer, int customerContact);

	public String updateCustomerEmail(String customerEmail, int customerId);

	// service to update customer details:
	public String updateCustomerData(Customer customer, int customerId);

	public Customer getCustomerById(Integer customerId);

}
