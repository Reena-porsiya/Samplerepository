package com.flights.entity;

import com.flights.model.Booking;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @Column(name = "payment_id")
    private int paymentId;

    @Column(name = "client_id")
    private int clientId;

    @Column(name = "amount")
    private float amount;

    @Column(name = "payment_date")
    private java.sql.Date paymentDate;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public java.sql.Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(java.sql.Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
    
}