package com.cognizant.processpensionservice.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BankDetails {
	
	@Id
	private String accountNumber;
	private String bankName;
	private String bankType;
	@OneToOne(mappedBy = "bankDetails", fetch = FetchType.EAGER)
	@JsonIgnore
	private PensionDetails pensionDetails;
	
	public PensionDetails getPensionDetails() {
		return pensionDetails;
	}
	public void setPensionDetails(PensionDetails pensionDetails) {
		this.pensionDetails = pensionDetails;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankType() {
		return bankType;
	}
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	public BankDetails(String accountNumber, String bankName, String bankType) {
		super();
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.bankType = bankType;
	}
	public BankDetails() {
		super();
	}
	@Override
	public String toString() {
		return "BankDetails [accountNumber=" + accountNumber + ", bankName=" + bankName + ", bankType=" + bankType
				+ "]";
	}
	
	

}
