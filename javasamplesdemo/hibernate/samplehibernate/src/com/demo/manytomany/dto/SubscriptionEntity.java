package com.demo.manytomany.dto;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity(name = "SubscriptionEntity")
@Table(name = "SUBSCRIPTION_M_M", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID")})
public class SubscriptionEntity implements Serializable {

	private static final long serialVersionUID = -6790693372846798580L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer subscriptionId;

	@Column(name = "SUBS_NAME", unique = true, nullable = false, length = 100)
	private String subscriptionName;

	@ManyToMany(mappedBy = "subscriptions",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<ReaderEntity> readers;

	public Integer getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Integer subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public String getSubscriptionName() {
		return subscriptionName;
	}

	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}

	public Set<ReaderEntity> getReaders() {
		return readers;
	}

	public void setReaders(Set<ReaderEntity> readers) {
		this.readers = readers;
	}
}
