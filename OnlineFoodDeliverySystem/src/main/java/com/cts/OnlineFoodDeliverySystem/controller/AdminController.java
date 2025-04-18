package com.cts.OnlineFoodDeliverySystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.OnlineFoodDeliverySystem.model.RestaurantAdmin;
import com.cts.OnlineFoodDeliverySystem.service.RestaurantAdminService;

@Controller
public class AdminController {

	@Autowired
    private RestaurantAdminService restaurantAdminService;

    @GetMapping("/admin/register")
    public String showAdminRegistrationForm(Model model) {
        model.addAttribute("admin", new RestaurantAdmin());
        return "admin/register";
    }

    @PostMapping("/admin/register")
    public String registerAdmin(@ModelAttribute("admin") RestaurantAdmin admin, Model model) {
        if (!admin.getEmail().contains("@") || !admin.getEmail().contains(".")) {
            model.addAttribute("error", "Invalid email format");
            return "admin/register";
        }
        restaurantAdminService.registerAdmin(admin);
        model.addAttribute("success", "Restaurant registration successful! You can now log in.");
        return "admin/register";
    }

    @GetMapping("/admin/login")
    public String showAdminLoginForm() {
        return "admin/login";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin/dashboard";
    }
}
