package com.Finzly.BBCUBP.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;


@Entity
@Table(name = "logins")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loginId;
	private String username;
	private int loginOtp;

	@OneToOne
	private Customer customer;

	public Login() {
		// TODO Auto-generated constructor stub
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getLoginOtp() {
		return loginOtp;
	}

	public void setLoginOtp(int loginOtp) {
		this.loginOtp = loginOtp;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", username=" + username + ", loginOtp=" + loginOtp + ", customer="
				+ customer + "]";
	}

}
