package com.nurserymitra.controller;

import com.nurserymitra.Entity.Users;
import com.nurserymitra.Services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @PostMapping("/admin/users/save")
    public String addUsers(@ModelAttribute("users") Users users, RedirectAttributes redirect)
    {
        u1.saveUsers(users);
        redirect.addFlashAttribute("success","User Added successfully!");
        return "redirect:/admin/users";
    }
}
