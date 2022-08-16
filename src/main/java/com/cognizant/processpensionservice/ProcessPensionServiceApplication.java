package com.cognizant.processpensionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.cognizant.processpensionservice.proxy.AuthenticationProxy;
import com.cognizant.processpensionservice.proxy.PensionerDetailsProxy;

@SpringBootApplication
@EnableFeignClients(clients = {PensionerDetailsProxy.class, AuthenticationProxy.class})
//@EnableDiscoveryClient
public class ProcessPensionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessPensionServiceApplication.class, args);
	}

}
