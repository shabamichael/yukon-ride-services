package com.yukon.ride.services.customer.model;



import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

	  @Id
	  @SequenceGenerator(
			  name="customer_id_sequence",
			  sequenceName = "customer_id_sequence")
	  @GeneratedValue(
			  strategy=GenerationType.SEQUENCE,
			  generator = "customer_id_sequence")
	private Integer id;
	private String firstName;
	private String lastName;
	
	@Column(unique=true)
	private String phone;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(unique=true)	
	private String email;
	
	@Column(nullable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING , pattern = "dd-MM-yyyy")
	private LocalDate dob ;
}
