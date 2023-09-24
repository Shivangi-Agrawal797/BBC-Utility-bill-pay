package com.Finzly.BBCUBP.Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bills")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billId;
	private double unitConsumption;
	private LocalDate billDueDate;
	private double billDuration;
	private boolean isPaid;
	private double billAmount;

	// many bills are associated with a customer
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToMany
	private List<Payment> payments;

	public Bill() {

	}

	public Bill(int billId, double unitConsumption, LocalDate billDueDate, double billDuration, boolean isPaid,
			Customer customer, List<Payment> payments) {
		super();
		this.billId = billId;
		this.unitConsumption = unitConsumption;
		this.billDueDate = billDueDate;
		this.billDuration = billDuration;
		this.isPaid = isPaid;
		this.customer = customer;
		this.payments = payments;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public double getUnitConsumption() {
		return unitConsumption;
	}

	public void setUnitConsumption(double unitConsumption) {
		this.unitConsumption = unitConsumption;
	}

	public LocalDate getBillDueDate() {
		return billDueDate;
	}

	public void setBillDueDate(LocalDate billDueDate) {
		this.billDueDate = billDueDate;
	}

	public double getBillDuration() {
		return billDuration;
	}

	public void setBillDuration(double billDuration) {
		this.billDuration = billDuration;
	}

	public boolean getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", unitConsumption=" + unitConsumption + ", billDueDate=" + billDueDate
				+ ", billDuration=" + billDuration + ", isPaid=" + isPaid + ", billAmount=" + billAmount + ", customer="
				+ customer + ", payments=" + payments + "]";
	}

}