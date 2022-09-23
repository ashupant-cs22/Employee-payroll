package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.DTO.EmployeeDTO;
import com.bridgelabz.employeepayroll.model.Employee;
import java.util.List;

public interface IEmployeePayrollService {

    String getMessage();

    Employee getEmployeeDetails(int getId);

    List<Employee> getListOfEmployees();

    void deleteEmployee(int id);

    Employee updateEmployee(int getId, EmployeeDTO employeedto);

    String AddEmployee(EmployeeDTO employeeDTO);

    List<Employee> getEmployeeDepartment(String department);

}
