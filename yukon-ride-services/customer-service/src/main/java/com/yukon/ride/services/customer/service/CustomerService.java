package com.yukon.ride.services.customer.service;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yukon.ride.services.customer.dto.CustomerRegistrationRequest;
import com.yukon.ride.services.customer.dto.CustomerResponse;
import com.yukon.ride.services.customer.model.Customer;
import com.yukon.ride.services.customer.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

	@Autowired
	private final CustomerRepository customerRepository;

	public void createNewCustomerProfile(CustomerRegistrationRequest customerRegistrationRequest) throws Exception {
		Customer customer = Customer.builder()
				.email(customerRegistrationRequest.getEmail())
				.phone(customerRegistrationRequest.getPhone())
				.firstName(customerRegistrationRequest.getFirstName())
				.lastName(customerRegistrationRequest.getLastName())
				.dob(customerRegistrationRequest.getDob())
				.gender(customerRegistrationRequest.getGender())
				.build();
		
		
		//Check if email is valid
		CustomerServiceLogic logic = new CustomerServiceLogic();
		if(logic.emailValidation(customerRegistrationRequest.getEmail())==true) {
		
			//Check if email is available
			customerRepository.save(customer);
			log.info("New customer is saved with the following details {}", customer);
		
		}else { 
			log.error("Please enter a correct email address");

			throw new Exception("Invalid email address");
			//Throw an exception
		}
			
	}

	public List<CustomerResponse> getAllCustomers() {
		List <Customer> customers= customerRepository.findAll();
		//Map each customer  to CustomerResponse Object
		return customers.stream().map(customer -> mapCustomerToCustomerResponse(customer)).toList();
	}

	private CustomerResponse mapCustomerToCustomerResponse(Customer customer) {
		return CustomerResponse.builder()
		.id(customer.getId())
		.dob(customer.getDob())
		.firstName(customer.getFirstName())
		.lastName(customer.getLastName())
		.email(customer.getEmail())
		.phone(customer.getPhone())
		.gender(customer.getGender())
		.build();
		
		
	}

	public CustomerResponse getCustomerById(Integer id) {
		Customer customer = customerRepository.findById(id).get();
		return CustomerResponse.builder()
				.id(customer.getId())
				.email(customer.getEmail())
				.dob(customer.getDob())
				.firstName(customer.getFirstName())
				.lastName(customer.getLastName())
				.phone(customer.getPhone())
				.gender(customer.getGender())
				.build();
	}

	public CustomerResponse getCustomerByEmail(String email) {
		Customer customer = customerRepository.findByEmail(email);
		return CustomerResponse.builder()
				.id(customer.getId())
				.dob(customer.getDob())
				.firstName(customer.getFirstName())
				.lastName(customer.getLastName())
				.email(customer.getEmail())
				.phone(customer.getPhone())
				.gender(customer.getGender())
				.build();
	}

	public CustomerResponse getCustomerByPhone(String phone) {
		Customer customer = customerRepository.findByPhone(phone);
		return CustomerResponse.builder()
				.id(customer.getId())
				.dob(customer.getDob())
				.firstName(customer.getFirstName())
				.lastName(customer.getLastName())
				.email(customer.getEmail())
				.phone(customer.getPhone())
				.gender(customer.getGender())
				.build();
	}
}


