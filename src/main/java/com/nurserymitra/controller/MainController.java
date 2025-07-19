package com.nurserymitra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.nurserymitra.Entity.Customers;
import com.nurserymitra.Entity.Users;
import com.nurserymitra.Services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String loginPage(Model model) {
        model.addAttribute("user", new Users());
        return "login";
    }
  
    @PostMapping("/index")
    public String loginSubmit(@ModelAttribute("user") Users user, Model model, HttpSession session) {
        Users existingUser = userService.validateUser(user.getEmail(), user.getPassword());
        String role=existingUser.getRole();
        if (existingUser != null) {
            session.setAttribute("loggedInUserId", existingUser.getId());
            if(role.equals("ADMIN"))
            {
                return "redirect:/admin/dashboard";
            }
            else {
                return "redirect:/index";
            }
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
    @GetMapping("/about")
    public String aboutPage()
    {
    	return "about";
    }
    @GetMapping("/index")
    public String homePage(Model m,HttpSession session)
    {
        Integer userId = (Integer) session.getAttribute("loggedInUserId");
        if(userId==null)
        {
            return "redirect:/";
        }
        Users user = userService.getUserById(userId);
        if (user == null) {
            return "redirect:/";
        }
        m.addAttribute("user", user);
        return "index";
    }
    @GetMapping("/contactus")
    public String contactUsPage()
    {
    	return "contact_us";
    }
    @GetMapping("/profile")
    public String profilePage(Model model, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("loggedInUserId");

        if (userId == null) {
            return "redirect:/";
        }

        Users user = userService.getUserById(userId);
        if (user == null) {
            return "redirect:/";
        }

        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpSession session)
    {
        session.invalidate();
        return "redirect:/";
    }
}
