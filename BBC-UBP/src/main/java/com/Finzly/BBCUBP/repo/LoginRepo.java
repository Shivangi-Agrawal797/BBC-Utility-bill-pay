package com.Finzly.BBCUBP.repo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Finzly.BBCUBP.Entity.Customer;
import com.Finzly.BBCUBP.Entity.Login;

@Repository
public class LoginRepo {

	@Autowired
	private SessionFactory factory;

	@SuppressWarnings("deprecation")
	public List<Login> getAllUsers() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Login.class);
		return criteria.list();

	}

	public Customer getCustomerWithUserName(String username) {

		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Login.class);
		criteria.add(Restrictions.eq("username", username));
		Login loginUser = (Login) criteria.setMaxResults(1).uniqueResult();
		return loginUser.getCustomer();
	}

	public boolean isValidUser(String username) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Login.class);
		criteria.add(Restrictions.eq("username", username));
		Login loginUser = (Login) criteria.setMaxResults(1).uniqueResult();
		return loginUser != null;
	}

	public boolean isValidOTP(int loginOtp) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Login.class);
		criteria.add(Restrictions.eq("loginOtp", loginOtp));
		Login loginUser = (Login) criteria.setMaxResults(1).uniqueResult();
		return loginUser != null;
	}

}
