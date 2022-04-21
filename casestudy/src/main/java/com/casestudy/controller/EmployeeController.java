package com.casestudy.controller;

import com.casestudy.dto.EmployeeDto;
import com.casestudy.model.employee.Employee;
import com.casestudy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("")
    public ModelAndView list(@RequestParam(value = "employeeName", defaultValue = "", required = false) String employeeName,
                             @RequestParam(value = "employeePhone", defaultValue = "", required = false) String employeePhone,
                             @RequestParam(value = "positionId", defaultValue = "", required = false) String positionId,
                             @PageableDefault(size = 3) Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable, employeeName, employeePhone, positionId);
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("employeeName", employeeName);
        modelAndView.addObject("employeePhone", employeePhone);
        modelAndView.addObject("positionId", positionId);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employeeDto", new EmployeeDto());
        return modelAndView;
    }
}
