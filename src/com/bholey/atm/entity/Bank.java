package com.bholey.atm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
public class Bank 
{
	@Id
	@Column(length = 11)
	private String ifscCode;
	@Column(length = 50)
	private String bankName;
	@Column(length = 25)
	private String branchName;
	@Column(length = 15)
	private String helpLine;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "bank")
	private List<Customer> customer;

	

	
}
