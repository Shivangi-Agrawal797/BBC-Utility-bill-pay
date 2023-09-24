package com.Finzly.BBCUBP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Finzly.BBCUBP.Entity.Customer;
import com.Finzly.BBCUBP.Entity.Login;
import com.Finzly.BBCUBP.services.LoginService;
/**
 * Login controller */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/login/")
public class LoginController {

	@Autowired
	private LoginService loginService;

	// to logged in customer
	@PostMapping("/")
	public ResponseEntity<Customer> loginCustomer(@RequestBody Login login) {
		Customer loginCustomer = loginService.loginCustomer(login);
		if (loginCustomer != null) {
			return ResponseEntity.ok(loginCustomer);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}