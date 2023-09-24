package com.Finzly.BBCUBP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Finzly.BBCUBP.Entity.Bill;
import com.Finzly.BBCUBP.services.BillService;
/**
 * Bill controller*/
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/bill")
public class BillController {

	@Autowired
	private BillService billService;

	// get all bills of customer using customer id
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<List<Bill>> getAllBillsByCustomerId(@PathVariable int customerId) {

		List<Bill> billsByCustomerId = billService.getAllBillsByCustomerId(customerId);
		if (billsByCustomerId != null) {
			return new ResponseEntity<>(billsByCustomerId, HttpStatus.OK);
		}
		return null;
	}

	// get all bills which is unpaid
	@GetMapping("/unpaid")
	public ResponseEntity<List<Bill>> getAllUnpaidBills() {

		List<Bill> allUnpaidBills = billService.getAllUnpaidBills();

		return new ResponseEntity<>(allUnpaidBills, HttpStatus.OK);

	}

	// get all bills which is paid
	@GetMapping("/paid")
	public ResponseEntity<List<Bill>> getAllPaidBills() {

		List<Bill> allPaidBills = billService.getAllPaidBills();

		return new ResponseEntity<>(allPaidBills, HttpStatus.OK);

	}

}
