package com.casestudy.controller;

import com.casestudy.dto.CustomerDto;
import com.casestudy.dto.EmployeeDto;
import com.casestudy.dto.UserDto;
import com.casestudy.model.customer.Customer;
import com.casestudy.model.employee.Division;
import com.casestudy.model.employee.EducationDegree;
import com.casestudy.model.employee.Employee;
import com.casestudy.model.employee.Position;
import com.casestudy.model.user.User;
import com.casestudy.service.employee.IDivisionService;
import com.casestudy.service.employee.IEducationDegreeService;
import com.casestudy.service.employee.IEmployeeService;
import com.casestudy.service.employee.IPositionService;
import com.casestudy.service.user.IUserService;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IUserService userService;

    @ModelAttribute("divisions")
    public Iterable<Division> divisions(){
        return this.divisionService.findAll();
    }

    @ModelAttribute("positions")
    public Iterable<Position> positions(){
        return this.positionService.findAll();
    }

    @ModelAttribute("educationDegrees")
    public Iterable<EducationDegree> educationDegrees(){
        return this.educationDegreeService.findAll();
    }

    @GetMapping("")
    public ModelAndView list(@RequestParam(value = "employeeName", defaultValue = "", required = false) String employeeName,
                             @PageableDefault(size = 3) Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable, employeeName);
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("employeeName", employeeName);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employeeDto", new EmployeeDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String createCustomer(@Valid @ModelAttribute EmployeeDto employeeDto,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "employee/create";
        }
        Employee employee = new Employee();
        User user = new User();
        BeanUtils.copyProperties(employeeDto, employee);
        BeanUtils.copyProperties(employeeDto.getUserDto(),user);
        employee.setUser(user);
        this.userService.save(user);
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id,Model model){
        Employee employee = this.employeeService.findById(id).orElse(null);
        EmployeeDto employeeDto = new EmployeeDto();
        if(employee != null){
            BeanUtils.copyProperties(employee,employeeDto);
        }
        return "employee/edit";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam Long idEmployee) {
        Employee employee = this.employeeService.findById(idEmployee).orElse(null);
        if (employee != null) {
            employee.setDeleteFlag(true);
            this.employeeService.save(employee);
        }
        return "redirect:/employee";
    }

    @PostMapping("/deleteMultiple")
    public String deleteMultiCustomer(@RequestParam String idEmployeeMultiple) {
        String[] arr = idEmployeeMultiple.split(",");
        for (int i = 0; i < arr.length; i++) {
            Employee employee = this.employeeService.findById(Long.valueOf(arr[i])).orElse(null);
            if(employee!=null){
                employee.setDeleteFlag(true);
                this.employeeService.save(employee);
            }
        }
        return "redirect:/employee";
    }
}
