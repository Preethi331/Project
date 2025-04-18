package com.cts.OnlineFoodDeliverySystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.OnlineFoodDeliverySystem.model.Customer;
import com.cts.OnlineFoodDeliverySystem.service.CustomerService;

@Controller
public class CustomerController {

	 @Autowired
	    private CustomerService customerService;

	    @GetMapping("/customer/register")
	    public String showCustomerRegistrationForm(Model model) {
	        model.addAttribute("customer", new Customer());
	        return "customer/register";
	    }

	    @PostMapping("/customer/register")
	    public String registerCustomer(@ModelAttribute("customer") Customer customer, Model model) {
	        if (!customer.getEmail().contains("@") || !customer.getEmail().contains(".")) {
	            model.addAttribute("error", "Invalid email format");
	            return "customer/register";
	        }
	        customerService.registerCustomer(customer);
	        model.addAttribute("success", "Registration successful! You can now log in.");
	        return "customer/login"; // Or changed here
	    }

	    @GetMapping("/customer/login")
	    public String showCustomerLoginForm() {
	        return "customer/login";
	    }

	    @GetMapping("/customer/dashboard")
	    public String customerDashboard() {
	        return "customer/dashboard";
	    }
}
