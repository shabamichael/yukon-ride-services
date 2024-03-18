package com.yukon.ride.services.customer.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yukon.ride.services.customer.model.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegistrationRequest {
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private Gender gender;
	 private LocalDate dob;}
