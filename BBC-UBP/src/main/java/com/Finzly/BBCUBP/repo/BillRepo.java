package com.Finzly.BBCUBP.repo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Finzly.BBCUBP.Entity.Bill;

@Repository
public class BillRepo {

	@Autowired
	private SessionFactory factory;

	@SuppressWarnings("deprecation")
	public List<Bill> getAllBillsByCustomerId(int customerId) {

		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Bill.class);
		List<Bill> billList = criteria.add(Restrictions.eq("customerId", customerId)).list();
		return billList;
	}

	@SuppressWarnings("deprecation")
	public List<Bill> getAllUnpaidBills() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Bill.class);
		List<Bill> listOfUnpaidBills = criteria.add(Restrictions.eq("isPaid", false)).list();

		return listOfUnpaidBills;

	}

	@SuppressWarnings("deprecation")
	public List<Bill> getAllPaidBills() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Bill.class);
		List<Bill> listOfPaidBills = criteria.add(Restrictions.eq("isPaid", true)).list();

		return listOfPaidBills;
	}

}
