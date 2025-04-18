package com.cts.OnlineFoodDeliverySystem.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

	@GetMapping("/")
    public String showDashboard() {
        return "index";
    }

    @GetMapping("/customer/register")
    public String showCustomerRegistration() {
        return "customer/register";
    }
    
    @GetMapping("/customer/login")
    public String showCustomerLogin() {
        return "customer/login";
    }

    @GetMapping("/admin/login")
    public String showAdminLogin()
    {
        return "admin/login";
    }
    
    @GetMapping("/admin/register")
    public String showAdminRegistration()
    {
        return "admin/register";
    }
}
