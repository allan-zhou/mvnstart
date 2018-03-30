package com.zhoujl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
    @RequestMapping("/hello")
    public String hello(Model model) {
         
        model.addAttribute("greeting", "Hello Spring MVC");
         
        return "hello";
    }
    
    
    @RequestMapping("/create")
    public String create(Model model) {
         
        model.addAttribute("title", "Create");
         
        return "create";
    }
    
    @RequestMapping("/details")
    public String details(Model model) {
         
        model.addAttribute("title", "Details");
         
        return "edit";
    }
}
