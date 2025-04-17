package com.cts.OnlineFoodDeliverySystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.OnlineFoodDeliverySystem.model.Customer;
import com.cts.OnlineFoodDeliverySystem.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public void registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customer.setPassword(passwordEncoder.encode(customer.getPassword())); // Encode the password
		customerRepository.save(customer);
		
	}

	@Override
	public Optional<Customer> findCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return customerRepository.findByEmail(email);
	}

}
