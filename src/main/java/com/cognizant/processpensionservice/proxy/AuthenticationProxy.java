package com.cognizant.processpensionservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth-service", url = "localhost:8084")
public interface AuthenticationProxy {

	@GetMapping("/validate")
	//@ApiOperation(value = "tokenValidation", notes = "returns boolean after validating JWT", httpMethod = "GET", response = ResponseEntity.class)
	public //ResponseEntity<Object> 
	boolean getValidity(
			//@ApiParam(name = "token", value = "JWT for current user")
			@RequestHeader(name = "Authorization") String token1);
	
}
