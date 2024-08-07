package com.votingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.votingSystem.entity.Admin;
import com.votingSystem.entity.AdminLogin;
import com.votingSystem.service.AdminService;

import jakarta.validation.Valid;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    

    @GetMapping("/home")
    public String showHomePage() {
        return "home"; // This will render home.html
    }

    @GetMapping("/saveAdmin")
    public String showRegistrationForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "adminregister";
    }

    @PostMapping("/goadminregister")
    public String registerAdmin(@Valid @ModelAttribute Admin admin, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "adminregister";
        }
        adminService.saveAdmin(admin);
        return "redirect:/adminlogin"; // Ensure this path matches your configuration
    }

    @GetMapping("/adminlogin")
    public String showLoginForm(Model model) {
        model.addAttribute("adminlogin", new AdminLogin());
        return "adminlogin";
    }

    @PostMapping("/validateAdminLogin")
    public String validateAdminLogin(@ModelAttribute AdminLogin adminLogin, Model model) {
        Admin admin = adminService.findByUsernameAndPassword(adminLogin.getUsername(), adminLogin.getPassword());
        if (admin != null) {
            model.addAttribute("admin", admin);
            return "redirect:/adminDashboard"; // This will look for adminDashboard.html
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "adminlogin";
        }
    }
}
