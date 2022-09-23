package com.bridgelabz.employeepayroll.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.intellij.lang.annotations.Pattern;;
import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor

public class EmployeeDTO {
    @Pattern(regexp = "male|female", message = "Gender needs to be male or female ")
    private String gender;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Inavlid name...!")
    private String employeeName;

    @NotNull(message = "department name should not be null")
    private String department;

    @Min(value = 10000,message = "Minimum salary should be more then 10000")
    private long salary;

    private String email;

    @JsonFormat(pattern = "yyyy/MM/dd")
    @NotNull(message = "StartDate Should not be Empty")
    private LocalDate Date;

    private String profilePic;

    @NotBlank(message = "Note cannot be blank")
    private String note;


}
