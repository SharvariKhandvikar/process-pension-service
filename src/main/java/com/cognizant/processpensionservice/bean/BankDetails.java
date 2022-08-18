package com.cognizant.processpensionservice.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Bank Entity class
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class BankDetails {
	
	@Id
	private String accountNumber;
	private String bankName;
	private String bankType;
	@OneToOne(mappedBy = "bankDetails", fetch = FetchType.EAGER)
	@JsonIgnore
	private PensionDetails pensionDetails;
	
	public BankDetails(String accountNumber, String bankName, String bankType) {
		super();
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.bankType = bankType;
	}	

}
