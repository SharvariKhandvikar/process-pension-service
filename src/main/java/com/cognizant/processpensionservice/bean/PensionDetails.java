package com.cognizant.processpensionservice.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PensionDetails {
	
	@Id
	private String adharNumber;
	private String name;
	private Date dob;
	private String panNumber;
	private int salaryEarned;
	private int allowances;
	private String pensionType;
	@OneToOne(fetch = FetchType.EAGER)
	private BankDetails bankDetails;
	private double pensionAmount;
	private int bankServiceCharge;
	
	
	public PensionDetails(String adharNumber, String name, Date dob, String panNumber, int salaryEarned, int allowances,
			String pensionType, BankDetails bankDetails, double pensionAmount, int bankServiceCharge) {
		super();
		this.adharNumber = adharNumber;
		this.name = name;
		this.dob = dob;
		this.panNumber = panNumber;
		this.salaryEarned = salaryEarned;
		this.allowances = allowances;
		this.pensionType = pensionType;
		this.bankDetails = bankDetails;
		this.pensionAmount = pensionAmount;
		this.bankServiceCharge = bankServiceCharge;
	}
	public PensionDetails() {
		super();
	}
	public String getAdharNumber() {
		return adharNumber;
	}
	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public int getSalaryEarned() {
		return salaryEarned;
	}
	public void setSalaryEarned(int salaryEarned) {
		this.salaryEarned = salaryEarned;
	}
	public int getAllowances() {
		return allowances;
	}
	public void setAllowances(int allowances) {
		this.allowances = allowances;
	}
	public String getPensionType() {
		return pensionType;
	}
	public void setPensionType(String pensionType) {
		this.pensionType = pensionType;
	}
	public BankDetails getBankDetails() {
		return bankDetails;
	}
	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}
	public double getPensionAmount() {
		return pensionAmount;
	}
	public void setPensionAmount(double pensionAmount) {
		this.pensionAmount = pensionAmount;
	}
	public int getBankServiceCharge() {
		return bankServiceCharge;
	}
	public void setBankServiceCharge(int bankServiceCharge) {
		this.bankServiceCharge = bankServiceCharge;
	}
	@Override
	public String toString() {
		return "PensionDetails [adharNumber=" + adharNumber + ", name=" + name + ", dob=" + dob + ", panNumber="
				+ panNumber + ", salaryEarned=" + salaryEarned + ", allowances=" + allowances + ", pensionType="
				+ pensionType + ", bankDetails=" + bankDetails + ", pensionAmount=" + pensionAmount
				+ ", bankServiceCharge=" + bankServiceCharge + "]";
	}
	
	
	
	

}
