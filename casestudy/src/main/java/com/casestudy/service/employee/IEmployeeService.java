package com.casestudy.service.employee;

import com.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService extends IGeneralService<Employee>{
    Page<Employee> findAll (Pageable pageable, String employee_name, String employee_phone, String position_id);
}
