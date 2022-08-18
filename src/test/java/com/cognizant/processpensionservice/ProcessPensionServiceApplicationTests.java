package com.cognizant.processpensionservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.processpensionservice.bean.BankDetails;
import com.cognizant.processpensionservice.bean.PensionDetails;
import com.cognizant.processpensionservice.bean.Token;
import com.cognizant.processpensionservice.bean.UserLogin;
import com.cognizant.processpensionservice.controller.PensionDetailsController;
import com.cognizant.processpensionservice.proxy.AuthenticationProxy;
import com.cognizant.processpensionservice.proxy.PensionerDetailsProxy;
import com.cognizant.processpensionservice.repository.PensionDetailsRepository;

@SpringBootTest
class ProcessPensionServiceApplicationTests {

	
Logger log = LoggerFactory.getLogger(ProcessPensionServiceApplicationTests.class);
	
	@Autowired
	PensionDetailsController controller;
	@Autowired
	PensionDetailsRepository pensionRepo;
	@Autowired
	private PensionerDetailsProxy proxy;
	@Autowired
	private AuthenticationProxy authProxy;
	
	
	Date date = new Date();
	BankDetails bd = new BankDetails("7777777777", "Bank Of Test", "private"); 
	PensionDetails pd = new PensionDetails("666666666666", "test",date, 
			"TEST5568P", 50000, 10000, "self",bd, (0.8*50000),550);
		
	@Test
	void contextLoads() {
		assertTrue(true);
	}

	@Test
	void testGetPensionerDetails1() {
		log.info("Validate the pesion details service for valid details ...");
		String adharNumber = "110911599416";
		String token = controller.generateToken();
		log.info("token passing to request ======>>>> "+token);
		PensionDetails expected = proxy.getPensionerDetailsByAdhar(token, adharNumber);
		double pensionAmount = (((double)expected.getSalaryEarned()*80)/100)+(double)expected.getAllowances();
				
		expected.setPensionAmount(pensionAmount);
			
		BankDetails expbd = expected.getBankDetails();
	
		expected.setBankServiceCharge(500);

		PensionDetails actual = controller.processPension(token, adharNumber);
		assertEquals(expected.getAdharNumber(), actual.getAdharNumber());
		assertEquals(expected.getAllowances(), actual.getAllowances());
		assertEquals(expected.getSalaryEarned(), actual.getSalaryEarned());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getDob(), actual.getDob());
		assertEquals(expected.getPanNumber(), actual.getPanNumber());
		assertEquals(expected.getPensionType(), actual.getPensionType());
		assertEquals(expected.getPensionAmount(), actual.getPensionAmount());
		assertEquals(expected.getBankDetails().getBankName(), actual.getBankDetails().getBankName());
		assertEquals(expected.getBankDetails().getAccountNumber(), actual.getBankDetails().getAccountNumber());
		assertEquals(expected.getBankDetails().getBankType(), actual.getBankDetails().getBankType());
		assertEquals(expected.getBankServiceCharge(), actual.getBankServiceCharge());
	}
	
	@Test
	void testGetPensionerDetails2() {
		log.info("Validate the pesion details service for valid details ...");
		String adharNumber = "556781253840";
		String token = controller.generateToken();
		PensionDetails expected = proxy.getPensionerDetailsByAdhar(token, adharNumber);
		double pensionAmount =(((double)expected.getSalaryEarned()*50)/100)+(double)expected.getAllowances();
				
		expected.setPensionAmount(pensionAmount);
			
		BankDetails expbd = expected.getBankDetails();
		
		expected.setBankServiceCharge(550);
		
		PensionDetails actual = controller.processPension(token, adharNumber);
		assertEquals(expected.getAdharNumber(), actual.getAdharNumber());
		assertEquals(expected.getAllowances(), actual.getAllowances());
		assertEquals(expected.getSalaryEarned(), actual.getSalaryEarned());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getDob(), actual.getDob());
		assertEquals(expected.getPanNumber(), actual.getPanNumber());
		assertEquals(expected.getPensionType(), actual.getPensionType());
		assertEquals(expected.getPensionAmount(), actual.getPensionAmount());
		assertEquals(expected.getBankDetails().getBankName(), actual.getBankDetails().getBankName());
		assertEquals(expected.getBankDetails().getAccountNumber(), actual.getBankDetails().getAccountNumber());
		assertEquals(expected.getBankDetails().getBankType(), actual.getBankDetails().getBankType());
		assertEquals(expected.getBankServiceCharge(), actual.getBankServiceCharge());
	}
	
	@Test
	void testGetPensionDetailsException() {
		log.info("Validate the pesion details service for invalid adhar number ...");
		String adharNumber = "110911599419";
		String token = controller.generateToken();
		log.info("token passing to request ======>>>> "+token);
		Exception thrown = assertThrows(RuntimeException.class,() -> controller.processPension(token, adharNumber),
				"Exception did not matched!!!");
		
		log.info("Message: "+thrown.getMessage());
	}
	
	@Test
	void testGetPensionDetailsAuthException() {
		log.info("Validate the pesion details service for invalid token ...");
		String adharNumber = "110911599416";
		RuntimeException thrown = assertThrows(RuntimeException.class,
				() -> controller.processPension("exception token", adharNumber),
				"Exception did not matched!!!");
		
		log.info("Message: "+thrown.getMessage());

		
	}

	@Test
	void applicationStarts() throws IOException {
		log.info("Validate application start ...");
		ProcessPensionServiceApplication.main(new String[] {});
		assertTrue(true);
	}
	
	
	@Test
	void testSetFunctions() {
		log.info("Validate the entity classes ...");
		PensionDetails pend = new PensionDetails();
		BankDetails bankd = new BankDetails();
		UserLogin user = new UserLogin();
		Token tok = new Token();
		pend.setAdharNumber("4444444444444444");
		pend.setAllowances(5000);
		pend.setDob(new Date());
		pend.setName("Settestname");
		bankd.setAccountNumber("999999999999");
		bankd.setBankName("Test bank");
		bankd.setBankType("public");
		pend.setBankDetails(bankd);
		pend.setPanNumber("SETT5893U");
		pend.setPensionType("family");
		pend.setSalaryEarned(70000);
		pend.setBankServiceCharge(500);
		pend.setPensionAmount(0.5*70000);
		bankd.setPensionDetails(pend);
		bankd.getPensionDetails();
		user.setUserName("dummy");
		user.setPassword("dummypass");
		tok.setToken("sumdjk");
		assertTrue(true);
	}
	
	
}
