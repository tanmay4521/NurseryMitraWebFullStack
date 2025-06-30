package com.nurserymitra.controller;

import com.nurserymitra.Entity.ContactUsForm;
import com.nurserymitra.Services.ContactUsFormService;
import com.nurserymitra.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactUsFormController {
    @Autowired
    ContactUsFormService c1;

    @PostMapping("/submitContact")
    public String submitForm(@ModelAttribute ContactUsForm c, RedirectAttributes redirect)
    {
        c1.submitForm(c);
        redirect.addFlashAttribute("success","Query Submitted Successfully!");
        return "redirect:/contactus";
    }
}
