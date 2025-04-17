package com.cts.OnlineFoodDeliverySystem.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class Home {

	@GetMapping("/")
    public String showDashboard() {
        return "index";
    }

    @GetMapping("/customer/register")
    public String showCustomerRegistration() {
        return "customer/register";
    }

    @GetMapping("/admin/login")
    public String showAdminLogin()
    {
        return "admin/login";
    }
}
