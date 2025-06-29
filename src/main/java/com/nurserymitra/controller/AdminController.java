package com.nurserymitra.controller;

import com.nurserymitra.Entity.Users;
import com.nurserymitra.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController
{
    @Autowired
    UserService u1;
    @GetMapping("/admin/dashboard")
    public String adminPanel() {
        return "dashboard";
    }
    @GetMapping("/admin/users")
    public String manageUsers(Model m){
        m.addAttribute("users",new Users());
        List<Users> list=u1.getAllUsers();
        m.addAttribute("user",list);
        return "users";
    }
}
