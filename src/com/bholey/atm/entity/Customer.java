package com.bholey.atm.entity;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
public class Customer 
{
	@Id
	@Column(length = 20)
	private String customerId;
	@Column(length = 50)
	private String customerName;
	@Column(length = 50)
	private String customerAddress;
	@Column(length = 10)
	private String mobile;
	@Column(length = 1)
	private Character gender;
	private LocalDate dob;
	@Column(length = 25)
	private String email;
	@Column(length = 10)
	private String panCard;
	@Column(length = 12)
	private String aadharCard;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ifscCode")
	private Bank bank;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	private List<Account> account;

	

	
}
