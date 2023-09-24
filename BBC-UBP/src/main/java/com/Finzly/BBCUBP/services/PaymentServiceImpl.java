package com.Finzly.BBCUBP.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Finzly.BBCUBP.Entity.Payment;
import com.Finzly.BBCUBP.exceptions.ResourceNotFoundException;
import com.Finzly.BBCUBP.repo.PaymentRepo;

@Service
public class PaymentServiceImpl implements PaymentService {

	private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

	@Autowired
	private PaymentRepo paymentRepo;

	@Override
	public String makeBillPayment(String paymentMethod, int billId) {

		String billPayment = paymentRepo.makeBillPayment(paymentMethod, billId);
		logger.info("PaymentService :: Payment Done Successfully");
		return billPayment;
	}

	@Override
	public Payment getPaymentById(int paymentId) {
		logger.info("PaymentService :: getPaymentById() ");
		Payment paymentById = paymentRepo.getPaymentById(paymentId);
		if (paymentById != null) {

			return paymentById;
		} else {
			logger.error("PaymentService :: Payment Not found");
			throw new ResourceNotFoundException("Payment not found with id " + paymentId);
		}

	}

	@Override
	public List<Payment> getPaymentByUser(int customerId) {
		logger.info("PaymentService :: getPaymentByUser() ");
		List<Payment> paymentsByUser = paymentRepo.getPaymentByUser(customerId);
		if (paymentsByUser != null) {
			return paymentsByUser;
		} else {
			logger.error("PaymentService :: Payment Not found");
			throw new ResourceNotFoundException("No payments found with this user ");
		}

	}

}