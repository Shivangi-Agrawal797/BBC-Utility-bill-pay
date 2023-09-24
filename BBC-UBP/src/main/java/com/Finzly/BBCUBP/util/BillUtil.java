package com.Finzly.BBCUBP.util;

import java.time.LocalDate;

public class BillUtil {

	private static final double RATE_PER_UNIT = 41.50; // INR per kWh
	private static final double EARLY_PAYMENT_DISCOUNT = 0.05; // 5% discount
	private static final double ONLINE_PAYMENT_DISCOUNT = 0.05; // 5% discount

	public static double getRatePerUnit() {
		return RATE_PER_UNIT;
	}

	public static double getBillAmount(double unitsConsumed, LocalDate dueDate, boolean isOnlinePayment) {

		// total amount basis of rate per unit
		double totalAmount = unitsConsumed * RATE_PER_UNIT;

		// discount if applicable
		if (isOnlinePayment) {
			totalAmount = totalAmount - (totalAmount * ONLINE_PAYMENT_DISCOUNT);
		}

		// early payment discount deadline
		LocalDate earlyPaymentDeadline = dueDate.minusDays(2);

		// if current date is before the early payment deadline
		if (LocalDate.now().isBefore(earlyPaymentDeadline)) {
			// Apply early payment discount if paid before the deadline
			totalAmount -= totalAmount * EARLY_PAYMENT_DISCOUNT;
		}
		return totalAmount;
	}
}
