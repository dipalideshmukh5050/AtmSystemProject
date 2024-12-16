package com.bholey.atm.entity;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Card
{
	@Id
	@Column(length=16)
	private String cardNo;
	@Column(length=4)
	private String pin;
	@Column(length=3)
	private String cvv;
	@Column(length=20)
	private String type;
	@Column(length=7)
	private String status;
	
	private LocalDate issueDate;
	private LocalDate expiryDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountNo")
	private Account account;

}
