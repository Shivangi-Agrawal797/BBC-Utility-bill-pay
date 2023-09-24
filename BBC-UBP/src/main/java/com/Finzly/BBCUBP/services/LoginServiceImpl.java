package com.Finzly.BBCUBP.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Finzly.BBCUBP.Entity.Customer;
import com.Finzly.BBCUBP.Entity.Login;
import com.Finzly.BBCUBP.exceptions.ResourceNotFoundException;
import com.Finzly.BBCUBP.repo.LoginRepo;

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	private LoginRepo loginRepo;

	public Customer loginCustomer(Login login) {
		logger.info("LoginService ::  ");
		String username = login.getUsername();
		int loginOtp = login.getLoginOtp();
		if (!loginRepo.isValidUser(username)) {
			logger.error("LoginService :: User Not found " + username);

			throw new ResourceNotFoundException("No user found with username " + username);
		}
		if (!loginRepo.isValidOTP(loginOtp)) {
			logger.error("LoginService :: Invalid OTP " + loginOtp);
			throw new ResourceNotFoundException("Invalid OTP " + loginOtp);
		}
		Customer customerWithUserName = loginRepo.getCustomerWithUserName(username);
		if (customerWithUserName != null) {
			return customerWithUserName;
		}
		return null;
	}

}
