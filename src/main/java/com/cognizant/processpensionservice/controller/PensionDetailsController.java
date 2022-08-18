package com.cognizant.processpensionservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.processpensionservice.bean.BankDetails;
import com.cognizant.processpensionservice.bean.PensionDetails;
import com.cognizant.processpensionservice.bean.UserLogin;
import com.cognizant.processpensionservice.proxy.AuthenticationProxy;
import com.cognizant.processpensionservice.proxy.PensionerDetailsProxy;
import com.cognizant.processpensionservice.repository.BankDetailsRepository;
import com.cognizant.processpensionservice.repository.PensionDetailsRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PensionDetailsController {

	
	@Autowired
	private PensionerDetailsProxy proxy;
	
	@Autowired
	private AuthenticationProxy authProxy;
	
	@Autowired
	private PensionDetailsRepository repo;
	
	@Autowired
	private BankDetailsRepository bankRepo;
	
	public ResponseEntity authenticationResponse;
	
	//Get and save the pension details 
	//Requires the adhar number and authorization token
	@PostMapping("/pensionDetails/{adharNumber}")
	public PensionDetails processPension(@RequestHeader(name = "Authorization") String token,
			@PathVariable("adharNumber") String adharNumber){
		log.info("Getting pensioner details from service ...");
		PensionDetails pd = proxy.getPensionerDetailsByAdhar(token, adharNumber);
		
		log.info("Pensioner is... "+pd);
		log.info("Calculating pension ammount and bank service charges...");
		double pensionAmount;
		
		if(pd.getPensionType().equals("self"))
		{
			pensionAmount = (((double)pd.getSalaryEarned()*80)/100)+(double)pd.getAllowances();
		}
		else {
			pensionAmount = (((double)pd.getSalaryEarned()*50)/100)+(double)pd.getAllowances();
		}
				
		pd.setPensionAmount(pensionAmount);
			
		BankDetails bd = pd.getBankDetails();
		
		if(bd.getBankType().equalsIgnoreCase("public")) {
			pd.setBankServiceCharge(500);
		}
		else {
			pd.setBankServiceCharge(550);
		}	
		bankRepo.save(pd.getBankDetails());
		repo.save(pd);
		log.info("Returning pension details...");
		return pd;			
		
	}
	
	//To generate token for Junit testing
	public String  generateToken() {
		String token = authProxy.login(new UserLogin("user1", "user1")).getToken();
		log.info("token... "+token);
		return token;
	}
}
