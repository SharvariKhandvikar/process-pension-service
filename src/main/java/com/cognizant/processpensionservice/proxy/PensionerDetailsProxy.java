package com.cognizant.processpensionservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.processpensionservice.bean.PensionDetails;

@FeignClient(name = "pensioner-details", url = "${PENSIONER_DETAILS_SERVICE_PROXY:http://localhost:8000}")
public interface PensionerDetailsProxy {
	
	@GetMapping("/pensioner-details/pensionerdetails/{adharNumber}")
	public PensionDetails getPensionerDetailsByAdhar(@RequestHeader(name = "Authorization") String token,
			@PathVariable("adharNumber") String adharNumber);
	


}
