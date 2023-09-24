package com.Finzly.BBCUBP.services;

import java.util.List;

import com.Finzly.BBCUBP.Entity.Bill;

public interface BillService {

	List<Bill> getAllBillsByCustomerId(int customerId);

	List<Bill> getAllUnpaidBills();

	List<Bill> getAllPaidBills();
}