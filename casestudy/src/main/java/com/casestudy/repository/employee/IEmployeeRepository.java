package com.casestudy.repository.employee;

import com.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "select * from employee where employee.delete_flag = 0 and employee.employee_name like concat('%',:employee_name,'%')", nativeQuery = true)
    Page<Employee> findAllEmployee(Pageable pageable, @Param("employee_name") String employee_name);

    @Query(value = "select * from employee where employee.delete_flag = 0 ", nativeQuery = true)
    List<Employee> findAllEmployee();
}
