package com.casestudy.controller;

import com.casestudy.dto.CustomerDto;
import com.casestudy.model.customer.Customer;
import com.casestudy.model.customer.CustomerType;
import com.casestudy.service.customer.ICustomerService;
import com.casestudy.service.customer.ICustomerTypeService;
import com.casestudy.service.customer.ICustomerUseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @ModelAttribute("customerTypes")
    public Iterable<CustomerType> customerTypes() {
        return customerTypeService.findAll();
    }

    @GetMapping("")
    public ModelAndView list(@RequestParam(value = "customerName", defaultValue = "", required = false) String customerName,
                             @PageableDefault(size = 3) Pageable pageable) {
        Page<Customer> customers = customerService.findAll(pageable, customerName);
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("customerName", customerName);

        return modelAndView;
    }

    @GetMapping("/useService")
    public ModelAndView listCustomer(@PageableDefault(size = 3) Pageable pageable) {
        Page<ICustomerUseService> pages = customerService.findAllCustomerUseServicePage(PageRequest.of(pageable.getPageNumber(),1));
        ModelAndView modelAndView = new ModelAndView("customer/list2");
        modelAndView.addObject("customers", pages);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customerDto", new CustomerDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String createCustomer(@Valid @ModelAttribute CustomerDto customerDto,
                                 BindingResult bindingResult, Model model) {
        customerDto.setCustomerService(customerService);
        customerDto.validate(customerDto,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerTypes", this.customerTypeService.findAll());
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String editCustomer(@PathVariable Long id, Model model) {
        Customer customer = this.customerService.findById(id).orElse(null);
        CustomerDto customerDto = new CustomerDto();
        if (customer != null) {
            BeanUtils.copyProperties(customer, customerDto);
            model.addAttribute("customerDto", customerDto);
            model.addAttribute("customerTypes", this.customerTypeService.findAll());
        }
        return "customer/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@Valid @ModelAttribute CustomerDto customerDto,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerDto", customerDto);
            model.addAttribute("customerTypes", this.customerTypeService.findAll());
            return "customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.customerService.save(customer);
        return "redirect:/customer";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Long idCustomer) {
        Customer customer = this.customerService.findById(idCustomer).orElse(null);
        if (customer != null) {
            customer.setDeleteFlag(true);
            this.customerService.save(customer);
        }
        return "redirect:/customer";
    }

    @PostMapping("/deleteMultiple")
    public String deleteMultiCustomer(@RequestParam String idCustomerMultiple) {
        String[] arr = idCustomerMultiple.split(",");
        for (int i = 0; i < arr.length; i++) {
            Customer customer = this.customerService.findById(Long.valueOf(arr[i])).orElse(null);
            if(customer!=null){
                customer.setDeleteFlag(true);
                this.customerService.save(customer);
            }
        }
        return "redirect:/customer";
    }
}
