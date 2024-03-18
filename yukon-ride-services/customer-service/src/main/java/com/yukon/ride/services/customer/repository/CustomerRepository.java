package com.yukon.ride.services.customer.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yukon.ride.services.customer.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(
			  value = "SELECT * FROM Customer c WHERE c.email = ?1", 
			  nativeQuery = true)
		Customer findByEmail(String email);

	@Query(
			  value = "SELECT * FROM Customer c WHERE c.phone = ?1", 
			  nativeQuery = true)
		Customer findByPhone(String phone);

}
