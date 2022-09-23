package com.bridgelabz.employeepayroll.model;

import com.bridgelabz.employeepayroll.DTO.EmployeeDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@ToString


public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="id")
    private int id;
    private String gender;
    @Column(name="name")
    private String employeeName;
    private String department;
    private long salary;
    private String email;
    private LocalDate Date;
    private String profilePic;
    private String note;

    @ElementCollection
    @CollectionTable(name="employee_Department",joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String>departments;


    public Employee(EmployeeDTO employeeDto) {
        this.gender = employeeDto.getGender();
        this.employeeName = employeeDto.getEmployeeName();
        this.department=employeeDto.getDepartment();
        this.salary = employeeDto.getSalary();
        this.email = employeeDto.getEmail();
        Date = employeeDto.getDate();
        this.profilePic = employeeDto.getProfilePic();
        this.note = employeeDto.getNote();
    }
}
