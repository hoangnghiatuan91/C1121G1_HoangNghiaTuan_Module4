package com.casestudy.controller;

import com.casestudy.dto.ContractDto;
import com.casestudy.dto.CustomerDto;
import com.casestudy.model.contract.Contract;
import com.casestudy.model.customer.Customer;
import com.casestudy.model.employee.Division;
import com.casestudy.model.employee.Employee;
import com.casestudy.model.service.Services;
import com.casestudy.service.contract.IContractService;
import com.casestudy.service.customer.ICustomerService;
import com.casestudy.service.employee.IEmployeeService;
import com.casestudy.service.service.IServicesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IServicesService servicesService;

    @ModelAttribute("employees")
    public Iterable<Employee> employees(){
        return this.employeeService.findAll();
    }

    @ModelAttribute("customerSend")
    public Iterable<Customer> customers(){
        return this.customerService.findAll();
    }

    @ModelAttribute("serviceSend")
    public Iterable<Services> services(){
        return this.servicesService.findAll();
    }

    @Autowired
    private IContractService contractService;

    @GetMapping("")
    public ModelAndView list(@PageableDefault(size = 3) Pageable pageable) {
        Page<Contract> contracts = contractService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/contract/list");
        modelAndView.addObject("contracts", contracts);
        return modelAndView;
    }

    @GetMapping("/create")
    public String createContract(Model model){
        model.addAttribute("contractDto",new ContractDto());
        return "contract/create";
    }

    @PostMapping("/save")
    public String createContract(@Valid @ModelAttribute ContractDto contractDto,
                                 BindingResult bindingResult, Model model) {
        contractDto.validate(contractDto,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "contract/create";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contractService.save(contract);
        return "redirect:/contract";
    }
}
