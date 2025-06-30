package com.nurserymitra.controller;

import com.nurserymitra.Entity.Users;
import com.nurserymitra.Services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AdminController
{
    @Autowired
    UserService u1;
    @GetMapping("/admin/dashboard")
    public String adminPanel(Model m)
    {
        long userCount=u1.getUserCount();
        m.addAttribute("userCount",userCount);
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
    @GetMapping("/admin/users/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, RedirectAttributes redirect)
    {
        u1.deleteUserById(id);
        redirect.addFlashAttribute("success","User Deleted Successfully!");
        return "redirect:/admin/users";
    }
    @PutMapping("/admin/users/edit/{id}")
    public String updateUser(@PathVariable("id") int id,@ModelAttribute("users") Users u,RedirectAttributes redirect)
    {
        u.setId(id);
        u1.updateUser(u);
        redirect.addFlashAttribute("success","User Updated Successfully!");
        return "redirect:/admin/users";
    }
    @PostMapping("/admin/users/update")
    public String UpdateUserForm(@ModelAttribute("users") Users u, RedirectAttributes redirect)
    {
        u1.saveUsers(u);
        redirect.addFlashAttribute("success", "User Updated Successfully!");
        return "redirect:/admin/users";
    }
    @GetMapping("/admin/contacts")
    public String contactUsQueries(Model m)
    {
        m.addAttribute("user",new Users());
        return "contact_queries";
    }
}
