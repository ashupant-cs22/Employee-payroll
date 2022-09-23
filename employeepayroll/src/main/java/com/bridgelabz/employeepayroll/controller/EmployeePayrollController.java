package com.bridgelabz.employeepayroll.controller;

import com.bridgelabz.employeepayroll.DTO.EmployeeDTO;
import com.bridgelabz.employeepayroll.DTO.ResponseDTO;
import com.bridgelabz.employeepayroll.model.Employee;
import com.bridgelabz.employeepayroll.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeePayrollController {
    @Autowired
    IEmployeePayrollService service;

    @GetMapping("/hello")
    public String getMessage(){
        String msg=service.getMessage();
        return msg;
    }
    @PostMapping("/AddEmployee")
    public ResponseEntity<ResponseDTO> AddEmployee(@Valid @RequestBody EmployeeDTO employeeDTO)
    {
        String AddEmployee=service.AddEmployee(employeeDTO);
        ResponseDTO response=new ResponseDTO("Employee Added successfully",AddEmployee);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/getEmployee/{getId}")
    public ResponseEntity<ResponseDTO> getEmployee(@PathVariable int getId)
    {
        Employee employee=service.getEmployeeDetails(getId);
        ResponseDTO response=new ResponseDTO("Call for id Successful ",employee);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/getEmployees")
    public ResponseEntity<ResponseDTO> getEmployees()
    {
        List<Employee> employees=service.getListOfEmployees();
        ResponseDTO response=new ResponseDTO("call for employees Successful",employees);
        return  new ResponseEntity<>(response,HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteEmployee(@RequestParam int id){
        service.deleteEmployee(id);
        ResponseDTO response=new ResponseDTO("deleted employee successfully  ",id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping("/updateEmployee/{getId}")
    public ResponseEntity<ResponseDTO> updateEmployee(@PathVariable int getId,@Valid @RequestBody EmployeeDTO employeedto){
        Employee newEmployee=service.updateEmployee(getId,employeedto);
        ResponseDTO response=new ResponseDTO("Updated Employee details Successfully ",newEmployee);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO> getEmployee(@PathVariable("department") String department){
        List<Employee> employees=null;
        employees=service.getEmployeeDepartment(department);
        ResponseDTO responseDTO=new ResponseDTO("Get call for id successful",employees);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

}
