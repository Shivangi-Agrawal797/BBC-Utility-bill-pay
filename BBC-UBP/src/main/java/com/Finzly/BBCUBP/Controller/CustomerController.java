package com.Finzly.BBCUBP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Finzly.BBCUBP.Entity.Customer;
import com.Finzly.BBCUBP.services.CustomerService;
/**
 * Custotmer controller */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// to get customer record using customer id
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer customerId) {

		Customer foundCustomer = customerService.getCustomerById(customerId);
		if (foundCustomer != null) {
			return new ResponseEntity<>(foundCustomer, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(foundCustomer, HttpStatus.NOT_FOUND);

		}

	}

	// to update customer alldata
	@PutMapping("/{customerId}")
	public ResponseEntity<String> updateCustomerData(@RequestBody Customer customer, @PathVariable int customerId) {
		String status = customerService.updateCustomerData(customer, customerId);
		if (status != null) {
			return new ResponseEntity<>(status, HttpStatus.OK);
		}
		return new ResponseEntity<>("Unable to update customer details! customer not found with id " + customerId,
				HttpStatus.NOT_FOUND);

	}

	// to update customer email
	@PutMapping("/email/{customerId}")
	public ResponseEntity<String> updateCustomerEmail(@RequestBody String customerEmail, @PathVariable int customerId) {
		System.out.println(customerEmail);
		System.out.println(customerId);
		String status = customerService.updateCustomerEmail(customerEmail, customerId);
		if (status != null) {
			return new ResponseEntity<>(status, HttpStatus.OK);
		}
		return new ResponseEntity<>("Unable to update customer details! customer not found with id " + customerEmail,
				HttpStatus.NOT_FOUND);
	}

	// to update customer contact
	@PutMapping("/contact/{customerContact}")
	public ResponseEntity<String> updatecustomerContact(@RequestBody Customer customer,
			@RequestParam int customerContact) {
		String status = customerService.updatecustomerContact(customer, customerContact);
		if (status != null) {
			return new ResponseEntity<>(status, HttpStatus.OK);
		}
		return new ResponseEntity<>(
				"Unable to update customer details! customer not found with adress " + customerContact,
				HttpStatus.NOT_FOUND);

	}

}
