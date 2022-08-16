package com.cognizant.processpensionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.processpensionservice.bean.PensionDetails;

public interface PensionDetailsRepository extends JpaRepository<PensionDetails, String> {

}
