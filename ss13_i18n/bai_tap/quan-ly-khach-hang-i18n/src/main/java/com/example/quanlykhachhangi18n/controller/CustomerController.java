package com.example.quanlykhachhangi18n.controller;

import com.example.quanlykhachhangi18n.model.Customer;
import com.example.quanlykhachhangi18n.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("/")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("customerList",customerService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("customer",new Customer());
        return "/create";
    }

    @PostMapping("/create-customer")
    public String createCustomer(@ModelAttribute Customer customer, RedirectAttributes redirect){
        customerService.save(customer);
        redirect.addFlashAttribute("message","Success");
        return "redirect:/";

    }
}