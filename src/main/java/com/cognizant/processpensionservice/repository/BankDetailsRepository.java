package com.cognizant.processpensionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.processpensionservice.bean.BankDetails;

//Bank JPA repository
public interface BankDetailsRepository extends JpaRepository<BankDetails, String> {

}
