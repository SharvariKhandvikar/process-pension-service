package com.cognizant.processpensionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.processpensionservice.bean.PensionDetails;

//Pension details JPA repository
public interface PensionDetailsRepository extends JpaRepository<PensionDetails, String> {

}
