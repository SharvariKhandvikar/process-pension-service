package com.cognizant.processpensionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.processpensionservice.bean.BankDetails;

public interface BankDetailsRepository extends JpaRepository<BankDetails, String> {

}
