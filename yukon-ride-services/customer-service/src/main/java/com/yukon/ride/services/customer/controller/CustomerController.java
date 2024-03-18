package com.yukon.ride.services.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yukon.ride.services.customer.dto.CustomerRegistrationRequest;
import com.yukon.ride.services.customer.dto.CustomerResponse;
import com.yukon.ride.services.customer.model.Customer;
import com.yukon.ride.services.customer.service.CustomerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController {
	
	@Autowired
	private final CustomerService customerService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public  void createNewCustomerProfile(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) throws Exception {
		customerService.createNewCustomerProfile(customerRegistrationRequest);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List <CustomerResponse> getAllCustomers(){
		return customerService.getAllCustomers();
		
	}
	
	@GetMapping(path = "/id/{id}")
	@ResponseStatus
	public CustomerResponse getCustomerById(@PathVariable("id") Integer id) {
		return customerService.getCustomerById(id);
	}
	
	@GetMapping(path = "/email/{email}")
	@ResponseStatus
	public CustomerResponse getCustomerByEmail(@PathVariable("email") String email) {
		return customerService.getCustomerByEmail(email);
	}
	
	@GetMapping(path = "/phone/{phone_no}")
	@ResponseStatus
	public CustomerResponse getCustomerByphone(@PathVariable("phone_no") String phone_no) {
		return customerService.getCustomerByPhone(phone_no);
	}
}