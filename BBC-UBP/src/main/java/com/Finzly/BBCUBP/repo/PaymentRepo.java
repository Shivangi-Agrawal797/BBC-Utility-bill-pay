package com.Finzly.BBCUBP.repo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Finzly.BBCUBP.Entity.Bill;
import com.Finzly.BBCUBP.Entity.Customer;
import com.Finzly.BBCUBP.Entity.Payment;
import com.Finzly.BBCUBP.exceptions.BillPaymentException;
import com.Finzly.BBCUBP.exceptions.ResourceNotFoundException;
import com.Finzly.BBCUBP.util.BillUtil;

@Repository
public class PaymentRepo {

	@Autowired
	private SessionFactory factory;

	@SuppressWarnings("deprecation")
	public String makeBillPayment(String paymentMethod, int billId) {

		Session session = factory.openSession();
		Bill bill = session.get(Bill.class, billId);

		Criteria criteria = session.createCriteria(Payment.class);
		criteria.add(Restrictions.eq("billId", billId));

		// checking if bill is already paid
		if (bill.getIsPaid()) {
			throw new BillPaymentException("Bill already paid with bill id " + billId);
		}
//		else if (bill == null) {
//			throw new ResourceNotFoundException("No bill found with id " + billId);	
//		}
		Payment payment = new Payment();
		payment.setPaymentMethod(paymentMethod);
		payment.setPaymemtDate(LocalDate.now());
		payment.setPaymentAmount(BillUtil.getBillAmount(bill.getUnitConsumption(), bill.getBillDueDate(), true));
		payment.setBill(bill);// setting bill

//				Criteria custCriteria = session.createCriteria(Customer.class);
//				custCriteria.add(Restrictions.eq("customerId", customerId)).list();

		// payment.setCustomer();

		payment.setPaymentStatus("success");// check success or faile
		bill.setIsPaid(true); // setting bill payment true

		List<Payment> payments = new ArrayList<>();
		payments.add(payment);
		bill.setPayments(payments); // setting payment to bill

		session.save(payment);
		session.saveOrUpdate(bill);
		session.beginTransaction().commit();

		return "Payment done successfully!";

//		if (paymentMethod.trim().equalsIgnoreCase("card") || paymentMethod.trim().equalsIgnoreCase("wallet")) {
//			
//		}
//		else {
//			throw new BillPaymentException("Not a valid bill payment option! Only Card/Wallet requird ");
//		}

	}

	public Payment getPaymentById(int paymentId) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Payment.class);
		criteria.add(Restrictions.eq("paymentId", paymentId));
		Payment payment = (Payment) criteria.uniqueResult();
		return payment;
	}

	public List<Payment> getPaymentByUser(int customerId) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Payment.class);
		Customer customer = session.get(Customer.class, customerId);
		criteria.add(Restrictions.eq("customerId", customer.getCustomerId()));
		List<Payment> list = criteria.list();

		return list;
	}
}
