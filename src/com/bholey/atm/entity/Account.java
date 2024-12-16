package com.bholey.atm.entity;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Account 
{
	@Id
	@Column(length=15)
	private String accountNo;
	@Column(length=10)
	private String accountType;
	@Column(length=10)
	private String accountStatus;
	private LocalDate openingDate;
	private Double balance;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "account")
	private List<Card> card;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "account")
	private List<Transaction> transaction;

}
