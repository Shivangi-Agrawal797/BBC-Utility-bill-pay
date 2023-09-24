package com.Finzly.BBCUBP.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Finzly.BBCUBP.Entity.Customer;
import com.Finzly.BBCUBP.exceptions.ResourceNotFoundException;
import com.Finzly.BBCUBP.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public String updateCustomerData(Customer customer, int customerId) {

		logger.info("CustomerService :: updateCustomerData()");
		// fetch customer
		Customer customerById = customerRepo.getCustomerById(customerId);
		if (customerById != null) {
			customerById.setCustomerName(customer.getCustomerName());
			customerById.setCustomerEmail(customer.getCustomerEmail());
			customerById.setCustomerContact(customer.getCustomerContact());
			customerById.setCustomerAddress(customer.getCustomerAddress());

			String status = customerRepo.updateCustomerData(customerById);
			logger.info("CustomerService :: Customer Updated Success!");
			return status;
		}
		return null;
	}

	@Override
	public String updatecustomerContact(Customer customer, int customerContact) {
		Customer customerById = customerRepo.getCustomerById(customerContact);
		if (customerById != null) {
			customerById.setCustomerContact(customer.getCustomerContact());

			String status = customerRepo.updatecustomerContact(customerById);
			logger.info("CustomerService :: Customer Contact Updated Success!");
			return status;
		}
		return null;
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		Customer customerById = customerRepo.getCustomerById(customerId);
		if (customerById != null) {
			return customerById;
		} else {
			logger.error("CustomerService :: no customer found with id" + customerId);
			throw new ResourceNotFoundException("No such customer found with customer id " + customerId);
		}

	}

	@Override
	public String updateCustomerEmail(String customerEmail, int customerId) {
		logger.info("CustomerService :: updateCustomerEmail()");
		Customer customerById = customerRepo.getCustomerById(customerEmail);
		if (customerById != null) {
			System.err.println("update email in serveiec");
			customerById.setCustomerEmail(customerEmail);
			String status = customerRepo.updateCustomerEmail(customerById);
			return status;
		}
		return null;
	}

}