package com.Finzly.BBCUBP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Finzly.BBCUBP.Entity.Payment;
import com.Finzly.BBCUBP.services.PaymentService;

/**
 * Payment controller
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/payment/")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	// to make bill payment using online mode : card , wallet
	@PostMapping("/{paymentMethod}/{billId}")
	public ResponseEntity<String> makeBillPayment(@PathVariable String paymentMethod, @PathVariable int billId) {
		String paymentStatus = paymentService.makeBillPayment(paymentMethod, billId);

		return new ResponseEntity<>(paymentStatus, HttpStatus.OK);
	}

	// get all payment by id
	@GetMapping("/{paymentId}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable int paymentId) {
		Payment paymentById = paymentService.getPaymentById(paymentId);

		return new ResponseEntity<>(paymentById, HttpStatus.OK);
	}

	// get all payments by customer
	@GetMapping("/user/{customerId}")
	public ResponseEntity<List<Payment>> getPaymentByUser(@PathVariable int customerId) {
		List<Payment> paymentsByUser = paymentService.getPaymentByUser(customerId);

		return new ResponseEntity<>(paymentsByUser, HttpStatus.OK);
	}

}