package com.cognizant.processpensionservice.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Entity class Pension details
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
	

}
