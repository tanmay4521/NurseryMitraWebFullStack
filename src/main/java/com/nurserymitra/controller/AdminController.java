package com.nurserymitra.controller;

import com.nurserymitra.Entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController
{

    @GetMapping("/admin/dashboard")
    public String adminPanel() {
        return "dashboard";
    }
    @GetMapping("/admin/users")
    public String manageUsers(Model m){
        m.addAttribute("users",new Users());
        return "users";
    }
}
