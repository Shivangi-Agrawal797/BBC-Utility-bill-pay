package com.Finzly.BBCUBP.services;

import java.util.List;

import com.Finzly.BBCUBP.Entity.Payment;

public interface PaymentService {

	String makeBillPayment(String paymentMethod, int billId);

	Payment getPaymentById(int paymentId);

	List<Payment> getPaymentByUser(int customerId);
}
