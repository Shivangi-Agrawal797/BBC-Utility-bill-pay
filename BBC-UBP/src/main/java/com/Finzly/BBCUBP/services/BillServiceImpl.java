package com.Finzly.BBCUBP.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Finzly.BBCUBP.Entity.Bill;
import com.Finzly.BBCUBP.exceptions.ResourceNotFoundException;
import com.Finzly.BBCUBP.repo.BillRepo;

@Service
public class BillServiceImpl implements BillService {

	private static final Logger logger = LoggerFactory.getLogger(BillServiceImpl.class);

	@Autowired
	private BillRepo billRepo;

	@Override
	public List<Bill> getAllBillsByCustomerId(int customerId) {
		logger.info("BillService :: getAllBillsByCustomerId()");
		List<Bill> allBillsByCustomerId = billRepo.getAllBillsByCustomerId(customerId);
		if (allBillsByCustomerId != null) {
			return allBillsByCustomerId;
		} else {
			logger.error("BillService :: no bill found with id " + customerId);
			throw new ResourceNotFoundException("No bill found for customer id" + customerId);
		}

	}

	@Override
	public List<Bill> getAllUnpaidBills() {
		logger.info("BillService :: getAllUnpaidBills()");

		List<Bill> allUnpaidBills = billRepo.getAllUnpaidBills();
		if (allUnpaidBills != null) {
			return allUnpaidBills;
		} else {
			logger.error("BillService :: no unpaid bill found ");

			throw new ResourceNotFoundException("No Unpaid bills found");
		}
	}

	@Override
	public List<Bill> getAllPaidBills() {
		logger.info("BillService :: getAllPaidBills()");
		List<Bill> allPaidBills = billRepo.getAllPaidBills();
		if (allPaidBills != null) {
			return allPaidBills;
		} else {
			logger.error("BillService :: no paid bill found ");
			throw new ResourceNotFoundException("No Paid bills found");
		}
	}

}