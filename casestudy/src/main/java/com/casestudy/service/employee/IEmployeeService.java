package com.casestudy.service.employee;

import com.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService extends IGeneralService<Employee>{
    Page<Employee> findAll (Pageable pageable, String employee_name);

    List<Employee> findAllEmployee();
}
